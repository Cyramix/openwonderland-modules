/**
 * iSocial Project
 * http://isocial.missouri.edu
 *
 * Copyright (c) 2011, University of Missouri iSocial Project, All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * The iSocial project designates this particular file as
 * subject to the "Classpath" exception as provided by the iSocial
 * project in the License file that accompanied this code.
 */
package org.jdesktop.wonderland.modules.isocial.client.view;

import org.jdesktop.wonderland.modules.isocial.common.model.Result;

/**
 * A listener that is notified when a new result is added or an existing
 * result is updated.
 * @author Jonathan Kaplan <jonathankap@wonderbuilders.com>
 */
public interface ResultListener {
    /**
     * Notification of new results
     * @param result the result that was added
     */
    public void resultAdded(Result result);

    /**
     * Notification that a result was updated
     * @param result the result that was updated
     */
    public void resultUpdated(Result result);
}
