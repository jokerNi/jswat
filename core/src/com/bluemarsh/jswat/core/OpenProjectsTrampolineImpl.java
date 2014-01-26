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
 * are Copyright (C) 2006. All Rights Reserved.
 *
 * Contributor(s): Nathan L. Fiedler.
 *
 * $Id: OpenProjectsTrampolineImpl.java 15 2007-06-03 00:01:17Z nfiedler $
 */

package com.bluemarsh.jswat.core;

import java.beans.PropertyChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.modules.project.uiapi.OpenProjectsTrampoline;

/**
 * Satisfy a requirement of the projectuiapi module that there be a
 * trampoline for the open projects at all times.
 *
 * @author  Nathan Fiedler
 */
public class OpenProjectsTrampolineImpl implements OpenProjectsTrampoline {

    public void addPropertyChangeListenerAPI(PropertyChangeListener propertyChangeListener) {
    }

    public void closeAPI(Project[] project) {
    }

    public Project getMainProject() {
        return null;
    }

    public Project[] getOpenProjectsAPI() {
        return new Project[0];
    }

    public void openAPI(Project[] project, boolean b) {
    }

    public void removePropertyChangeListenerAPI(PropertyChangeListener propertyChangeListener) {
    }

    public void setMainProject(Project project) {
    }
}