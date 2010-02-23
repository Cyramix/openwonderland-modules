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
package org.jdesktop.wonderland.modules.timeline.common.layout;

import org.jdesktop.wonderland.modules.layout.api.common.LayoutParticipant;
import org.jdesktop.wonderland.modules.timeline.common.provider.DatedObject;
import org.jdesktop.wonderland.modules.timeline.common.provider.TimelineDate;

/**
 * Extension of the standard LayoutParticipant interface to included dated
 * objects.
 * @author Jonathan Kaplan <kaplanj@dev.java.net>
 */
public interface DatedLayoutParticipant extends DatedObject, LayoutParticipant {
    public DatedObject getDatedObject();
    public TimelineDate getDate();
}
