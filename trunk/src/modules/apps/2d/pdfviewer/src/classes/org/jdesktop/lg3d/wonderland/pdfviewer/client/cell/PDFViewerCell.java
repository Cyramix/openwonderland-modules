/**
 * Project Looking Glass
 *
 * $RCSfile$
 *
 * Copyright (c) 2004-2008, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * $Revision$
 * $Date$
 * $State$
 */
package org.jdesktop.lg3d.wonderland.pdfviewer.client.cell;

import com.sun.sgs.client.ClientChannel;
import com.sun.sgs.client.SessionId;
import java.util.logging.Logger;
import javax.vecmath.Matrix4d;
import org.jdesktop.lg3d.wonderland.darkstar.client.ExtendedClientChannelListener;
import org.jdesktop.lg3d.wonderland.darkstar.client.cell.*;
import org.jdesktop.lg3d.wonderland.darkstar.common.CellID;
import org.jdesktop.lg3d.wonderland.darkstar.common.CellSetup;
import org.jdesktop.lg3d.wonderland.darkstar.common.messages.Message;
import org.jdesktop.lg3d.wonderland.pdfviewer.common.PDFCellMessage;
import org.jdesktop.lg3d.wonderland.pdfviewer.common.PDFViewerCellSetup;

/**
 * Client Cell for a PDF Viewer Shared Application.
 *
 * @author nsimpson
 */
public class PDFViewerCell extends SharedApp2DImageCell
        implements ExtendedClientChannelListener {

    private static final Logger logger =
            Logger.getLogger(PDFViewerCell.class.getName());
    private PDFViewerApp viewer;
    private PDFViewerCellSetup pdfSetup;

    public PDFViewerCell(final CellID cellID, String channelName, Matrix4d origin) {
        super(cellID, channelName, origin);
    }

    /**
     * Initialize the PDF Viewer and load the document
     * @param setupData the setup data to initialize the cell with
     */
    @Override
    public void setup(CellSetup setupData) {
        pdfSetup = (PDFViewerCellSetup) setupData;

        if (pdfSetup != null) {
            viewer = new PDFViewerApp(this, 0, 0,
                    (int) pdfSetup.getPreferredWidth(),
                    (int) pdfSetup.getPreferredHeight());
            viewer.openDocument(pdfSetup.getDocument(),
                    pdfSetup.getPage(),
                    pdfSetup.getPosition(),
                    false);
        }
    }

    /**
     * Set the channel associated with this cell
     * @param channel the channel to associate with this cell
     */
    public void setChannel(ClientChannel channel) {
        this.channel = channel;
    }

    /**
     * Process a cell message
     * @param channel the channel
     * @param session the session id
     * @param data the message data
     */
    public void receivedMessage(ClientChannel channel, SessionId session,
            byte[] data) {
        PDFCellMessage msg = Message.extractMessage(data, PDFCellMessage.class);
        logger.info("received message: " + msg);

        switch (msg.getAction()) {
            case OPEN_DOCUMENT:
                viewer.openDocument(msg.getDocument());
                break;
            case CLOSE_DOCUMENT:
                viewer.closeDocument(msg.getDocument());
                break;
            case NEXT_PAGE:
                viewer.nextPage();
                break;
            case SHOW_PAGE:
                viewer.showPage(msg.getPage());
                break;
            case SET_VIEW_POSITION:
                viewer.setViewPosition(msg.getPosition());
                break;
        }
    }

    /**
     * Process a channel leave event
     * @param channel the left channel
     */
    public void leftChannel(ClientChannel channel) {
        logger.fine("leftChannel: " + channel);
    }
}
