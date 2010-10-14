/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2010, Sun Microsystems, Inc., All Rights Reserved
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
package org.jdesktop.wonderland.modules.cmu.client.events.cmu;

/**
 * Interface to listen for changes in visibility of particular visual node
 * types.
 * @author kevin
 */
public interface VisibilityChangeListener {

    /**
     * Callback function when the visibility of a visual type is changed.
     * @param e The event representing the change in visibility
     */
    public void visibilityChanged(VisibilityChangeEvent e);
}