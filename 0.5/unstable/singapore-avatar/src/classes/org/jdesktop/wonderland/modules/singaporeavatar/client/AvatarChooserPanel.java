/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AvatarChooserPanel.java
 *
 * Created on Aug 30, 2011, 3:49:11 PM
 */
package org.jdesktop.wonderland.modules.singaporeavatar.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JRadioButton;
import org.jdesktop.wonderland.modules.avatarbase.client.registry.AvatarRegistry;
import org.jdesktop.wonderland.modules.avatarbase.client.registry.spi.AvatarSPI;
import org.jdesktop.wonderland.modules.singaporeavatar.client.SingaporeAvatarFactory.Avatar;

/**
 *
 * @author jkaplan
 */
public class AvatarChooserPanel extends javax.swing.JFrame {    
    /** Creates new form AvatarChooserPanel */
    public AvatarChooserPanel() {
        initComponents();
    }

    private void rbChanged() {
        okButton.setEnabled(avatarBG.getSelection() != null);
    }
    
    private AvatarSPI getSelected() {
        for (Enumeration<AbstractButton> buttons = avatarBG.getElements();
             buttons.hasMoreElements();)
        {
            AvatarRB button = (AvatarRB) buttons.nextElement();
            if (button.isSelected()) {
                return button.getAvatar();
            }
        }
        
        return null;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avatarBG = new javax.swing.ButtonGroup();
        bgPanel = new javax.swing.JPanel();
        chooseLabel = new javax.swing.JLabel();
        avatarsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        female1RB = new AvatarRB(Avatar.FEMALE1);
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        female2RB = new AvatarRB(Avatar.FEMALE2);
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        female3RB = new AvatarRB(Avatar.FEMALE_MEDICAL_1);
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        femaleSGGVRB = new AvatarRB(Avatar.FEMALE_MEDICAL_2);
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        male1RB = new AvatarRB(Avatar.MALE1);
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        male2RB = new AvatarRB(Avatar.MALE2);
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        male3RB = new AvatarRB(Avatar.MALE_MEDICAL_1);
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        maleSGGVRB = new AvatarRB(Avatar.MALE_MEDICAL_2);
        buttonPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jdesktop/wonderland/modules/singaporeavatar/client/resources/Bundle"); // NOI18N
        setTitle(bundle.getString("AvatarChooserPanel.title")); // NOI18N
        setBackground(new java.awt.Color(255, 255, 255));

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setPreferredSize(new java.awt.Dimension(260, 429));
        bgPanel.setLayout(new java.awt.BorderLayout());

        chooseLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        chooseLabel.setText(bundle.getString("AvatarChooserPanel.chooseLabel.text")); // NOI18N
        bgPanel.add(chooseLabel, java.awt.BorderLayout.NORTH);

        avatarsPanel.setBackground(new java.awt.Color(255, 255, 255));
        avatarsPanel.setLayout(new java.awt.GridLayout(0, 4, 0, 4));

        jPanel1.setMinimumSize(new java.awt.Dimension(65, 182));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(65, 182));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/singaporeavatar/client/resources/FemalePlayer-1.png"))); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        avatarBG.add(female1RB);
        female1RB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(female1RB, java.awt.BorderLayout.PAGE_END);

