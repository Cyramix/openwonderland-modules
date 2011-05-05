package org.jdesktop.wonderland.modules.path.common;

import com.jme.math.Vector3f;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.common.cell.state.annotation.ServerState;
import org.jdesktop.wonderland.modules.path.common.style.PathStyle;

/**
 * This cell server state holds state for a path cell.
 * @author Carl Jokl
 */
@XmlRootElement(name="path-cell")
@ServerState
public class PathCellServerState extends CellServerState implements PathCellState {

    /**
     * The name of the Server class for the PathCellServerState.
     */
    public static final String SERVER_CLASS_NAME = "org.jdesktop.wonderland.modules.path.server.PathCellMO";

    @XmlTransient
    private boolean editMode;
    @XmlTransient
    private boolean closedPath;
    @XmlTransient
    private PathStyle pathStyle;
    @XmlElements({
        @XmlElement(name="node")
    })
    private List<PathNodeState> nodes;

    /**
     * Create a default PathServerState with no style set.
     */
    public PathCellServerState() {
        nodes = new ArrayList<PathNodeState>();
        editMode = false;
        closedPath = false;
    }

    /**
     * Create a new PathServerState with the specified PathStyle
     * and using the default NodeStyleType for the specified SegmentStyleType
     * for all the nodes.
     *
     * @param pathStyle The PathStyle of the PathCellServerState.
     * @param editMode Whether the PathCell is in edit mode.
     * @param closedPath Whether the path represented by this PathCell is a closed path.
     */
    public PathCellServerState(PathStyle pathStyle, boolean editMode, boolean closedPath) {
        nodes = new ArrayList<PathNodeState>();
        this.pathStyle = pathStyle;
        this.editMode = editMode;
        this.closedPath = closedPath;
    }

    /**
     * {@inheritDoc}
     */
    @XmlAttribute(name="editMode")
    @Override
    public boolean isEditMode() {
        return editMode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    /**
     * {@inheritDoc}
     */
    @XmlAttribute(name="closedPath")
    @Override
    public boolean isClosedPath() {
        return closedPath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setClosedPath(boolean closedPath) {
        this.closedPath = closedPath;
    }

    /**
     * {@inheritDoc}
     */
    @XmlTransient
    @Override
    public PathStyle getPathStyle() {
        return pathStyle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPathStyle(PathStyle pathStyle) {
        this.pathStyle = pathStyle;
    }

    /**
     * {@inheritDoc}
     */
    @XmlTransient
    @Override
    public String getServerClassName() {
        return SERVER_CLASS_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int noOfNodeStates() {
        return nodes.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PathNodeState getPathNodeState(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < nodes.size()) {
            return nodes.get(index);
        }
        else {
            throw new IndexOutOfBoundsException(String.format("The specified index: %d is outside the range of node states! No of node states %d.", index, nodes.size()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addPathNodeState(PathNodeState nodeState) {
        if (nodeState != null && nodes.add(nodeState)) {
            nodeState.setSequenceIndex(nodes.size() - 1);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addPathNodeState(Vector3f position, String name) {
        return addPathNodeState(new PathNodeState(position, name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addPathNodeState(float x, float y, float z, String name) {
        return addPathNodeState(new PathNodeState(x, y, z, name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PathNodeState insertPathNodeState(PathNodeState nodeState, int index) throws IndexOutOfBoundsException {
        final int limit = nodes.size();
        if (index >= 0 && index <= limit) {
            if (nodeState != null) {
                if (index == limit) {
                    addPathNodeState(nodeState);
                }
                else {
                    PathNodeState previous = nodes.get(index);
                    nodes.add(index, nodeState);
                    nodeState.setSequenceIndex(index);
                    index++;
                    previous.setSequenceIndex(index);
                    index++;
                    for (;index <= limit; index++) {
                        nodes.get(index).setSequenceIndex(index);
                    }
                    return previous;
                }
            }
            return null;
        }
        else {
            throw new IndexOutOfBoundsException(String.format("The index: %d at which a path node state was to be inserted is outsize the valid range! No of path node states: %d.", index, nodes.size()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PathNodeState insertPathNodeState(Vector3f position, String name, int index) throws IndexOutOfBoundsException {
        return insertPathNodeState(new PathNodeState(position, name), index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PathNodeState insertPathNodeState(float x, float y, float z, String name, int index) throws IndexOutOfBoundsException {
        return insertPathNodeState(new PathNodeState(x, y, z, name), index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removePathNodeState(PathNodeState nodeState) {
        if (nodeState != null) {
            if (nodes.remove(nodeState)) {
                int index = nodeState.getSequenceIndex();
                final int limit = nodes.size();
                if (index >= 0 && index < limit) {
                    for (;index < limit; index++) {
                        nodes.get(index).setSequenceIndex(index);
                    }
                }
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PathNodeState removePathNodeStateAt(int nodeIndex) throws IndexOutOfBoundsException {
        final int limit = nodes.size();
        if (nodeIndex >= 0 && nodeIndex < limit) {
            PathNodeState removedNode = nodes.remove(nodeIndex);
            for (;nodeIndex < limit; nodeIndex++) {
                nodes.get(nodeIndex).setSequenceIndex(nodeIndex);
            }
            return removedNode;
        }
        else {
            throw new IndexOutOfBoundsException(String.format("The specified index: %d at which to remove the path node state was not within the valid range! No of path node states: %d.", nodeIndex, limit));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAllPathNodeStates() {
        nodes.clear();
    }
}
