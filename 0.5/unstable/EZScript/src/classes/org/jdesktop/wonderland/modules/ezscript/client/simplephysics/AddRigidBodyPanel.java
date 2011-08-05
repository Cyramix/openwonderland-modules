/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddRigidBodyPanel.java
 *
 * Created on Aug 5, 2011, 9:46:49 AM
 */
package org.jdesktop.wonderland.modules.ezscript.client.simplephysics;

/**
 *
 * @author ryan
 */
public class AddRigidBodyPanel extends javax.swing.JPanel {

    /** Creates new form AddRigidBodyPanel */
    public AddRigidBodyPanel() {
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

        addBoxButton = new javax.swing.JButton();
        addSphereButton = new javax.swing.JButton();
        addPlaneButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        addBoxButton.setLabel("Box");
        addBoxButton.setPreferredSize(new java.awt.Dimension(64, 64));
        add(addBoxButton, new java.awt.GridBagConstraints());

        addSphereButton.setText("Sphere");
        addSphereButton.setToolTipText("Add Sphere ");
        addSphereButton.setPreferredSize(new java.awt.Dimension(64, 64));
        add(addSphereButton, new java.awt.GridBagConstraints());

        addPlaneButton.setText("Plane");
        addPlaneButton.setToolTipText("Add Ground Plane");
        addPlaneButton.setPreferredSize(new java.awt.Dimension(64, 64));
        add(addPlaneButton, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBoxButton;
    private javax.swing.JButton addPlaneButton;
    private javax.swing.JButton addSphereButton;
    // End of variables declaration//GEN-END:variables
}
