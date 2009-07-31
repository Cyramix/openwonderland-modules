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
package org.jdesktop.wonderland.modules.cmu.common.messages.serverclient;

import org.jdesktop.wonderland.common.cell.CellID;
import org.jdesktop.wonderland.common.cell.messages.CellMessage;

/**
 * Message containing information about a change in playback speed for a
 * CMU scene.
 * @author kevin
 */
public class PlaybackSpeedChangeMessage extends CellMessage {

    private float playbackSpeed;

    /**
     * Standard constructor.
     * @param cellID ID of the relevant cell
     * @param speed
     */
    public PlaybackSpeedChangeMessage(CellID cellID, float speed) {
        super(cellID);
        this.setPlaybackSpeed(speed);
    }

    /**
     * Get the playback speed.
     * @return Current playback speed
     */
    public float getPlaybackSpeed() {
        return playbackSpeed;
    }

    /**
     * Set the playback speed.
     * @param speed New playback speed
     */
    public void setPlaybackSpeed(float speed) {
        this.playbackSpeed = speed;
    }
}
