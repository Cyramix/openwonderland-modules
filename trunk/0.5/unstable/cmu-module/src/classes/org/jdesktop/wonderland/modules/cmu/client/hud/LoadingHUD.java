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
/*
 * LoadingHUD.java
 *
 * Created on Aug 25, 2009, 2:53:44 PM
 */
package org.jdesktop.wonderland.modules.cmu.client.hud;

import javax.swing.SwingUtilities;
import org.jdesktop.wonderland.modules.cmu.client.CMUCell;
import org.jdesktop.wonderland.modules.cmu.client.events.cmu.SceneLoadedChangeEvent;
import org.jdesktop.wonderland.modules.cmu.client.events.cmu.SceneLoadedChangeListener;


/**
 *
 * @author kevin
 */
public class LoadingHUD extends CMUPanel implements SceneLoadedChangeListener {

    private final int LOAD_MIN;
    private final int LOAD_MAX;

    /** 
     * Creates new form LoadingHUD
     * @param parentCell The cell with which this HUD panel is associated
     */
    public LoadingHUD(CMUCell parentCell) {
        initComponents();
        LOAD_MIN = loadProgress.getMinimum();
        LOAD_MAX = loadProgress.getMaximum();
        parentCell.addSceneLoadedChangeListener(this);
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
        loadProgress = new javax.swing.JProgressBar();

        jLabel1.setText("Reloading scene data...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(loadProgress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar loadProgress;
    // End of variables declaration//GEN-END:variables

    public void sceneLoadedChanged(SceneLoadedChangeEvent e) {
        final int progressValue = (int) linearScale(e.getLoadProgress(),
                e.getMinLoad(), e.getMaxLoad(), (float) LOAD_MIN, (float) LOAD_MAX);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                loadProgress.setValue(progressValue);
            }
        });
    }
}
