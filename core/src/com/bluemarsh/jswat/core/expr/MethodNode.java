/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is the JSwat Core Module. The Initial Developer of the
 * Software is Nathan L. Fiedler. Portions created by Nathan L. Fiedler
 * are Copyright (C) 2002-2010. All Rights Reserved.
 *
 * Contributor(s): Nathan L. Fiedler.
 *
 * $Id$
 */
package com.bluemarsh.jswat.core.expr;

import com.bluemarsh.jswat.parser.node.Token;
import com.bluemarsh.jswat.core.util.AmbiguousMethodException;
import com.bluemarsh.jswat.core.util.Classes;
import com.bluemarsh.jswat.core.util.Strings;
import com.bluemarsh.jswat.core.util.Types;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassType;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.Location;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StackFrame;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.openide.util.NbBundle;

/**
 * Class MethodNode represents a method invocation. Its type is the return
 * type of the method being invoked.
 *
 * @author  Nathan Fiedler
 */
class MethodNode extends OperatorNode implements JoinableNode {

    /** The name of the method. */
    private String methodName;
    /** The class or object on which to invoke the method. */
    private Node classOrObject;
    /** The method that was invoked; used for determining this node's type. */
    private Method method;

    /**
     * Constructs a MethodNode associated with the given token and name.
     *
     * @param  node  lexical token.
     * @param  name  name of the method.
     */
    MethodNode(Token node, String name) {
        super(node);
        methodName = name;
    }

    /**
     * Constructs a MethodNode associated with the given token, object or
     * class, and method name.
     *
     * @param  node    lexical token.
     * @param  object  the object or class on which to invoke the method.
     * @param  name    name of the method.
     */
    MethodNode(Token node, Node object, String name) {
        super(node);
        classOrObject = object;
        methodName = name;
    }

    @Override
    protected Object eval(EvaluationContext context)
            throws EvaluationException {

        // Get the preliminaries out of the way first.
        ThreadReference thread = context.getThread();
        if (thread == null) {
            throw new EvaluationException(
                    NbBundle.getMessage(MethodNode.class, "error.method.thread.set"));
        }
        int frameIdx = context.getFrame();
        VirtualMachine vm = thread.virtualMachine();

        // Get the object or class on which to invoke the method.
        ObjectReference object = null;
        ReferenceType clazz = null;
        if (classOrObject == null) {
            // No object or class was given, default to the class containing
            // the current location.
            try {
                if (thread.frameCount() == 0) {
                    throw new EvaluationException(
                            NbBundle.getMessage(MethodNode.class, "error.method.thread.stack"));
                }
                StackFrame frame = thread.frame(frameIdx);
                object = frame.thisObject();

                if (object == null) {
                    Location location = context.getLocation();
                    if (location == null) {
                        throw new EvaluationException(
                                NbBundle.getMessage(MethodNode.class, "error.method.location"));
                    }
                    clazz = location.declaringType();
                    if (clazz == null) {
                        throw new EvaluationException(
                                NbBundle.getMessage(MethodNode.class, "error.method.location"));
                    }
                } else {
                    clazz = object.referenceType();
                }
            } catch (IncompatibleThreadStateException itse) {
                throw new EvaluationException(
                        NbBundle.getMessage(MethodNode.class, "error.thread.state"));
            }

        } else {
            // Evaluate the class or object node and determine what it is.
            Object coo = classOrObject.evaluate(context);
            if (coo instanceof ObjectReference) {
                object = (ObjectReference) coo;
                clazz = object.referenceType();
            } else if (coo instanceof ReferenceType) {
                clazz = (ReferenceType) coo;
            } else if (classOrObject instanceof LiteralNode
                       && coo instanceof String) {
                object = (ObjectReference) Types.mirrorOf(coo, vm);
                clazz = object.referenceType();
            }
            // else: reftype will be null, and...
            if (clazz == null) {
                String msg = NbBundle.getMessage(
                        MethodNode.class, "error.method.name", coo);
                throw new EvaluationException(msg);
            }
        }

        // Get the list of method arguments and their types.
        int count = childCount();
        List<Object> argumentObjects = new ArrayList<Object>(count);
        List<String> argumentTypes = new ArrayList<String>(count);
        for (int ii = 0; ii < count; ii++) {
            Node n = getChild(ii);
            Object o = n.evaluate(context);
            argumentObjects.add(o);
            String t = n.getType(context);
            if (t == null) {
                // For method arguments, 'null' is a special type.
                argumentTypes.add("<null>");
            } else {
                argumentTypes.add(t);
            }
        }

        // Locate the named method in the resolved class.
        try {
            method = Classes.findMethod(
                    clazz, methodName, argumentTypes, true, true);
        } catch (AmbiguousMethodException ame) {
            throw new EvaluationException(NbBundle.getMessage(
                    MethodNode.class, "error.method.ambiguous", methodName,
                    Strings.listToString(argumentTypes)));
        } catch (InvalidTypeException ite) {
            throw new EvaluationException(NbBundle.getMessage(
                    MethodNode.class, "error.method.argument", ite.getMessage()));
        } catch (NoSuchMethodException nsme) {
            throw new EvaluationException(NbBundle.getMessage(
                    MethodNode.class, "error.method.method", methodName,
                    Strings.listToString(argumentTypes)));
        }

        // Convert the arguments to JDI objects.
        List<Value> arguments = new ArrayList<Value>(count);
        for (Object o : argumentObjects) {
            Value v = Types.mirrorOf(o, vm);
            arguments.add(v);
        }

        // Invoke the method and return the results.
        try {
            return Classes.invokeMethod(object, (ClassType) clazz, thread,
                    method, arguments);
        } catch (ExecutionException ee) {
            Throwable cause = ee.getCause();
            if (cause instanceof IncompatibleThreadStateException) {
                String msg = NbBundle.getMessage(MethodNode.class,
                        "error.thread.state");
                throw new EvaluationException(msg);
            }
            throw new EvaluationException(cause);
        }
    }

    @Override
    public int precedence() {
        return 1;
    }

    @Override
    protected String type(EvaluationContext context)
            throws EvaluationException {

        // Force the evaluation to happen, if it hasn't already, so we
        // get the method reference.
        evaluate(context);
        try {
            return method.returnType().signature();
        } catch (ClassNotLoadedException cnle) {
            throw new EvaluationException(NbBundle.getMessage(
                    MethodNode.class, "error.method.class", cnle.className()));
        }
    }
}
