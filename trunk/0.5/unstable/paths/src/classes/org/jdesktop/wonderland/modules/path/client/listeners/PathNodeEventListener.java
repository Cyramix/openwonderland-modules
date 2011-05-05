package org.jdesktop.wonderland.modules.path.client.listeners;

import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.jdesktop.wonderland.client.input.Event;
import org.jdesktop.wonderland.client.input.EventClassListener;
import org.jdesktop.wonderland.client.jme.input.MouseButtonEvent3D;
import org.jdesktop.wonderland.client.jme.input.MouseEvent3D.ButtonId;
import org.jdesktop.wonderland.modules.path.client.ClientPathNode;
import org.jdesktop.wonderland.modules.path.common.Disposable;

/**
 * This class represents an event listener which listens for events such as mouse clicks on a PathNode.
 *
 * @author Carl Jokl
 */
public class PathNodeEventListener extends EventClassListener implements Disposable {

    private static final Logger logger = Logger.getLogger(PathNodeEventListener.class.getName());

    private ClientPathNode owner;
    private ClickTest test;

    /**
     * Create a new PathNodeEventListener to listen for events such as mouse events on the specified
     * ClientPathNode.
     *
     * @param owner The ClientPathNode on which this PathNodeEventListener will listen for events.
     */
    public PathNodeEventListener(ClientPathNode owner) {
        this.owner = owner;
        test = new ClickTest(owner);
    }

    /**
     * Get the events to which this PathNodeEventListener listens.
     *
     * @return An array of classes of Events to which this event listener listens.
     */
    @Override
    public Class[] eventClassesToConsume() {
        return new Class[] { MouseButtonEvent3D.class };
    }

    /**
     * This event method is fired when handling a click event.
     *
     * @param event The event which was fired to which this listener should respond.
     */
    @Override
    public void commitEvent(Event event) {
        logger.warning(String.format("Path Node has received event: %s", event.toString()));
        if (event instanceof MouseButtonEvent3D) {
            MouseButtonEvent3D mouseButtonEvent = (MouseButtonEvent3D) event;
            logger.warning("Path node event is confirment to be a Mouse 3D event.");
            if (mouseButtonEvent.isClicked() && mouseButtonEvent.getButton() == ButtonId.BUTTON1) {
                SwingUtilities.invokeLater(test);
            }
        }
    }

    /**
     * Method to dispose of this listener to allow for proper garbage collection.
     */
    @Override
    public void dispose() {
        owner = null;
        if (test != null) {
            test.dispose();
            test = null;
        }
    }

    private static class ClickTest implements Runnable, Disposable {

        private ClientPathNode owner;

        public ClickTest(ClientPathNode owner) {
            this.owner = owner;
        }

        @Override
        public void run() {
            if (owner.isNamed()) {
                javax.swing.JOptionPane.showMessageDialog(null, String.format("Node Clicked (%d): %s.", owner.getSequenceIndex(), owner.getName()));
            }
            else {
                javax.swing.JOptionPane.showMessageDialog(null, String.format("Node Clicked: %d.", owner.getSequenceIndex()));
            }
        }

        @Override
        public void dispose() {
            owner = null;
        }
    }
}
