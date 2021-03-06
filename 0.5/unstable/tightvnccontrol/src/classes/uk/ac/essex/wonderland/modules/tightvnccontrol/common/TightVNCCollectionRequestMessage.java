/**
 * Open Wonderland
 *
 * Copyright (c) 2011, Open Wonderland Foundation, All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * The Open Wonderland Foundation designates this particular file as
 * subject to the "Classpath" exception as provided by the Open Wonderland
 * Foundation in the License file that accompanied this code.
 */

package uk.ac.essex.wonderland.modules.tightvnccontrol.common;

import org.jdesktop.wonderland.common.messages.Message;

/**
 * When the server receives this it should return a TightVNCCollectionResponseMessage
 * containing the IDs of the cells that are TightVNC Viewer cells
 * @author Bernard Horan
 */
public class TightVNCCollectionRequestMessage extends Message {

    public TightVNCCollectionRequestMessage() {
    }

}
