/*
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

package org.jdesktop.wonderland.modules.annotations.client.display;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.wonderland.client.login.LoginManager;
import org.jdesktop.wonderland.common.auth.WonderlandIdentity;
import org.jdesktop.wonderland.modules.annotations.common.Annotation;

/**
 * A JPanel backend for a HUDComponent representing an Annotation. Could be
 * displayed in world or on HUD, via the HUDComponent.
 *
 * At the moment, the HUD
 * system has certain limitations that limited the functionality of the in-world
 * version. Thus, raw Entities (AnnotationEntity) are used to display Annotations
 * in world, and the AnnotationPane/HUDComponent are used only for editing the
 * annotation on the HUD.
 *
 * @author mabonner
 */
public class AnnotationPane extends javax.swing.JPanel {

    /**
     * graphical configuration for this panel
     */
    private PanelConfig config;

    private static final String userName = LoginManager.getPrimary().getPrimarySession().getUserID().getUsername();
//    private static final WonderlandIdentity userID = LoginManager.getPrimary().getPrimarySession().getUserID();

    /** Creates new form AnnotationPane 
     * @param pc configuration (fonts, colors) for this pane
     * @param a annotation this pane represents
     * @param c cell this annotation is associated with
     */
    public AnnotationPane(PanelConfig pc, Annotation a, Cell c) {
      config = pc;
      initComponents();
      setBackground(pc.getBackgroundColor());
      setForeground(pc.getFontColor());
      // set author/editted to be italic
      Font italicFont =new Font(pc.getFont().getName(),Font.ITALIC,pc.getFont().getSize());
      author.setFont(italicFont);
      date.setFont(italicFont);
      setPreferredSize(new Dimension(350, 300));

      // panes are currently used only for editing, so the pane is in edit mode
      // by default now
      showEdits(true);

      // set text to reflect annotation
      author.setText(a.getCreator());
      date.setText(a.getModified());
      cellID.setText(c.getCellID().toString());
      cellName.setText(c.getName());
      message.setText(a.getText());
    }

    /**
     * overwritten to provide white border and rounded corners
     * @param g
     */
//    @Override
//    protected void paintComponent(Graphics g) {
//      int x = 0;
//      int y = 0;
//      int w = getWidth() - 68;
//      int h = getHeight() - 68;
//      int arc = 30;
//
//      Graphics2D g2 = (Graphics2D) g.create();
//      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//              RenderingHints.VALUE_ANTIALIAS_ON);
//
//      g2.setColor(new Color(0, 0, 0, 220));
//      g2.fillRoundRect(x, y, w, h, arc, arc);
//
//      g2.setStroke(new BasicStroke(3f));
//      g2.setColor(Color.WHITE);
//      g2.drawRoundRect(x, y, w, h, arc, arc);
//
//      g2.dispose();
//    }

    public void setConfig(PanelConfig pc){
      config = pc;
    }

    public void addViewOnHudButtonListener(ActionListener l){
      viewOnHud.addActionListener(l);
    }

    public void addSaveButtonListener(ActionListener l){
      saveButton.addActionListener(l);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    dateLabel = new javax.swing.JLabel();
    editableMessageScrollPane = new javax.swing.JScrollPane();
    editableMessage = new javax.swing.JTextArea();
    author = new javax.swing.JLabel();
    date = new javax.swing.JLabel();
    viewOnHud = new javax.swing.JButton();
    saveButton = new javax.swing.JButton();
    message = new javax.swing.JLabel();
    cancelButton = new javax.swing.JButton();
    cellIDLabel = new javax.swing.JLabel();
    cellID = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    cellName = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    subject = new javax.swing.JLabel();
    editableSubjectScrollPane = new javax.swing.JScrollPane();
    editableSubject = new javax.swing.JTextArea();

    setBackground(new java.awt.Color(51, 51, 51));
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });

    dateLabel.setText("at");

    editableMessage.setColumns(20);
    editableMessage.setRows(5);
    editableMessage.setText("message");
    editableMessage.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        editableMessageKeyTyped(evt);
      }
    });
    editableMessageScrollPane.setViewportView(editableMessage);

    author.setText("name");

    date.setText("date");

    viewOnHud.setText("view on hud");
    viewOnHud.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        viewOnHudActionPerformed(evt);
      }
    });

    saveButton.setBackground(new java.awt.Color(153, 153, 255));
    saveButton.setText("save");
    saveButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveButtonActionPerformed(evt);
      }
    });

    message.setText("Message");

    cancelButton.setText("cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });

    cellIDLabel.setText("Cell ID");

    cellID.setText("id");

    jLabel1.setText("-");

    cellName.setText("jLabel2");

    subject.setText("Subject");

    editableSubject.setColumns(20);
    editableSubject.setRows(1);
    editableSubject.setText("subject");
    editableSubject.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        editableSubjectKeyTyped(evt);
      }
    });
    editableSubjectScrollPane.setViewportView(editableSubject);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(author)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(dateLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(date)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
            .addComponent(viewOnHud)
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(cancelButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(saveButton))
          .addGroup(layout.createSequentialGroup()
            .addGap(8, 8, 8)
            .addComponent(cellIDLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cellID)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cellName)
            .addContainerGap(255, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(message)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(editableMessageScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
            .addContainerGap())
          .addGroup(layout.createSequentialGroup()
            .addComponent(subject)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(editableSubjectScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
            .addContainerGap())))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(viewOnHud)
          .addComponent(author)
          .addComponent(dateLabel)
          .addComponent(date))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cellIDLabel)
          .addComponent(cellID)
          .addComponent(jLabel1)
          .addComponent(cellName))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(subject))
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(editableSubjectScrollPane, 0, 0, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(editableMessageScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(saveButton)
              .addComponent(cancelButton)))
          .addComponent(message))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

    private void viewOnHudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOnHudActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_viewOnHudActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
      // component is added as listener, handles actual saving
      // here, just hide the save button
