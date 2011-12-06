/**
  * iSocial Project
  * http://isocial.missouri.edu
  *
  * Copyright (c) 2011, University of Missouri iSocial Project, All 
  * Rights Reserved
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

package org.jdesktop.wonderland.modules.mediaboard.client;

import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdesktop.wonderland.client.cell.properties.CellPropertiesEditor;
import org.jdesktop.wonderland.client.cell.properties.annotation.PropertiesFactory;
import org.jdesktop.wonderland.client.cell.properties.spi.PropertiesFactorySPI;
import org.jdesktop.wonderland.modules.mediaboard.client.cell.WhiteboardCell;
import org.jdesktop.wonderland.modules.mediaboard.common.cell.WhiteboardSVGCellServerState;
import org.jdesktop.wonderland.modules.sharedstate.common.SharedDouble;

/**
 *
 * @author Ryan
 */
@PropertiesFactory(WhiteboardSVGCellServerState.class)
public class MediaboardCellProperties extends javax.swing.JPanel
    implements PropertiesFactorySPI {

    CellPropertiesEditor editor = null;
    private double originalMargin = 18; //by default

    private static final Logger logger = Logger.getLogger(MediaboardCellProperties.class.getName());
    /** Creates new form MediaboardCellProperties */
    public MediaboardCellProperties() {
        initComponents();
        marginSpinner.getModel().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {

                SpinnerNumberModel m = (SpinnerNumberModel)marginSpinner.getModel();
                double currentValue = m.getNumber().doubleValue();
                logger.warning("Spinner changed to: "+currentValue+"\n original value is: "+originalMargin);
                
                if(currentValue != originalMargin) {

                    editor.setPanelDirty(MediaboardCellProperties.class, true);
                } else {
                    editor.setPanelDirty(MediaboardCellProperties.class, false);
                }
            }

        });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        marginSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        marginSpinner.setModel(new javax.swing.SpinnerNumberModel(18, 18, 100, 1));

        jLabel1.setText("Text margin:");

        jLabel2.setText("Powered by iSocial: <http://isocial.missouri.edu>");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(18, 18, 18)
                        .add(marginSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel2))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(marginSpinner))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 217, Short.MAX_VALUE)
                .add(jLabel2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getDisplayName() {
        return "Mediaboard";
    }

    public void setCellPropertiesEditor(CellPropertiesEditor editor) {
        this.editor = editor;
    }

    public JPanel getPropertiesJPanel() {
        return this;
    }

    public void open() {
        SharedDouble dble = (SharedDouble)getCell().getStateMap().get("margin-width");
        if(dble != null)
            originalMargin = dble.getValue();

        SpinnerNumberModel m = (SpinnerNumberModel)marginSpinner.getModel();

        //this is a bit confusing.
        //the spinner model uses integers, but the statemap data is in doubles...
        //we create a new Double instance, get the integer value of that and
        //pass it through to a new Integer instance.
        m.setValue(new Integer(new Double(originalMargin).intValue()));

    }

    public void close() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void restore() {
        //throw new UnsupportedOperationException("Not supported yet.");
         SpinnerNumberModel m = (SpinnerNumberModel)marginSpinner.getModel();
         m.setValue(new Integer(new Double(originalMargin).intValue()));
    }

    public void apply() {
        //get the spinner data, put it in double form
        SpinnerNumberModel m = (SpinnerNumberModel)marginSpinner.getModel();
        double margin = m.getNumber().doubleValue();
        
        getCell().getStateMap().put("margin-width", SharedDouble.valueOf(margin));
        


    }

    private WhiteboardCell getCell() {

        return (WhiteboardCell)editor.getCell();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner marginSpinner;
    // End of variables declaration//GEN-END:variables

}
