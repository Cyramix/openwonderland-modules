/**
 * Copyright (c) 2012, WonderBuilders, Inc., All Rights Reserved
 */

/*
 * WorldSheetManager.java
 *
 * Created on Apr 16, 2012, 6:55:17 AM
 */
package org.jdesktop.wonderland.modules.isocial.scavenger.client;

import java.awt.Component;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.xml.bind.JAXBContext;
import org.jdesktop.wonderland.client.hud.HUDComponent;
import org.jdesktop.wonderland.client.login.ServerSessionManager;
import org.jdesktop.wonderland.modules.isocial.client.ISocialManager;
import org.jdesktop.wonderland.modules.isocial.common.ISocialStateUtils;
import org.jdesktop.wonderland.modules.isocial.common.model.Sheet;
import org.jdesktop.wonderland.modules.isocial.scavenger.common.ScavengerHuntConstants;
import org.jdesktop.wonderland.modules.isocial.scavenger.common.ScavengerHuntSheet;

/** In-world sheet manager for basic sheet operations.
 *
 * @author Vladimir Djurovic
 */
public class WorldSheetManager extends javax.swing.JDialog {
    
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ScavengerHuntConstants.STRINGS_PATH);
    private static final Logger LOGGER = Logger.getLogger(WorldSheetManager.class.getName());
    
    /** Base URL for snapshot resources. */
    private static final String SNAPSHOT_UPDATE_BASE = "/isocial-sheets/isocial-sheets/resources/snapshots/update";
    
    /** Base URL for sheet resources. */
    private static final String SHEET_UPDATE_BASE = "/isocial-sheets/isocial-sheets/resources/sheets";
    
    private ServerSessionManager sessionManager;
    private String unitId;
    private String lessonId;

    /** Creates new form WorldSheetManager */
    public WorldSheetManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try{
            sessionManager = ISocialManager.INSTANCE.getSession();
            List<Sheet> sheets = ISocialManager.INSTANCE.getCurrentInstance().getSheets();
            DefaultListModel model = new DefaultListModel();
            unitId = ISocialManager.INSTANCE.getCurrentInstance().getUnit().getId();
            lessonId = ISocialManager.INSTANCE.getCurrentInstance().getLesson().getId();
            for(Sheet sh : sheets){
                model.addElement(sh);
            }
            sheetsList.setModel(model);
            sheetsList.setCellRenderer(new SheetCellRenderer());
            
        } catch(IOException ex){
            throw new RuntimeException(ex);
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sheetTitleLabel = new javax.swing.JLabel();
        instructionsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sheetsList = new javax.swing.JList();
        configButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jdesktop/wonderland/modules/isocial/scavenger/client/resources/strings"); // NOI18N
        setTitle(bundle.getString("WorldSheetManager.title")); // NOI18N
        setResizable(false);

        sheetTitleLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        sheetTitleLabel.setText(bundle.getString("WorldSheetManager.sheetTitleLabel.text")); // NOI18N

        instructionsLabel.setText(bundle.getString("WorldSheetManager.instructionsLabel.text")); // NOI18N

        sheetsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        sheetsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sheetsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sheetsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sheetsList);

        configButton.setText(bundle.getString("WorldSheetManager.configButton.text")); // NOI18N
        configButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configButtonActionPerformed(evt);
            }
        });

        updateButton.setText(bundle.getString("WorldSheetManager.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sheetTitleLabel)
                    .addComponent(instructionsLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(configButton)
                        .addGap(60, 60, 60)
                        .addComponent(updateButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sheetTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(configButton)
                    .addComponent(updateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configButtonActionPerformed
        // open/close HUD components based on autoOpen property
        for(int i = 0;i < sheetsList.getModel().getSize();i++){
            Sheet sheet = (Sheet)sheetsList.getModel().getElementAt(i);
            try {
//                Method setter = sheet.getDetails().getClass().getMethod("setAutoOpen", boolean.class);
                Method getter = sheet.getDetails().getClass().getMethod("isAutoOpen");
                boolean state = false;
                if (getter != null) {
                    state = (Boolean) getter.invoke(sheet.getDetails());
                }
                Collection<HUDComponent> comps = ISocialManager.INSTANCE.getHUDComponents(sheet.getId());
                for (HUDComponent comp : comps) {
                    comp.setVisible(state);
                }
                
            } catch (Exception ex) {
                LOGGER.log(Level.WARNING, "Could not find auto open method for {0}", sheet.getDetails().getName());
            }
            
            
            // update sheet configuration on server
            StringBuilder sb = new StringBuilder("http://").append(sessionManager.getServerNameAndPort());
            sb.append(SHEET_UPDATE_BASE).append("/").append(unitId).append("/").append(lessonId).append("/").append(sheet.getId());
            
            try{
                URL url = new URL(sb.toString());
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/xml"); 
                // write sheet XML data
                OutputStream out = conn.getOutputStream();
                JAXBContext ctx = ISocialStateUtils.createContext(sessionManager.getClassloader());
                ctx.createMarshaller().marshal(sheet, out);
                out.flush();
                
                 int response = conn.getResponseCode();
            if(response != 200){
                JOptionPane.showMessageDialog(this, 
                                               MessageFormat.format(BUNDLE.getString(ScavengerHuntConstants.KEY_SHEET_ERROR), response), 
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch(Exception ex){
                throw new RuntimeException(ex);
            }
        }
        dispose();
    }//GEN-LAST:event_configButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
         // show warning message
        int result = JOptionPane.showConfirmDialog(this, 
                                                   BUNDLE.getString(ScavengerHuntConstants.KEY_SNAPSHOT_WARN), 
                                                   BUNDLE.getString(ScavengerHuntConstants.KEY_SNAPSHOT_WARN_TITLE), 
                                                   JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.NO_OPTION){
            return;
        }
        // construct snapshots URL
        StringBuilder sb = new StringBuilder("http://");
        sb.append(sessionManager.getServerNameAndPort());
        sb.append(SNAPSHOT_UPDATE_BASE).append("?unitId=").append(unitId).append("&lessonId=").append(lessonId);
        
        try{
            URL url = new URL(sb.toString());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            sessionManager.getCredentialManager().secureURLConnection(conn);
            int response = conn.getResponseCode();
            if(response != 200){
                JOptionPane.showMessageDialog(this, 
                                              MessageFormat.format(BUNDLE.getString(ScavengerHuntConstants.KEY_SNAPSHOT_ERROR), response), 
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
        
        dispose();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void sheetsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheetsListMouseClicked
        // index of selected item
        int index = sheetsList.locationToIndex(evt.getPoint());
        Sheet sheet = (Sheet) sheetsList.getModel().getElementAt(index);
        if (sheet.getDetails() instanceof ScavengerHuntSheet) {
            ScavengerHuntSheet shs = (ScavengerHuntSheet) sheet.getDetails();
            shs.setAutoOpen(!shs.isAutoOpen());
            sheet.setDetails(shs);
            ((DefaultListModel) sheetsList.getModel()).setElementAt(sheet, index);
        } else {
            try {
                Method setter = sheet.getDetails().getClass().getMethod("setAutoOpen", boolean.class);
                Method getter = sheet.getDetails().getClass().getMethod("isAutoOpen");
                boolean state = false;
                if (getter != null) {
                    state = (Boolean) getter.invoke(sheet.getDetails());
                }
                if (setter != null) {
                    setter.invoke(sheet.getDetails(), !state);
                }
            } catch (Exception ex) {
                LOGGER.log(Level.WARNING, "Could not find auto open method for {0}", sheet.getDetails().getName());
            }

        }
    }//GEN-LAST:event_sheetsListMouseClicked

    private class SheetCellRenderer implements ListCellRenderer{

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JCheckBox cb = new JCheckBox();
            Sheet sheet = (Sheet) value;
            cb.setText(sheet.getDetails().getName());
            try {
                Method method = sheet.getDetails().getClass().getMethod("isAutoOpen");
                if (method != null) {
                    boolean state = (Boolean) method.invoke(sheet.getDetails());
                    cb.setSelected(state);
                }
            } catch (Exception ex) {
                LOGGER.log(Level.WARNING, "Could not find auto open method for {0}", sheet.getDetails().getName());
            }

            return cb;
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configButton;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sheetTitleLabel;
    private javax.swing.JList sheetsList;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
