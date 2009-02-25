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
package org.jdesktop.wonderland.modules.whiteboard.client;

import java.awt.Image;
import org.jdesktop.wonderland.client.cell.registry.annotation.CellFactory;
import org.jdesktop.wonderland.client.cell.registry.spi.CellFactorySPI;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.modules.whiteboard.common.cell.WhiteboardSVGCellServerState;

/**
 * The cell factory for the whiteboard
 * 
 * @author nsimpson
 */
@CellFactory
public class WhiteboardCellFactory implements CellFactorySPI {

    public String[] getExtensions() {
        return new String[]{};
    }

    public <T extends CellServerState> T getDefaultCellServerState() {
        WhiteboardSVGCellServerState cellServerState = new WhiteboardSVGCellServerState();

        return (T) cellServerState;
    }

    public String getDisplayName() {
        return "Whiteboard (SVG)";
    }

    public Image getPreviewImage() {
        return null;
    }
}