//      message.setText(editableMessage.getText());
      saveButton.setEnabled(false);
      showEdits(false);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editableMessageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editableMessageKeyTyped
      // keys have been typed, activate save button
      saveButton.setEnabled(true);
    }//GEN-LAST:event_editableMessageKeyTyped

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
      if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        // can only edit your own annotations
        if(userName.equals(author.getText())){
          showEdits(true);
        }
      }
    }//GEN-LAST:event_formMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
      // if the annotation pane is ever used to simply display items as well, it
      // should showEdits(false) as well
      editableMessage.setText(fromHTML(message.getText()));
      editableMessageScrollPane.setVisible(true);
      editableSubject.setText(fromHTML(subject.getText()));
      editableSubjectScrollPane.setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editableSubjectKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editableSubjectKeyTyped
      // TODO add your handling code here:
    }//GEN-LAST:event_editableSubjectKeyTyped


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel author;
  private javax.swing.JButton cancelButton;
  private javax.swing.JLabel cellID;
  private javax.swing.JLabel cellIDLabel;
  private javax.swing.JLabel cellName;
  private javax.swing.JLabel date;
  private javax.swing.JLabel dateLabel;
  private javax.swing.JTextArea editableMessage;
  private javax.swing.JScrollPane editableMessageScrollPane;
  private javax.swing.JTextArea editableSubject;
  private javax.swing.JScrollPane editableSubjectScrollPane;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JLabel message;
  private javax.swing.JButton saveButton;
  private javax.swing.JLabel subject;
  private javax.swing.JButton viewOnHud;
  // End of variables declaration//GEN-END:variables


  /**
   * get current text of panel
   */
  public String getText(){
    return message.getText();
  }

  /**
   * set current text of panel
   */
  public void setText(String s){
    message.setText(s);
  }

  /**
   * get current text of panel
   */
  public String getEditableText(){
    return editableMessage.getText();
  }

  /**
   * get current subject of panel
   */
  public String getEditableSubject() {
    return editableSubject.getText();
  }

  /**
   * set current text of panel
   */
  public void setEditableText(String s){
    editableMessage.setText(s);
  }
  
  /**
   * get current Author of panel
   */
  public String getAuthor(){
    return author.getText();
  }

  /**
   * set current Author of panel
   */
  public void setAuthor(String s){
    author.setText(s);
  }
  
  /**
   * get current date of panel
   */
  public String getDate(){
    return date.getText();
  }

  /**
   * set current date of panel
   */
  public void setDate(String s){
    date.setText(s);
  }



  /**
   * switch between editing mode and none editing mode.
   *
   * Editing mode (true) displays save and cancel buttons, and a text area.
   *
   * Non-editing mode hides these buttons and displays text with a label.
   * @param b editing mode
   */
  private void showEdits(boolean b) {
    saveButton.setVisible(b);
    cancelButton.setVisible(b);
    
    // switch to editable (textarea) version
    if(b == true){
      editableMessage.setText(fromHTML(message.getText()));
      editableMessageScrollPane.setVisible(true);
      message.setVisible(false);

      editableSubject.setText(fromHTML(subject.getText()));
      editableSubjectScrollPane.setVisible(true);
      subject.setVisible(false);
    }
    else{
      editableMessageScrollPane.setVisible(false);
      message.setVisible(true);
      editableSubjectScrollPane.setVisible(false);
      editableSubject.setVisible(true);
    }
  }

  /**
   * used to partially convert user entered text (from a text area) into html.
   * This will preserve newlines in a JLabel, for example.
   * Surrounds string in <html> and </html>, replaces \n with <br/>
   * @param s
   * @return
   */
  private String toHTML(String s){
    if(s.indexOf("<html>")  == 0   &&
            (s.indexOf("</html>") == s.length() - 7)){
      System.out.println("ALREADY HTMLD");
      return s;
    }
    String res = "<html>";
    res += s.replaceAll("\n", "<br/>");
    res += "</html>";
    return res;
  }

  /**
   * Opposite of toHTML, removes HTML formatting
   * use to move from a JLabel to something like a JTextArea
   * @param s
   * @return
   */
  String fromHTML(String s){
    if(s.indexOf("<html>")  == 0   &&
            (s.indexOf("</html>") == s.length() - 7)){
      System.out.println("convert back");
      s = s.replaceAll("<br/>", "\n");
      s = s.substring(6, s.length() - 8);
      return s;
    }

    return s;
  }

  

}
