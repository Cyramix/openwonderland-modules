
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
package org.jdesktop.wonderland.modules.movierecorder.client;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.swing.DefaultButtonModel;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.wonderland.client.hud.CompassLayout.Layout;
import org.jdesktop.wonderland.client.hud.HUD;
import org.jdesktop.wonderland.client.hud.HUDComponent;
import org.jdesktop.wonderland.client.hud.HUDManagerFactory;

/**
 * Control panel for movie recorder. Provides buttons to start & stop recording,
 * and function to set the location of recorded movie.
 * @author Bernard Horan
 */
public class MovieControlPanel extends javax.swing.JPanel {

    private static final Logger LOGGER = Logger.getLogger(
            MovieControlPanel.class.getName());
    private static final ResourceBundle bundle = ResourceBundle.getBundle(
            "org/jdesktop/wonderland/modules/movierecorder/client/resources/Bundle");
    private MovieRecorderCell recorderCell;
    private HUDComponent messageComponent;

    /** Creates new form MovieControlPanel
     * @param recorderCell the movie recorder cell controlled by this panel
     */
    public MovieControlPanel(MovieRecorderCell recorderCell) {
        this.recorderCell = recorderCell;
        initComponents();
        movieDirectoryField.setText(getDefaultMovieDirectory());
        picturesDirectoryField.setText(getDefaultStillCaptureDirectory());
        previewPanel.setLayout(new GridBagLayout());
        previewPanel.add(recorderCell.getCaptureComponent());
//        if (recorderCell.isRemoteRecording()) {
//            disableAllButtons();
//        }
        recorderCell.getVideoButtonModel().addItemListener(
                new VideoButtonListener());
    }

    /**
     * returns the recorder cell
     * @return the recorder cell
     */
    public Cell getCell() {
        return recorderCell;
    }

