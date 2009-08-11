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

import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for adding a keyword collection
 * @author nsimpson
 */
public class TimelineAddCollectionPanel extends javax.swing.JPanel {

    /** Creates new form TimelineAddCollectionPanel */
    public TimelineAddCollectionPanel() {
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

        collectionLabel = new javax.swing.JLabel();
        collectionScrollPane = new javax.swing.JScrollPane();
        collectionTable = new javax.swing.JTable();
        addKeywordButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();

        collectionLabel.setFont(collectionLabel.getFont().deriveFont(collectionLabel.getFont().getStyle() | java.awt.Font.BOLD));
        collectionLabel.setText("Create Keyword Collection");

        collectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Keywords"
            }
        ));
        collectionTable.setGridColor(new java.awt.Color(204, 204, 204));
        collectionScrollPane.setViewportView(collectionTable);

        addKeywordButton.setText("Add Keyword");
        addKeywordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKeywordButtonActionPerformed(evt);
            }
        });

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(collectionScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(collectionLabel))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(addKeywordButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 185, Short.MAX_VALUE)
                        .add(doneButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(collectionLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(collectionScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(addKeywordButton)
                    .add(doneButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addKeywordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addKeywordButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel)collectionTable.getModel();
        int rows = collectionTable.getRowCount();
        model.addRow(new String[2]);
        collectionTable.setPreferredSize(new Dimension(collectionTable.getWidth(),
                (rows + 1)*collectionTable.getRowHeight()));
        this.setPreferredSize(new Dimension((int)getPreferredSize().getWidth(),
                (int)(getPreferredSize().getHeight() + collectionTable.getRowHeight())));
        validate();
    }//GEN-LAST:event_addKeywordButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doneButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addKeywordButton;
    private javax.swing.JLabel collectionLabel;
    private javax.swing.JScrollPane collectionScrollPane;
    private javax.swing.JTable collectionTable;
    private javax.swing.JButton doneButton;
    // End of variables declaration//GEN-END:variables

}
