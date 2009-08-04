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
package org.jdesktop.wonderland.modules.cmu.server;

import org.jdesktop.wonderland.modules.cmu.common.ProgramConnectionType;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import org.jdesktop.wonderland.common.comms.ConnectionType;
import org.jdesktop.wonderland.common.messages.Message;
import org.jdesktop.wonderland.modules.cmu.common.messages.servercmu.CreateProgramResponseMessage;
import org.jdesktop.wonderland.server.cell.CellMO;
import org.jdesktop.wonderland.server.cell.CellManagerMO;
import org.jdesktop.wonderland.server.comms.ClientConnectionHandler;
import org.jdesktop.wonderland.server.comms.WonderlandClientID;
import org.jdesktop.wonderland.server.comms.WonderlandClientSender;

/**
 * Handles messages sent between CMUCellMO instances and the ProgramManager
 * which should be connected to Wonderland via a ProgramConnection.
 * @author kevin
 */
public class ProgramConnectionHandler implements ClientConnectionHandler, Serializable {

    private WonderlandClientSender clientSender;

    /**
     * {@inheritDoc}
     */
    public ConnectionType getConnectionType() {
        return ProgramConnectionType.TYPE;
    }

    /**
     * Store the WonderlandClientSender so that we can send messages to clients
     * of this connection type.
     * @param sender {@inheritDoc}
     */
    public void registered(WonderlandClientSender sender) {
        this.clientSender = sender;
    }

    /**
     * If this client is connecting to a connection that was empty, send it any
     * queued messages.
     * @param sender {@inheritDoc}
     * @param clientID {@inheritDoc}
     * @param properties {@inheritDoc}
     */
    public void clientConnected(WonderlandClientSender sender, WonderlandClientID clientID, Properties properties) {
        ProgramConnectionHandlerMO.reconnect();
    }

    /**
     * {@inheritDoc}
     */
    public void messageReceived(WonderlandClientSender sender, WonderlandClientID clientID, Message message) {
        // Create new program response
        if (CreateProgramResponseMessage.class.isAssignableFrom(message.getClass())) {
            handleCreatedResponseMessage((CreateProgramResponseMessage) message);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void clientDisconnected(WonderlandClientSender sender, WonderlandClientID clientID) {
        // No action.
    }

    /**
     * Deal with a response message to program creation.  Pass on any connection
     * information to the relevant CMUCellMO.
     * @param message The reponse message received
     */
    protected void handleCreatedResponseMessage(CreateProgramResponseMessage message) {
        // Find relevant cell.
        CellMO cellMO = CellManagerMO.getCell(message.getCellID());
        assert (cellMO != null) && CMUCellMO.class.isAssignableFrom(cellMO.getClass());

        // Set server and port information if the program was successfully created
        if (message.isCreationSuccessful()) {
            CMUCellMO cmuCellMO = (CMUCellMO) cellMO;
            cmuCellMO.setServerAndPort(message.getServer(), message.getPort());
        }

    //TODO: handle unsuccessful program creation
    }

    /**
     * Send a message to all clients registered with this connection type,
     * or if there are none, queue the message (respecting the order in which
     * messages are sent) until a client connects.
     * @param message The message to send
     */
    public void sendMessage(Message message) {
        this.clientSender.send(message);
    }
}
