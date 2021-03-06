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
 * are Copyright (C) 2004-2010. All Rights Reserved.
 *
 * Contributor(s): Nathan L. Fiedler.
 *
 * $Id$
 */

/**
 * Test code for the Processes unit test.
 *
 * @author Nathan Fiedler
 */
public class ProcessesTestCode {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("output 1");
            System.err.println("error 1");
            System.out.println("output 2");
            System.err.println("error 2");
            System.out.println("output 3");
            System.err.println("error 3");
            System.out.println("output 4");
            System.err.println("error 4");
        } else {
            if (args[0].equals("--out")) {
                System.out.println("output 1");
                System.out.println("output 2");
                System.out.println("output 3");
                System.out.println("output 4");
            } else if (args[0].equals("--err")) {
                System.err.println("error 1");
                System.err.println("error 2");
                System.err.println("error 3");
                System.err.println("error 4");
            } else if (args[0].equals("--nop")) {
                // Output nothing at all.
            }
        }
    }
}
