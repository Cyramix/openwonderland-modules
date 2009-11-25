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
package org.jdesktop.wonderland.modules.quickreference.client;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A JPanel to display simple navigation controls for an Avatar
 *
 * @author Jordan Slott <jslott@dev.java.net>
 */
public class QuickReferenceJPanel extends javax.swing.JPanel {

    // The error logger
    private static final Logger LOGGER =
            Logger.getLogger(QuickReferenceJPanel.class.getName());

    // The I18N resource bundle
    private final static ResourceBundle BUNDLE = ResourceBundle.getBundle(
            "org/jdesktop/wonderland/modules/quickreference/client/resources/Bundle");

    /**
     * Creates a new JPanel. This method assumes there is a primary view Cell
     * that already exists.
     */
    public QuickReferenceJPanel() {
        initComponents();

        // Set the proper localized icon labels
        setJLabelIcon("Ctrl_Key_Image", controlLabel);
        setJLabelIcon("Down_Key_Image", wLabel);
        setJLabelIcon("E_Key_Image", eLabel);
        setJLabelIcon("Left_Key_Image", leftLabel);
        setJLabelIcon("Mouse_Wheel_Image", scrollWheelLabel);
        setJLabelIcon("PageDown_Key_Image", pageDownLabel);
        setJLabelIcon("PageUp_Key_Image", pageUpLabel);
        setJLabelIcon("Q_Key_Image", qLabel);
        setJLabelIcon("Right_Key_Image", aLabel);
        setJLabelIcon("Shift_Key_Image", shiftLabel);
        setJLabelIcon("Up_Key_Image", upLabel);
        setJLabelIcon("Up_Key_Image", upLabel2);
        setJLabelIcon("W_Key_Image", wLabel);
        setJLabelIcon("S_Key_Image", sLabel);
        setJLabelIcon("A_Key_Image", aLabel);
        setJLabelIcon("D_Key_Image", dLabel);
    }

