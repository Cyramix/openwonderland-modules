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
package org.jdesktop.wonderland.modules.marbleous.common;

import java.util.ArrayList;

/**
 * The Singleton Track Manager.
 *
 * @author deronj
 */
public class TrackManager {

    private static TrackManager trackManager;

    public static TrackManager getTrackManager() {
        if (trackManager == null) {
            trackManager = new TrackManager();
        }
        return trackManager;
    }

    private ArrayList supportedTypes = new ArrayList();

    private TrackManager() {
        supportedTypes.add(new LoopTrackSegmentType());
        supportedTypes.add(new RightTurnTrackSegmentType());
    }

    public Iterable<TrackSegmentType> getTrackSegmentTypes() {
        return supportedTypes;
    }


}
