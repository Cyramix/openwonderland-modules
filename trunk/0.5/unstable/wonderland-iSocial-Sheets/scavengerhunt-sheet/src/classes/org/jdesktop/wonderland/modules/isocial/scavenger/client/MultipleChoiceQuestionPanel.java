/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdesktop.wonderland.modules.isocial.scavenger.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import org.jdesktop.wonderland.client.cell.asset.AssetUtils;
import org.jdesktop.wonderland.modules.isocial.scavenger.common.Question;

/**
 *
 * @author vlada
 */
public class MultipleChoiceQuestionPanel extends javax.swing.JPanel {
    
    private static final Logger LOGGER = Logger.getLogger(MultipleChoiceConfigPanel.class.getName());
    
    private JDialog parent;
    private Question question;
    private ButtonGroup bgroup;
     private ImageIcon correctIcon;
    private ImageIcon wrongIcon;

    /**
     * Creates new form MultipleChoiceQuestionPanel
     */
    public MultipleChoiceQuestionPanel(Question question, JDialog parent) {
        initComponents();
        correctIcon = new ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/isocial/scavenger/client/resources/icons/check-mark.png"));
        wrongIcon = new ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/isocial/scavenger/client/resources/icons/Red_x.png"));
        this.parent = parent;
        this.question = question;
        bgroup = new ButtonGroup();
        
        StringBuilder sb = new StringBuilder("<html><body style=\"width:150px\">");
        sb.append(question.getQuestionText()).append("</body></html>");
        questionTextLabel.setText(sb.toString());
        
        for(String answer : question.getMultipleChoiceQuestion().getAnswers()){
            JRadioButton rb = new JRadioButton(answer);
            rb.addActionListener(new AnswerListener());
            bgroup.add(rb);
            answersPanel.add(rb);
        }
        if (question.getMultipleChoiceQuestion().getImageUrl() != null) {
            try {
                URL url = AssetUtils.getAssetURL(question.getMultipleChoiceQuestion().getImageUrl());
                ImageIcon img = new ImageIcon(url);
                if (img.getIconWidth() > 128) {
                    imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(128, 128, 0)));
                } else {
                    imageLabel.setIcon(img);
                }

            } catch (MalformedURLException ex) {
                LOGGER.log(Level.SEVERE, "Could not load question image: {0}" , ex.getMessage());
            }
        }
        
    }
    
    private class AnswerListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            int correctIndex = question.getMultipleChoiceQuestion().getCorrectIndex();
            
            Enumeration<AbstractButton> buttons = bgroup.getElements();
            int i = 0;
            while(buttons.hasMoreElements()){
                AbstractButton ab = buttons.nextElement();
                if(ab.isSelected()){
                    if(i == correctIndex){
                        ab.setIcon(correctIcon);
                        feedbackLabel.setText(question.getMultipleChoiceQuestion().getGlobalFeedbackCorrect() + " " + question.getMultipleChoiceQuestion().getFeedbacks().get(i));
                    } else {
                        ab.setIcon(wrongIcon);
                        feedbackLabel.setText(question.getMultipleChoiceQuestion().getGlobalFeedbackWrong() + " " + question.getMultipleChoiceQuestion().getFeedbacks().get(i));
                    }
                    break;
                }
                i++;
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        questionTextLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        answersPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        feedbackLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        questionTextLabel.setText("jLabel1");
        questionTextLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(questionTextLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(58, 58, 58)
                .add(imageLabel)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(imageLabel)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(questionTextLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        answersPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        answersPanel.setLayout(new javax.swing.BoxLayout(answersPanel, javax.swing.BoxLayout.Y_AXIS));
        add(answersPanel, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        feedbackLabel.setText("  ");
        jPanel2.add(feedbackLabel);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(submitButton);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        parent.dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel answersPanel;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel questionTextLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
