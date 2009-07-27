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
package org.jdesktop.wonderland.modules.eventrecorder.server;

import org.jdesktop.wonderland.server.cell.view.ViewCellMO;
import com.sun.sgs.app.ManagedObject;
import com.sun.sgs.app.ManagedReference;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.wonderland.common.InternalAPI;
import org.jdesktop.wonderland.common.cell.CellID;
import org.jdesktop.wonderland.server.cell.CellDescription;
import org.jdesktop.wonderland.server.cell.ViewCellCacheMO;
import org.jdesktop.wonderland.server.spatial.UniverseManagerFactory;

/**
 * Container for the cell cache for an event recorder.
 *
 * @author paulby
 * Bernard Horan
 */
@InternalAPI
public class EventRecorderCellCacheMO extends ViewCellCacheMO implements ManagedObject, Serializable {
    
    private final static Logger logger = Logger.getLogger(EventRecorderCellCacheMO.class.getName());
    
    private ManagedReference<EventRecorderImpl> recorderRef;

    /**
     * Creates a new instance of EventRecorderCellCacheMO
     */
    public EventRecorderCellCacheMO(EventRecorderCellMO view, ManagedReference<EventRecorderImpl> recorderRef) {
        super(view);
        this.recorderRef = recorderRef;    
    }
   
    /**
     * Add the viewCellMO (actually anEventRecorderCellMO) to the universe manager for it to manage the cache
     */
    public void login() {
        UniverseManagerFactory.getUniverseManager().viewLogin(getViewCell());
    }
    
    /**
     * Remove the viewCellMO (actually anEventRecorderCellMO) from the universe manager
     */
    protected void logout() {
        UniverseManagerFactory.getUniverseManager().viewLogout(getViewCell());
    }

    /**
     * Get the set of loaded cells
     * @return a set of loaded cells
     */
    public Set<CellID> getLoadedCells() {
        return super.getLoadedCells();
    }
     
    protected void sendLoadMessages(Collection<CellDescription> cells) {
        for(CellDescription cellDescription : cells) {
            // if we haven't already loaded the cell, send a message
            if (getLoadedCells().add(cellDescription.getCellID())) {
                //record the loaded cell
                EventRecorderCellMO cellMO = (EventRecorderCellMO) getViewCell();
                if (cellMO.isRecording()) {
                    recorderRef.get().recordLoadedCell(cellDescription.getCellID());
                }
            }
        }
    }

    public void sendUnloadMessages(Collection<CellDescription> removeCells) {
        // oldCells contains the set of cells to be removed from client memory
        for(CellDescription ref : removeCells) {
            if (getLoadedCells().remove(ref.getCellID())) {
                if (logger.isLoggable(Level.FINER)) {
                    logger.fine("Leaving cell " + ref.getCellID() +
                                " cellcache");
                }
                //record the unloaded cell
                EventRecorderCellMO cellMO = (EventRecorderCellMO) getViewCell();
                if (cellMO.isRecording()) {
                    recorderRef.get().recordUnloadedCell(ref.getCellID());
                }
            }
        }
    }    
}

