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
 * The Original Software is JSwat. The Initial Developer of the Original
 * Software is Nathan L. Fiedler. Portions created by Nathan L. Fiedler
 * are Copyright (C) 2002-2005. All Rights Reserved.
 *
 * Contributor(s): Nathan L. Fiedler.
 *
 * $Id$
 */

package com.bluemarsh.jswat.command;

import org.openide.util.NbBundle;

/**
 * Thrown when a command was not given the required number of arguments.
 *
 * @author  Nathan Fiedler
 */
public class MissingArgumentsException extends CommandException {
    /** silence the compiler warnings */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with a default detail message.
     */
    public MissingArgumentsException() {
        super(NbBundle.getMessage(MissingArgumentsException.class,
                "ERR_MissingArguments"));
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param  message  the detail message.
     */
    public MissingArgumentsException(String message) {
        super(message);
    }
}