    /**
     * Given the name of the key in the resource bundle and the JLabel, loads
     * the image pointed to in the resource bundle and sets it as the JLabel
     * icon.
     *
     * @param key The key string in the resource bundle
     * param jlabel The label whose icon to set
     */
    private void setJLabelIcon(String key, JLabel jlabel) {
        String resource = "resources/" + BUNDLE.getString(key);
        URL url = QuickReferenceJPanel.class.getResource(resource);
        jlabel.setIcon(new ImageIcon(url));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        shiftLabel = new javax.swing.JLabel();
        pageUpLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pageDownLabel = new javax.swing.JLabel();
        qeLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        upLabel2 = new javax.swing.JLabel();
        runLabel = new javax.swing.JLabel();
        leftLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aLabel = new javax.swing.JLabel();
        turnLeftLabel = new javax.swing.JLabel();
        upLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        wLabel = new javax.swing.JLabel();
        forwardLabel = new javax.swing.JLabel();
        qLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        eLabel = new javax.swing.JLabel();
        qeLabel = new javax.swing.JLabel();
        scrollWheelLabel = new javax.swing.JLabel();
        zoomInOutLabel = new javax.swing.JLabel();
        controlLabel = new javax.swing.JLabel();
        plusLabel2 = new javax.swing.JLabel();
        lookLabel = new javax.swing.JLabel();
        dragLabel = new javax.swing.JLabel();
        downLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();
        rightLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dLabel = new javax.swing.JLabel();
        turnRightLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        setLayout(new java.awt.GridBagLayout());

        shiftLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/Shift-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(shiftLabel, gridBagConstraints);

        pageUpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/PageUp-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(pageUpLabel, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jdesktop/wonderland/modules/quickreference/client/resources/Bundle"); // NOI18N
        jLabel5.setText(bundle.getString("Slash")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        add(jLabel5, gridBagConstraints);

        pageDownLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/PageDown-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(pageDownLabel, gridBagConstraints);

        qeLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        qeLabel1.setText(bundle.getString("Go_Up_Down")); // NOI18N
        qeLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(qeLabel1, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setText(bundle.getString("Plus")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        add(jLabel4, gridBagConstraints);

        upLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/Up-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(upLabel2, gridBagConstraints);

        runLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        runLabel.setText(bundle.getString("Run")); // NOI18N
        runLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(runLabel, gridBagConstraints);

        leftLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/Left-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(leftLabel, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText(bundle.getString("Or")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        add(jLabel3, gridBagConstraints);

        aLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/A-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(aLabel, gridBagConstraints);

        turnLeftLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        turnLeftLabel.setText(bundle.getString("Turn_Left")); // NOI18N
        turnLeftLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(turnLeftLabel, gridBagConstraints);

        upLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/Up-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(upLabel, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText(bundle.getString("Or")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        add(jLabel1, gridBagConstraints);

        wLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/W-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(wLabel, gridBagConstraints);

        forwardLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        forwardLabel.setText(bundle.getString("Walk_Forward")); // NOI18N
        forwardLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(forwardLabel, gridBagConstraints);

        qLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/Q-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(qLabel, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24));
        jLabel2.setText(bundle.getString("Slash")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        add(jLabel2, gridBagConstraints);

        eLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/E-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(eLabel, gridBagConstraints);

        qeLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        qeLabel.setText(bundle.getString("Step_Left_Right")); // NOI18N
        qeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(qeLabel, gridBagConstraints);

        scrollWheelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/MouseWheel_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        add(scrollWheelLabel, gridBagConstraints);

        zoomInOutLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        zoomInOutLabel.setText(bundle.getString("Zoom_In_Out")); // NOI18N
        zoomInOutLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(zoomInOutLabel, gridBagConstraints);

        controlLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/Ctrl-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(controlLabel, gridBagConstraints);

        plusLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24));
        plusLabel2.setText(bundle.getString("Plus")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        add(plusLabel2, gridBagConstraints);

        lookLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        lookLabel.setText(bundle.getString("Look_Up_Down")); // NOI18N
        lookLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(lookLabel, gridBagConstraints);

        dragLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        dragLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dragLabel.setText(bundle.getString("Drag")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(dragLabel, gridBagConstraints);

        downLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/Down-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(downLabel, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel6.setText(bundle.getString("Or")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        add(jLabel6, gridBagConstraints);

        sLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/S-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(sLabel, gridBagConstraints);

        backLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        backLabel.setText(bundle.getString("Walk_Backward")); // NOI18N
        backLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(backLabel, gridBagConstraints);

        rightLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/Right-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(rightLabel, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel7.setText(bundle.getString("Or")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        add(jLabel7, gridBagConstraints);

        dLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/quickreference/client/resources/D-key_en.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(dLabel, gridBagConstraints);

        turnRightLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        turnRightLabel.setText(bundle.getString("Turn_Right")); // NOI18N
        turnRightLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(turnRightLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JLabel backLabel;
    private javax.swing.JLabel controlLabel;
    private javax.swing.JLabel dLabel;
    private javax.swing.JLabel downLabel;
    private javax.swing.JLabel dragLabel;
    private javax.swing.JLabel eLabel;
    private javax.swing.JLabel forwardLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel leftLabel;
    private javax.swing.JLabel lookLabel;
    private javax.swing.JLabel pageDownLabel;
    private javax.swing.JLabel pageUpLabel;
    private javax.swing.JLabel plusLabel2;
    private javax.swing.JLabel qLabel;
    private javax.swing.JLabel qeLabel;
    private javax.swing.JLabel qeLabel1;
    private javax.swing.JLabel rightLabel;
    private javax.swing.JLabel runLabel;
    private javax.swing.JLabel sLabel;
    private javax.swing.JLabel scrollWheelLabel;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JLabel turnLeftLabel;
    private javax.swing.JLabel turnRightLabel;
    private javax.swing.JLabel upLabel;
    private javax.swing.JLabel upLabel2;
    private javax.swing.JLabel wLabel;
    private javax.swing.JLabel zoomInOutLabel;
    // End of variables declaration//GEN-END:variables
}