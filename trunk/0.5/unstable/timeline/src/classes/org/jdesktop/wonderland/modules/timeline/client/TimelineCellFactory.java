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
package org.jdesktop.wonderland.modules.timeline.client;

import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;
import org.jdesktop.wonderland.client.cell.registry.annotation.CellFactory;
import org.jdesktop.wonderland.client.cell.registry.spi.CellFactorySPI;
import org.jdesktop.wonderland.client.hud.CompassLayout.Layout;
import org.jdesktop.wonderland.client.hud.HUD;
import org.jdesktop.wonderland.client.hud.HUDComponent;
import org.jdesktop.wonderland.client.hud.HUDManagerFactory;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.modules.timeline.common.TimelineCellServerState;
import org.jdesktop.wonderland.modules.timeline.common.TimelineConfiguration;
import org.jdesktop.wonderland.modules.timeline.common.provider.TimelineDate;
import org.jdesktop.wonderland.modules.timeline.common.provider.TimelineProviderServerState;
import org.jdesktop.wonderland.modules.timeline.common.provider.TimelineQuery;

/**
 *
 *  
 */
@CellFactory
public class TimelineCellFactory implements CellFactorySPI {

    private static final Logger logger =
            Logger.getLogger(TimelineCellFactory.class.getName());
    private TimelineCreationHUDPanel creationPanel;
    private HUDComponent timelineCreationHUD;

    public String[] getExtensions() {
        return null;
    }

    public <T extends CellServerState> T getDefaultCellServerState(Properties props) {

        TimelineCellServerState state = new TimelineCellServerState();
        createCreationHUD();
        state.setConfig(new TimelineConfiguration());

        Date end = new Date();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1999);
        Date start = c.getTime();

        state.getConfig().setDateRange(new TimelineDate(start, end));
        state.getConfig().setNumSegments(10);

        TimelineProviderServerState tpss = new TimelineProviderServerState();

//        TimelineQuery query = new TimelineQuery("org.jdesktop.wonderland.modules.timelineproviders.provider.FlickrProvider");
//        query.getProperties().setProperty("apiKey", "aa664dbdefb318455a9a07a4245f5ff6");
//        query.getProperties().setProperty("startDate", String.valueOf(state.getConfig().getDateRange().getMinimum().getTime()));
//        query.getProperties().setProperty("endDate", String.valueOf(state.getConfig().getDateRange().getMaximum().getTime()));
//        query.getProperties().setProperty("increments", String.valueOf(state.getConfig().getNumSegments()));
//        query.getProperties().setProperty("searchText", "automobile");
//        query.getProperties().setProperty("searchType", "tags");
//        query.getProperties().setProperty("sort", "relevance");
//        query.getProperties().setProperty("returnCount", String.valueOf(4));

        TimelineQuery query = new TimelineQuery("org.jdesktop.wonderland.modules.timelineproviders.provider.NYTimesProvider");
        query.getProperties().setProperty("apiKey", "5397ee74814d2427fb24eb880efca778:12:59005926");
        query.getProperties().setProperty("startDate", String.valueOf(state.getConfig().getDateRange().getMinimum().getTime()));
        query.getProperties().setProperty("endDate", String.valueOf(state.getConfig().getDateRange().getMaximum().getTime()));
        query.getProperties().setProperty("increments", String.valueOf(state.getConfig().getNumSegments()));
        query.getProperties().setProperty("searchText", "International Space Station");
        query.getProperties().setProperty("returnCount", String.valueOf(4));
        tpss.getQueries().add(query);

        state.addComponentServerState(tpss);
        return (T)state;
    }

    private void createCreationHUD() {
        HUD mainHUD = HUDManagerFactory.getHUDManager().getHUD("main");

        creationPanel = new TimelineCreationHUDPanel();
        creationPanel.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent pe) {
                if ((pe.getPropertyName().equals("create")) || (pe.getPropertyName().equals("update"))) {
                    logger.info("--- create/update timeline");
                    timelineCreationHUD.setVisible(false);
                    // TODO: actually create a Timeline!
                } else if (pe.getPropertyName().equals("cancel")) {
                    // timeline creation was canceled
                    timelineCreationHUD.setVisible(false);
                }
            }
        });
        timelineCreationHUD = mainHUD.createComponent(creationPanel);
        timelineCreationHUD.setPreferredLocation(Layout.CENTER);
        timelineCreationHUD.setName("Create Timeline");
        mainHUD.addComponent(timelineCreationHUD);
        timelineCreationHUD.setVisible(true);
    }

    public String getDisplayName() {
        return "Timeline";
    }

    public Image getPreviewImage() {
        return null;
    }
}