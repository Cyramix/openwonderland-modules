/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConstructPanel.java
 *
 * Created on Aug 10, 2009, 10:22:50 PM
 */

package org.jdesktop.wonderland.modules.marbleous.client.ui;

import java.awt.Image;
import java.awt.dnd.DnDConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.wonderland.client.cell.registry.CellRegistry;
import org.jdesktop.wonderland.client.cell.registry.CellRegistry.CellRegistryListener;
import org.jdesktop.wonderland.client.cell.registry.spi.CellFactorySPI;
import org.jdesktop.wonderland.client.cell.utils.CellCreationException;
import org.jdesktop.wonderland.client.cell.utils.CellUtils;
import org.jdesktop.wonderland.common.cell.state.CellServerState;

/**
 *
 * @author bh37721
 */
public class ConstructPanel extends javax.swing.JPanel implements ListSelectionListener {

    /* A map of cell display names and their cell factories */
    private final Map<String, CellFactorySPI> cellFactoryMap = new HashMap();

    /* The "No Preview Available" image */
    private Image noPreviewAvailableImage = null;

    /* The listener for changes in the list of registered Cell factories */
    private CellRegistryListener cellListener = null;

    private Container container;

    void setContainer(Container aContainer) {
        container = aContainer;
    }

    public interface Container {

    }

    /** Creates new form ConstructPanel */
    public ConstructPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        cellScrollPane = new javax.swing.JScrollPane();
        cellList = new javax.swing.JList();
        previewPanel = new javax.swing.JPanel();
        previewLabel = new javax.swing.JLabel();

        jLabel1.setText("Insert Component:");

        createButton.setText("Insert");
        createButton.setEnabled(false);
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtoncreateActionPerformed(evt);
            }
        });

        cellList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cellScrollPane.setViewportView(cellList);

        previewPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        previewPanel.setMinimumSize(new java.awt.Dimension(128, 128));
        previewPanel.setPreferredSize(new java.awt.Dimension(128, 128));
        previewPanel.setLayout(new java.awt.GridLayout());

        previewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previewLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewLabel.setIconTextGap(0);
        previewPanel.add(previewLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createButton)
                            .addComponent(cellScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cellScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(previewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createButtoncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtoncreateActionPerformed

        // We synchronized around the cellFactoryMap so that this action does not
        // interfere with any changes in the map.
        synchronized (cellFactoryMap) {
            // From the selected value, find the proper means to create the object
            String cellDisplayName = (String) cellList.getSelectedValue();
            CellFactorySPI factory = cellFactoryMap.get(cellDisplayName);
            CellServerState setup = factory.getDefaultCellServerState(null);

            // Create the new cell at a distance away from the avatar
            try {
                CellUtils.createCell(setup);
            } catch (CellCreationException excp) {
                Logger logger = Logger.getLogger(ConstructPanel.class.getName());
                logger.log(Level.WARNING, "Unable to create cell " + cellDisplayName +
                        " using palette", excp);
            }
        }

}//GEN-LAST:event_createButtoncreateActionPerformed


    /**
     * Updates the list of values displayed from the CellRegistry.
     */
    private void updateListValues() {
        // Let's synchronized around cellFactoryMap so that any selections do
        // not interfere with changes in this map
        synchronized (cellFactoryMap) {
            // Clear out any existing entries in the map of registered Cells
            cellFactoryMap.clear();

            // Fetch the registry of cells and for each, get the palette info and
            // populate the list.
            CellRegistry registry = CellRegistry.getCellRegistry();
            Set<CellFactorySPI> cellFactories = registry.getAllCellFactories();
            List<String> listNames = new LinkedList();

            // Loop through each cell factory we find. Insert the cell names into
            // a list. Ignore any factories without a cell name.
            for (CellFactorySPI cellFactory : cellFactories) {
                try {
                    String name = cellFactory.getDisplayName();
                    if (name != null) {
                        listNames.add(name);
                        cellFactoryMap.put(name, cellFactory);
                    }
                } catch (java.lang.Exception excp) {
                    // Just ignore, but log a message
                    Logger logger = Logger.getLogger(ConstructPanel.class.getName());
                    logger.log(Level.WARNING, "No Display Name for Cell Factory " +
                            cellFactory, excp);
                }
            }

            // Set the names of the list, first sorting the list in alphabetical
            // order
            Collections.sort(listNames);
            cellList.setListData(listNames.toArray(new String[]{}));
            cellList.setDragEnabled(true);
        }
    }
    
    /**
     * Handles when a selection has been made of the list of cell type names.
     * @param e
     */
    public void valueChanged(ListSelectionEvent e) {

        // We synchronized around the cellFactoryMap so that this action does not
        // interfere with any changes in the map.
        synchronized (cellFactoryMap) {

            // Fetch the display name of the cell selected. If it happens to
            // be null (not sure why this would happen), then simply return.
            String selectedName = (String) cellList.getSelectedValue();
            if (selectedName == null) {
                // If nothing is selected, then disable the Insert button, the
                // preview image and disable drag-and-drop from the preview
                // label.
                createButton.setEnabled(false);
                previewLabel.setIcon(null);

                /*
                 // Make sure the recognizers are not null, and set their
                // components to null;
                if (previewRecognizer != null) {
                    previewRecognizer.setComponent(null);
                }

                if (listRecognizer != null) {
                    listRecognizer.setComponent(null);
                }
                */
                return;
            }

            // Next, fetch the Cell factory associated with the display name.
            // If it happens to be null (not sure why this would happen), then
            // simply return.
            CellFactorySPI cellFactory = cellFactoryMap.get(selectedName);
            if (cellFactory == null) {
                return;
            }

            // Enable the Insert button
            createButton.setEnabled(true);

            // Otherwise, update the preview image, if one exists, otherwise
            // use the default image.
            Image previewImage = cellFactory.getPreviewImage();
            if (previewImage != null) {
                ImageIcon icon = new ImageIcon(previewImage);
                previewLabel.setIcon(icon);

                // Pass the necessary information for drag and drop
                //gestureListener.cellFactory = cellFactory;
                //gestureListener.previewImage = previewImage;
            }
            else {
                ImageIcon icon = new ImageIcon(noPreviewAvailableImage);
                previewLabel.setIcon(icon);

                // Pass the necessary information for drag and drop
                //gestureListener.cellFactory = cellFactory;
                //gestureListener.previewImage = noPreviewAvailableImage;
            }

            // Enable drag-and-drop from the preview image, creating the
            // recognizer if necessary
            /*
             if (previewRecognizer == null) {
                previewRecognizer =
                        dragSource.createDefaultDragGestureRecognizer(previewLabel,
                        DnDConstants.ACTION_COPY_OR_MOVE, gestureListener);
            }
            else {
                previewRecognizer.setComponent(previewLabel);
            }
            */

            // Add support for drag from the text list of cells, creating the
            // recognizer if necessary
            /*
             if (listRecognizer == null) {
                listRecognizer =
                        dragSource.createDefaultDragGestureRecognizer(cellList,
                        DnDConstants.ACTION_COPY_OR_MOVE, gestureListener);
            }
            else {
                listRecognizer.setComponent(cellList);
            }
            */
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JList cellList;
    protected javax.swing.JScrollPane cellScrollPane;
    protected javax.swing.JButton createButton;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel previewLabel;
    protected javax.swing.JPanel previewPanel;
    // End of variables declaration//GEN-END:variables

}
