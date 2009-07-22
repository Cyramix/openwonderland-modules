/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AnnotationPane.java
 *
 * Created on Jul 14, 2009, 2:46:25 PM
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
import org.jdesktop.wonderland.modules.annotations.common.Annotation;

/**
 *
 * @author Matt
 */
public class AnnotationPane extends javax.swing.JPanel {

    /**
     * graphical configuration for this panel
     */
    private PanelConfig config;

    private static final String userName = LoginManager.getPrimary().getPrimarySession().getUserID().getUsername();


    /** Creates new form AnnotationPane 
     * @param pc configuration (fonts, colors) for this pane
     * @param a annotation this pane represents
     * @param c cell this annotation is associated with
     */
    public AnnotationPane(PanelConfig pc, Annotation a, Cell c) {
      config = pc;
      initComponents();
      // set author/editted to be italic
       Font italicFont =new Font(pc.getFont().getName(),Font.ITALIC,pc.getFont().getSize());
       author.setFont(italicFont);
       date.setFont(italicFont);
       setPreferredSize(new Dimension(400, 350));
       
       // editing buttons not visible until editing begun
       showEdits(false);

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

    cellIDLabel.setText("Cell ID");

    cellID.setText("id");

    jLabel1.setText("-");

    cellName.setText("jLabel2");

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
            .addComponent(message)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(editableMessageScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
            .addContainerGap())
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
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(editableMessageScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
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
      saveButton.setEnabled(false);
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
  private javax.swing.JLabel jLabel1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JLabel message;
  private javax.swing.JButton saveButton;
  private javax.swing.JButton viewOnHud;
  // End of variables declaration//GEN-END:variables


  /**
   * get current text of panel
   */
  public String getText(){
    return message.getText();
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
//      roundedPane.add(ta);
    }
    else{
      editableMessageScrollPane.setVisible(false);
      message.setVisible(true);
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
