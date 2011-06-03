package org.jdesktop.wonderland.modules.path.common.style.node;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jdesktop.wonderland.modules.path.common.style.AbstractItemStyle;

/**
 * This interface represents meta-data information about styling of a node in a path.
 * Specific implementations can hold more data depending on the NodeStyleType.
 * Some meta-data is only applicable to certain NodeStyleTypes.
 *
 * @author Carl Jokl
 */
@XmlRootElement(name="node-style")
public class NodeStyle extends AbstractItemStyle<NodeStyleType> implements Serializable {

    /**
     * The version number for serialization.
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    private final NodeStyleTypeHolder styleTypeHolder;

    /**
     * No argument constructor for JAXB.
     */
    public NodeStyle() {
        styleTypeHolder = new NodeStyleTypeHolder();
    }

    /**
     * Create a new instance of a NodeStyle for the specified NodeStyleType.
     *
     * @param styleTypeHolder The type of NodeStyle for which this NodeStyle holds meta-data.
     */
    public NodeStyle(NodeStyleType styleType) {
        styleTypeHolder = new NodeStyleTypeHolder(styleType);
    }

    /**
     * Create a new instance of a NodeStyle which wraps the specified NodeStyle.
     *
     * @param wrappedStyle The NodeStyle which is wrapped by this NodeStyle.
     * @throws IllegalArgumentException If the specified NodeStyle to be wrapped was null.
     */
    protected NodeStyle(NodeStyle wrappedStyle) throws IllegalArgumentException {
        super(wrappedStyle);
        styleTypeHolder = wrappedStyle.getNodeStyleTypeHolder();
    }

    /**
     * Get the NodeStyleType of this NodeStyle.
     *
     * @return The NodeStyleType of this NodeStyle (if set).
     */
    @Override
    @XmlAttribute(name="type")
    public NodeStyleType getStyleType() {
        return styleTypeHolder.styleType;
    }

    /**
     * Set the NodeStyleType of this NodeStyle.
     *
     * @param styleTypeHolder The NodeStyleType of this NodeStyle.
     */
    @Override
    public void setStyleType(NodeStyleType styleType) {
        styleTypeHolder.styleType = styleType;
    }

    /**
     * Get the internal NodeStyleTypeHolder which is used to provide a level of indirection
     * to the NodeStyleType in order that the NodeStyleType can be kept in synch between a
     * NodeStyle and a NodeStyle wrapper class.
     *
     * @return The NodeStyleTypeHolder which provides indirection for the NodeStyleType so that
     *         both a NodeStyle and a wrapper class can refer to the same NodeStyleType and
     *         when it is changed in one it is changed in the other.
     */
    @XmlTransient
    private NodeStyleTypeHolder getNodeStyleTypeHolder() {
        return styleTypeHolder;
    }

    /**
     * This class is used as an extra level of indirection so that a NodeStyle wrapper can share a reference to a wrapped
     * NodeStyle and when one is updated then the other will be updated as well.
     */
    private static class NodeStyleTypeHolder implements Serializable {

        /**
         * Create a new NodeStyleTypeHolder with no NodeStyleType set.
         */
        public NodeStyleTypeHolder() { }

        /**
         * Create a new NodeStyleTypeHolder set to the specified NodeStyleType.
         *
         * @param styleTypeHolder The NodeStyleType to which the NodeStyleTypeHolder is to be set.
         */
        public NodeStyleTypeHolder(NodeStyleType styleType) {
            this.styleType = styleType;
        }

        public NodeStyleType styleType;
    }
}
