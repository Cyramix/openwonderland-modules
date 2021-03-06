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

import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.apache.batik.ext.awt.image.spi.ImageTagRegistry;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.wonderland.client.jme.ClientContextJME;

/**
 *
 * @author ryan
 */
public class ImageCaptureHarness extends javax.swing.JPanel {

    /** Creates new form ImageCaptureHarness */
    private static int index = 0;
    private boolean locked = true;
    private String imageURL = "";
    private String filename;

    public ImageCaptureHarness() {
        initComponents();
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageLabel = new javax.swing.JLabel();
        captureButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        imageLabel.setMaximumSize(new java.awt.Dimension(256, 256));
        imageLabel.setMinimumSize(new java.awt.Dimension(128, 128));

        captureButton.setText("Take picture!");
        captureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Accept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(110, 110, 110)
                        .add(captureButton))
                    .add(layout.createSequentialGroup()
                        .add(123, 123, 123)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(imageLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 317, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(imageLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 348, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 204, Short.MAX_VALUE)
                .add(captureButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1)
                .add(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void captureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureButtonActionPerformed
        // TODO add your handling code here:
        Runtime rt = Runtime.getRuntime();
        try {
            //Process pr = rt.exec("imagecapture myPicture.jpg");
            ImageTagRegistry.getRegistry().flushCache();

            //craft file name
                Cell cell = ClientContextJME.getViewManager().getPrimaryViewCell();
                String name = cell.getCellCache().getSession().getUserID().getUsername();
                filename = name+Integer.toString(index)+ ".jpg";
                System.out.println("Processing file: " + filename);
                

            // kind of basackwards... let's look into doing this a better way.


            Process pr = rt.exec("./imagesnap " + filename);
            pr.waitFor();

           // pr = rt.exec("curl http://isocial-sas.missouri.edu:8080/content-repository/wonderland-content-repository/browse/"+filename+"?action=delete");
           // pr.waitFor();

            pr = rt.exec("curl --form file=@"+filename+" --form press=Upload http://127.0.0.1:8080/content-repository/wonderland-content-repository/browse");
            pr.waitFor();

            URL url = new URL("http://127.0.0.1:8080/content-repository/wonderland-content-repository/browse/"+filename);
            ImageIcon ikon = new ImageIcon(url);
         //   ImageIcon ikon = new ImageIcon("http://isocial-temp.missouri.edu:8080/content-repository/wonderland-content-repository/browse/myTest2.jpg");
           // MediaTracker m = new MediaTracker(imageLabel);

            System.out.println(ikon.getImageLoadStatus());


            imageLabel.setIcon(ikon);
            index += 1;
        } catch(Exception e) {
           System.out.println("fail!");
           e.printStackTrace();
        }
    }//GEN-LAST:event_captureButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //imageURL = "http://isocial-sas.missouri.edu:8080/content-repository/wonderland-content-repository/browse/myTest4.jpg";
        
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    public void addAcceptButtonActionPerformed(ActionListener listener) {
        jButton1.addActionListener(listener);
    }

    /**
    * @param args the command line arguments
    */


    public String getPictureURLAsString() {
        return "http://127.0.0.1:8080/content-repository/wonderland-content-repository/browse/"+filename;
    }

    public void setFormVisible(boolean value) {
        this.setVisible(value);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton captureButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

}