        avatarsPanel.add(jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(65, 182));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(65, 182));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/singaporeavatar/client/resources/FemalePlayer-2.png"))); // NOI18N
        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        avatarBG.add(female2RB);
        female2RB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(female2RB, java.awt.BorderLayout.PAGE_END);

        avatarsPanel.add(jPanel2);

        jPanel3.setMinimumSize(new java.awt.Dimension(65, 182));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(65, 182));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/singaporeavatar/client/resources/FemaleMedicalC-2.png"))); // NOI18N
        jPanel3.add(jLabel3, java.awt.BorderLayout.CENTER);

        avatarBG.add(female3RB);
        female3RB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(female3RB, java.awt.BorderLayout.PAGE_END);

        avatarsPanel.add(jPanel3);

        jPanel4.setMinimumSize(new java.awt.Dimension(65, 182));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(65, 182));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/singaporeavatar/client/resources/FemaleMedicalAsian-2-Monica.png"))); // NOI18N
        jPanel4.add(jLabel4, java.awt.BorderLayout.CENTER);

        avatarBG.add(femaleSGGVRB);
        femaleSGGVRB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(femaleSGGVRB, java.awt.BorderLayout.PAGE_END);

        avatarsPanel.add(jPanel4);

        jPanel5.setMinimumSize(new java.awt.Dimension(65, 182));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(65, 182));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/singaporeavatar/client/resources/MalePlayer-1.png"))); // NOI18N
        jPanel5.add(jLabel5, java.awt.BorderLayout.CENTER);

        avatarBG.add(male1RB);
        male1RB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(male1RB, java.awt.BorderLayout.PAGE_END);

        avatarsPanel.add(jPanel5);

        jPanel6.setMinimumSize(new java.awt.Dimension(65, 182));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(65, 182));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/singaporeavatar/client/resources/MalePlayer-2.png"))); // NOI18N
        jPanel6.add(jLabel6, java.awt.BorderLayout.CENTER);

        avatarBG.add(male2RB);
        male2RB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(male2RB, java.awt.BorderLayout.PAGE_END);

        avatarsPanel.add(jPanel6);

        jPanel7.setMinimumSize(new java.awt.Dimension(65, 182));
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(65, 182));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/singaporeavatar/client/resources/MaleMedical-Asian.png"))); // NOI18N
        jPanel7.add(jLabel7, java.awt.BorderLayout.CENTER);

        avatarBG.add(male3RB);
        male3RB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(male3RB, java.awt.BorderLayout.PAGE_END);

        avatarsPanel.add(jPanel7);

        jPanel8.setMinimumSize(new java.awt.Dimension(65, 182));
        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(65, 182));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/singaporeavatar/client/resources/MaleMedical-AA.png"))); // NOI18N
        jPanel8.add(jLabel8, java.awt.BorderLayout.CENTER);

        avatarBG.add(maleSGGVRB);
        maleSGGVRB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel8.add(maleSGGVRB, java.awt.BorderLayout.PAGE_END);

        avatarsPanel.add(jPanel8);

        bgPanel.add(avatarsPanel, java.awt.BorderLayout.CENTER);

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        cancelButton.setText(bundle.getString("AvatarChooserPanel.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        okButton.setText(bundle.getString("AvatarChooserPanel.okButton.text")); // NOI18N
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(okButton);

        bgPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
}//GEN-LAST:event_cancelButtonActionPerformed

private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        AvatarSPI selected = getSelected();
        if (selected != null) {
            AvatarRegistry registry = AvatarRegistry.getAvatarRegistry();
            registry.setAvatarInUse(selected, false);
        }
        
        dispose();
}//GEN-LAST:event_okButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AvatarChooserPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvatarChooserPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvatarChooserPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvatarChooserPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AvatarChooserPanel().setVisible(true);
            }
        });
    }
    
    private class AvatarRB extends JRadioButton {
        private final Avatar avatar;
        
        public AvatarRB(Avatar avatar) {
            this.avatar = avatar;
            
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rbChanged();
                }                
            });
        }
        
        public AvatarSPI getAvatar() {
            return new SingaporeAvatar(avatar);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup avatarBG;
    private javax.swing.JPanel avatarsPanel;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel chooseLabel;
    private javax.swing.JRadioButton female1RB;
    private javax.swing.JRadioButton female2RB;
    private javax.swing.JRadioButton female3RB;
    private javax.swing.JRadioButton femaleSGGVRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton male1RB;
    private javax.swing.JRadioButton male2RB;
    private javax.swing.JRadioButton male3RB;
    private javax.swing.JRadioButton maleSGGVRB;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}