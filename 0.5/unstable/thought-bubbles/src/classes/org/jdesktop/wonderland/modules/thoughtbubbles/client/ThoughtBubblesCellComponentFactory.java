/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * Sun designates this particular file as subject to the "Classpath"
 * exception as provided by Sun in the License file that accompanied
 * this code.
 */

package org.jdesktop.wonderland.modules.thoughtbubbles.client;

import java.util.logging.Logger;
import org.jdesktop.wonderland.client.cell.registry.annotation.CellComponentFactory;
import org.jdesktop.wonderland.client.cell.registry.spi.CellComponentFactorySPI;
import org.jdesktop.wonderland.common.cell.state.CellComponentServerState;
import org.jdesktop.wonderland.modules.thoughtbubbles.common.ThoughtBubblesComponentServerState;

@CellComponentFactory
public class ThoughtBubblesCellComponentFactory implements CellComponentFactorySPI{

    private static final Logger logger = Logger.getLogger(ThoughtBubblesCellComponentFactory.class.getName());

    public String[] getExtensions() {
        return null;
    }

    public String getDisplayName() {
        logger.warning("IN DISPLAY NAME");
        return "Thought Bubbles";
    }

    public <T extends CellComponentServerState> T getDefaultCellComponentServerState() {
        return (T)new ThoughtBubblesComponentServerState();
    }

    public String getDescription() {
        return "Gives avatars within the cell a mechanism for posting their thoughts/comments/questions";
    }

}