    void setRemoteRecording(boolean b) {
        enableAllButtons(!b);
        //If the remote client is no longer recording, disable the stop button
        if (!b) {
            stopButton.setEnabled(false);
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

        controlPanel = new javax.swing.JPanel();
        recorderStatusLabel = new javax.swing.JLabel();
        recordButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        movieDirectoryField = new javax.swing.JTextField();
        movieDirectoryLabel = new javax.swing.JLabel();
        moviePathBrowseButton = new javax.swing.JButton();
        picturesLabelDirectory = new javax.swing.JLabel();
        picturesDirectoryField = new javax.swing.JTextField();
        picturesPathBrowseButton = new javax.swing.JButton();
        snapshotButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        previewPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        recorderStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recorderStatusLabel.setText(bundle.getString("OFFLINE")); // NOI18N
        recorderStatusLabel.setToolTipText(bundle.getString("RECORDER_STATUS")); // NOI18N

        recordButton.setText(bundle.getString("RECORD")); // NOI18N
        recordButton.setToolTipText(bundle.getString("CLICK_TO_START_RECORDING_THE_WORLD")); // NOI18N
        recordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButtonActionPerformed(evt);
            }
        });

        stopButton.setText(bundle.getString("STOP")); // NOI18N
        stopButton.setToolTipText(bundle.getString("CLICK_TO_STOP_RECORDING_AND_CREATE_A_MOVIE")); // NOI18N
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        movieDirectoryField.setEditable(false);
        movieDirectoryField.setToolTipText(bundle.getString("DIRECTORY_FOR_SAVING_THE_MOVIE")); // NOI18N

        movieDirectoryLabel.setText(bundle.getString("MOVIE_DIRECTORY:")); // NOI18N

        moviePathBrowseButton.setText(bundle.getString("SELECT...")); // NOI18N
        moviePathBrowseButton.setToolTipText(bundle.getString("SELECT_DIRECTORY_FOR_MOVIES")); // NOI18N
        moviePathBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moviePathBrowseButtonActionPerformed(evt);
            }
        });

        picturesLabelDirectory.setText(bundle.getString("PICTURES_DIRECTORY:")); // NOI18N

        picturesDirectoryField.setEditable(false);
        picturesDirectoryField.setToolTipText(bundle.getString("DIRECTORY_FOR_SAVING_THE_PICTURES")); // NOI18N

        picturesPathBrowseButton.setText(bundle.getString("SELECT...")); // NOI18N
        picturesPathBrowseButton.setToolTipText(bundle.getString("SELECT_DIRECTORY_FOR_PICTURES")); // NOI18N
        picturesPathBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                picturesPathBrowseButtonActionPerformed(evt);
            }
        });

        snapshotButton.setText(bundle.getString("SNAPSHOT")); // NOI18N
        snapshotButton.setToolTipText(bundle.getString("CLICK_TO_TAKE_A_PICTURE")); // NOI18N
        snapshotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snapshotButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        org.jdesktop.layout.GroupLayout controlPanelLayout = new org.jdesktop.layout.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(controlPanelLayout.createSequentialGroup()
                        .add(picturesLabelDirectory)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(picturesDirectoryField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(picturesPathBrowseButton))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, controlPanelLayout.createSequentialGroup()
                        .add(controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, controlPanelLayout.createSequentialGroup()
                                .add(recordButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(stopButton)
                                .add(13, 13, 13)
                                .add(recorderStatusLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 88, Short.MAX_VALUE)
                                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(controlPanelLayout.createSequentialGroup()
                                .add(movieDirectoryLabel)
                                .add(18, 18, 18)
                                .add(movieDirectoryField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, moviePathBrowseButton)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, snapshotButton))))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(controlPanelLayout.createSequentialGroup()
                .add(controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(picturesLabelDirectory)
                    .add(picturesDirectoryField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(picturesPathBrowseButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(movieDirectoryLabel)
                    .add(movieDirectoryField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(moviePathBrowseButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(recordButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(stopButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(recorderStatusLabel)
                        .add(snapshotButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(controlPanel, java.awt.BorderLayout.PAGE_END);

        org.jdesktop.layout.GroupLayout previewPanelLayout = new org.jdesktop.layout.GroupLayout(previewPanel);
        previewPanel.setLayout(previewPanelLayout);
        previewPanelLayout.setHorizontalGroup(
            previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 434, Short.MAX_VALUE)
        );
        previewPanelLayout.setVerticalGroup(
            previewPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 364, Short.MAX_VALUE)
        );

        add(previewPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButtonActionPerformed
        recorderCell.getVideoButtonModel().setSelected(true);
        //Rest of the action takes place in the videoButtonModel listeners
        //See this class's inner class VideoButonListener for display updates
        //See MovieRecorderCell's inner class VideoButtonListener for "model" updates    
    }//GEN-LAST:event_recordButtonActionPerformed

    private void disableLocalButtons() {
        enableLocalButtons(false);
    }

    private void disableAllButtons() {
        enableAllButtons(false);
    }

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        recorderCell.getVideoButtonModel().setSelected(false);
        //Rest of the action takes place in the videoButtonModel listeners
        //See this class's inner class VideoButonListener for display updates
        //See MovieRecorderCell's inner class VideoButtonListener for "model" updates       
}//GEN-LAST:event_stopButtonActionPerformed

    void enableLocalButtons() {
        enableLocalButtons(true);
    }

    private void enableLocalButtons(boolean enable) {
        recordButton.setEnabled(enable);
        moviePathBrowseButton.setEnabled(enable);
        movieDirectoryField.setEnabled(enable);
        picturesPathBrowseButton.setEnabled(enable);
        picturesDirectoryField.setEnabled(enable);
    }

    private void enableAllButtons(boolean enable) {
        enableLocalButtons(enable);
        stopButton.setEnabled(enable);
    }

    /**
     * The location of the JPEGs
     * @return A File identifying a directory/folder that contains the JPEGs of
     * the recording
     */
    public File getImageDirectory() {
        return MovieRecorderCell.getImageDirectory();
    }

    /**
     * The direcotry into which the movie should be created
     * @return The absolute path of the location of the hdirectory in which the
     * movie should be saved
     */
    public String getMovieDirectory() {
        return movieDirectoryField.getText();
    }

    /**
     * The direcotry into which the movie should be created
     * @return The absolute path of the location of the hdirectory in which the
     * movie should be saved
     */
    public String getPicturesDirectory() {
        return picturesDirectoryField.getText();
    }

    /**
     * The frames per second at which the JPEGs were recorded
     * @return a float representing the frames per second that the JPEGs were
     * recorded
     */
    public float getCapturedFrameRate() {
        return recorderCell.getCapturedFrameRate();
    }

    private String getDefaultMovieDirectory() {
        String home = System.getProperty("user.home");
        //
        //Are we on a PC?
        File myDocuments = new File(home + File.separator
                + bundle.getString("MY_DOCUMENTS") + File.separator
                + bundle.getString("MY_VIDEOS"));
        if (myDocuments.exists()) {
            return myDocuments.toString();
        }
        //
        //Or a Mac?
        File movies =
                new File(home + File.separator + bundle.getString("MOVIES"));
        if (movies.exists()) {
            return movies.toString();
        }
        //
        //Or Gnome?
        File documents =
                new File(home + File.separator + bundle.getString("VIDEOS"));
        if (documents.exists()) {
            return documents.toString();
        }
        //
        //Otherwise
        return home;
    }

    private String getDefaultStillCaptureDirectory() {
        String home = System.getProperty("user.home");
        //
        //Are we on a PC?
        File myDocuments = new File(home + File.separator
                + bundle.getString("MY_DOCUMENTS") + File.separator
                + bundle.getString("MY_PICTURES"));
        if (myDocuments.exists()) {
            return myDocuments.toString();
        }
        //
        //Or a Mac?
        File pictures =
                new File(home + File.separator + bundle.getString("PICTURES"));
        if (pictures.exists()) {
            return pictures.toString();
        }
        //
        //Or Gnome?
        File documents =
                new File(home + File.separator + bundle.getString("DOCUMENTS"));
        if (documents.exists()) {
            return documents.toString();
        }
        //
        //Otherwise
        return home;
    }

    public void notifyHUD() {
        if (messageComponent == null) {
            HUD mainHUD = HUDManagerFactory.getHUDManager().getHUD("main");
            messageComponent =
                    mainHUD.createMessage(bundle.getString("SAVED_MOVIE"));
            messageComponent.setPreferredLocation(Layout.NORTHEAST);
            messageComponent.setDecoratable(false);
            mainHUD.addComponent(messageComponent);
        }
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                messageComponent.setVisible(true);
            }
        });
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                messageComponent.setVisible(false, 2000);
            }
        });
    }

    private void moviePathBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moviePathBrowseButtonActionPerformed
        JFileChooser outputPathFileChooser = new JFileChooser();

        outputPathFileChooser.setDialogTitle(
                bundle.getString("MOVIES_DIRECTORY"));
        outputPathFileChooser.setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);
        outputPathFileChooser.setAcceptAllFileFilterUsed(false);

        int outputPath = outputPathFileChooser.showOpenDialog(this);

        if (outputPath == JFileChooser.APPROVE_OPTION) {
            movieDirectoryField.setText(
                    outputPathFileChooser.getSelectedFile().getAbsolutePath());
        }
}//GEN-LAST:event_moviePathBrowseButtonActionPerformed

    private void picturesPathBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_picturesPathBrowseButtonActionPerformed
        JFileChooser outputPathFileChooser = new JFileChooser();

        outputPathFileChooser.setDialogTitle(
                bundle.getString("PICTURES_DIRECTORY"));
        outputPathFileChooser.setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);
        outputPathFileChooser.setAcceptAllFileFilterUsed(false);

        int outputPath = outputPathFileChooser.showOpenDialog(this);

        if (outputPath == JFileChooser.APPROVE_OPTION) {
            picturesDirectoryField.setText(
                    outputPathFileChooser.getSelectedFile().getAbsolutePath());
        }
}//GEN-LAST:event_picturesPathBrowseButtonActionPerformed

    private void snapshotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snapshotButtonActionPerformed
        DefaultButtonModel stillButtonModel =
                recorderCell.getStillButtonModel();
        //simulate a press
        stillButtonModel.setPressed(true);
        stillButtonModel.setSelected(true);
        //simulate a release
        stillButtonModel.setPressed(false);
        stillButtonModel.setSelected(false);
}//GEN-LAST:event_snapshotButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField movieDirectoryField;
    private javax.swing.JLabel movieDirectoryLabel;
    private javax.swing.JButton moviePathBrowseButton;
    private javax.swing.JTextField picturesDirectoryField;
    private javax.swing.JLabel picturesLabelDirectory;
    private javax.swing.JButton picturesPathBrowseButton;
    private javax.swing.JPanel previewPanel;
    private javax.swing.JButton recordButton;
    private javax.swing.JLabel recorderStatusLabel;
    private javax.swing.JButton snapshotButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

    class VideoButtonListener implements ItemListener {

        public void itemStateChanged(final ItemEvent event) {
            //update the control panel
            //logger.info("event: " + event);
            try {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            recorderStatusLabel.setText(
                                    bundle.getString("RECORDING"));
                            recorderStatusLabel.setForeground(Color.red);
                            stopButton.setEnabled(true);
                            disableLocalButtons();
                        } else {
                            stopButton.setEnabled(false);
                            recorderCell.stopRecording();
                            recorderStatusLabel.setText(
                                    bundle.getString("OFFLINE"));
                            recorderStatusLabel.setForeground(Color.BLACK);
                        }
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Cannot update state of UI");
            }

        }
    }
}
