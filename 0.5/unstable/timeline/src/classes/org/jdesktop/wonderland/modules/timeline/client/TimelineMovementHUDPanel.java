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

import java.util.logging.Logger;

/**
 * A simple slider that lets you easily update the avatar's position on the
 * timeline spiral.
 *
 * @author Drew Harry <drew_harry@dev.java.net>
 */
public class TimelineMovementHUDPanel extends javax.swing.JPanel {

    private static final Logger logger =
        Logger.getLogger(TimelineMovementHUDPanel.class.getName());

    private final TimelineCell cell;

    /** Creates new form TimelineMovementHUDPanel */
    public TimelineMovementHUDPanel(TimelineCell cell) {
        initComponents();

        this.cell = cell;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        positionSlider = new javax.swing.JSlider();

        positionSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        positionSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                positionSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(positionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(positionSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void positionSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_positionSliderStateChanged
        cell.moveAvatar(((float)this.positionSlider.getValue())/this.positionSlider.getMaximum());
    }//GEN-LAST:event_positionSliderStateChanged

    /**
     * Updates the location of the position slider based. Is generally triggered
     * by avatar movements around the spiral, so the UI for the navigation
     * represents the actual current location.
     * 
     * @param position
     */
    public void setSliderLocation(float position) {

       // cheating a bit here - this is only true for min=0, but
       // that's an assumption I think we can make here since we
       // own the slider.
        
       this.positionSlider.setValue((int) (positionSlider.getMaximum() * position));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider positionSlider;
    // End of variables declaration//GEN-END:variables

}
