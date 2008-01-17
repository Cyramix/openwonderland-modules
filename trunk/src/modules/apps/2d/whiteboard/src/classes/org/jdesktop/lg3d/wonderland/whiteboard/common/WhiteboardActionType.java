/**
 * Project Looking Glass
 *
 * $RCSfile: WhiteboardActionType.java,v $
 *
 * Copyright (c) 2004-2007, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * $Revision: 1.1 $
 * $Date: 2007/09/21 16:54:20 $
 * $State: Exp $
 */
package org.jdesktop.lg3d.wonderland.whiteboard.common;

/**
 *
 * @author nsimpson
 */
public interface WhiteboardActionType {
    public enum ActionType {
        COMMAND,
        TOOL,
        COLOR
    };
    
    public static final ActionType COMMAND = ActionType.COMMAND;
    public static final ActionType TOOL = ActionType.TOOL;
    public static final ActionType COLOR = ActionType.COLOR;
}
