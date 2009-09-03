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
package org.jdesktop.wonderland.modules.cmu.client.hud;

import org.jdesktop.wonderland.modules.cmu.client.CMUCell;
import org.jdesktop.wonderland.modules.cmu.client.events.PlaybackChangeEvent;
import org.jdesktop.wonderland.modules.cmu.client.events.PlaybackChangeListener;
import org.jdesktop.wonderland.modules.cmu.client.*;
import javax.swing.SwingUtilities;
import org.jdesktop.wonderland.modules.cmu.client.events.VisibilityChangeEvent;
import org.jdesktop.wonderland.modules.cmu.client.events.VisibilityChangeListener;
import org.jdesktop.wonderland.modules.cmu.common.PlaybackDefaults;
import org.jdesktop.wonderland.modules.cmu.common.VisualType;

/**
 *
 * @author kevin
 */
public class ActiveHUD extends CMUPanel implements PlaybackChangeListener, VisibilityChangeListener {

    private final static String PLAYBUTTON_PATH = "/org/jdesktop/wonderland/modules/cmu/client/resources/control_play.png";
    private final static String PAUSEBUTTON_PATH = "/org/jdesktop/wonderland/modules/cmu/client/resources/control_pause.png";
    private final static float PLAYBACK_MAX = 10.0f;
    private final static float PLAYBACK_MIN = 0.1f;
    private final static int SLIDER_DEFAULT = 0;
    private final int SLIDER_MIN;
    private final int SLIDER_MAX;
    private boolean playing;
    private transient final Object playbackLock = new Object();
    private final CMUCell cell;

    /** 
     * Creates new form CMUJPanel
     * @param cell The CMU cell to which this HUD is attached
     */
    public ActiveHUD(CMUCell cell) {
        initComponents();
        SLIDER_MIN = playbackSlider.getMinimum();
        SLIDER_MAX = playbackSlider.getMaximum();
        this.cell = cell;
        this.cell.addPlaybackChangeListener(this);
        this.playbackChanged(new PlaybackChangeEvent(cell, cell.getPlaybackSpeed(), cell.isPlaying()));
        this.cell.addGroundPlaneChangeListener(this);
        this.visibilityChanged(new VisibilityChangeEvent(cell, VisualType.GROUND, cell.isGroundPlaneShowing()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groundVisibleBox = new javax.swing.JCheckBox();
        playbackSlider = new javax.swing.JSlider();
        playPauseButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        speedResetButton = new javax.swing.JButton();
        javax.swing.JLabel speedFixedLabel = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();

        groundVisibleBox.setText("Ground visible?");
        groundVisibleBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                groundVisibleBoxMouseReleased(evt);
            }
        });

        playbackSlider.setFont(new java.awt.Font("DejaVu Sans", 0, 1));
        playbackSlider.setMaximum(45);
        playbackSlider.setMinimum(-18);
        playbackSlider.setPaintTrack(false);
        playbackSlider.setSnapToTicks(true);
        playbackSlider.setToolTipText("Playback speed");
        playbackSlider.setValue(0);
        playbackSlider.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        playbackSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playbackSliderMouseReleased(evt);
            }
        });
        playbackSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                playbackSliderStateChanged(evt);
            }
        });

        playPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/cmu/client/resources/control_play.png"))); // NOI18N
        playPauseButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        playPauseButton.setBorderPainted(false);
        playPauseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playPauseButtonMouseReleased(evt);
            }
        });

        restartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/jdesktop/wonderland/modules/cmu/client/resources/control_start.png"))); // NOI18N
        restartButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        restartButton.setBorderPainted(false);
        restartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                restartButtonMouseReleased(evt);
            }
        });

        speedResetButton.setText(" Reset speed ");
        speedResetButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        speedResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                speedResetButtonMouseReleased(evt);
            }
        });

        speedFixedLabel.setText("Speed:");

        speedLabel.setText("1x");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playPauseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groundVisibleBox))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(speedFixedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(speedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(speedResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(playbackSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speedFixedLabel)
                    .addComponent(speedLabel)
                    .addComponent(speedResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playbackSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playPauseButton)
                    .addComponent(restartButton)
                    .addComponent(groundVisibleBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void playPauseButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playPauseButtonMouseReleased
        // Toggle play/pause
        cell.setPlaying(!isPlaying());
    }//GEN-LAST:event_playPauseButtonMouseReleased

    private void playbackSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playbackSliderMouseReleased
        cell.setPlaybackSpeed(sliderPosToPlaybackSpeed(playbackSlider.getValue()));
    }//GEN-LAST:event_playbackSliderMouseReleased

    private void playbackSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_playbackSliderStateChanged
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                speedLabel.setText(sliderPosToPlaybackSpeed(playbackSlider.getValue()) + "x");
            }
        });
    }//GEN-LAST:event_playbackSliderStateChanged

    private void speedResetButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_speedResetButtonMouseReleased
        cell.setPlaybackSpeed(PlaybackDefaults.DEFAULT_START_SPEED);
    }//GEN-LAST:event_speedResetButtonMouseReleased

    private void groundVisibleBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groundVisibleBoxMouseReleased
        cell.setGroundPlaneShowing(groundVisibleBox.isSelected());
    }//GEN-LAST:event_groundVisibleBoxMouseReleased

    private void restartButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restartButtonMouseReleased
        cell.restart();
    }//GEN-LAST:event_restartButtonMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox groundVisibleBox;
    private javax.swing.JButton playPauseButton;
    private javax.swing.JSlider playbackSlider;
    private javax.swing.JButton restartButton;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JButton speedResetButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Update the displayed play/pause state and playback speed of the panel;
     * don't notify the cell of these changes (this should be called in
     * response to changes on the cell).
     * @param e {@inheritDoc}
     */
    public void playbackChanged(PlaybackChangeEvent e) {
        synchronized (this.playbackLock) {
            // Set play/pause appropriately
            setPlaying(e.isPlaying());

            // Set playback speed
            setPlaybackSpeed(e.getPlaybackSpeed());
        }
    }

    /**
     * Update the playback slider with the given playback speed, positioning
     * it according to the scaling functions.  Doesn't do anything to notify
     * the cell explicitly; this is should be called in response to changes on
     * the cell.
     * @param fPlaybackSpeed Exact playback speed
     */
    private void setPlaybackSpeed(float fPlaybackSpeed) {
        int playbackSpeed = playbackSpeedToSliderPos(fPlaybackSpeed);
        if (playbackSpeed < SLIDER_MIN) {
            playbackSpeed = SLIDER_MIN;
        }
        if (playbackSpeed > SLIDER_MAX) {
            playbackSpeed = SLIDER_MAX;
        }

        final int playbackSpeedCopy = playbackSpeed;
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                synchronized (playbackLock) {
                    playbackSlider.setValue(playbackSpeedCopy);
                }
            }
        });
    }

    /**
     * Get the play/pause state of this panel (should correspond almost exactly
     * with the appearance of the play/pause button).
     * @return Whether we're playing (true) or paused (false)
     */
    private boolean isPlaying() {
        synchronized (this.playbackLock) {
            return playing;
        }
    }

    /**
     * Update the state of the play/pause button.  Doesn't notify the cell of
     * this change; this should be called in response to changes on the cell.
     * @param playing Whether we're playing (true) or paused (false)
     */
    private void setPlaying(boolean playing) {
        synchronized (this.playbackLock) {
            if (playing != this.playing) {
                this.playing = playing;
            }
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                if (isPlaying()) {
                    playPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(PAUSEBUTTON_PATH)));
                } else {
                    playPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(PLAYBUTTON_PATH)));
                }
            }
        });
    }

    /**
     * Update the selected state of the ground plane checkbox if appropriate.
     * Doesn't notify the cell of this change; should be called in response to
     * changes on the cell.
     * @param e {@inheritDoc}
     */
    public void visibilityChanged(VisibilityChangeEvent e) {
        if (e.getVisualType().equals(VisualType.GROUND)) {
            final boolean selected = e.isShowing();
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    groundVisibleBox.setSelected(selected);
                }
            });
        }
    }

    /**
     * Converts a slider position to a playback speed by scaling linearly
     * in two separate ranges (to enable finer control of slow-motion playback,
     * but coarser control of speeding up).
     * @param sliderPos The integral slider position
     * @return The floating point playback speed corresponding to the slider position
     */
    protected float sliderPosToPlaybackSpeed(int sliderPos) {
        float toReturn = 0.0f;

        // From SLIDER_DEFAULT to SLIDER_MAX, scale linearly from default speed to PLAYBACK_MAX
        if (sliderPos >= SLIDER_DEFAULT) {
            toReturn = linearScale((float) sliderPos, (float) SLIDER_DEFAULT,
                    (float) SLIDER_MAX, PlaybackDefaults.DEFAULT_START_SPEED, PLAYBACK_MAX);
        } // From SLIDER_MIN to SLIDER_DEFAULT, scale linearly from PLAYBACK_MIN to default speed
        else {
            toReturn = linearScale((float) sliderPos, (float) SLIDER_MIN,
                    (float) SLIDER_DEFAULT, PLAYBACK_MIN, PlaybackDefaults.DEFAULT_START_SPEED);
        }

        // Round to nearest hundredth
        int scaledReturn = (int) (toReturn * 100.0f);
        toReturn = (float) scaledReturn / 100.0f;

        return toReturn;
    }

    /**
     * Translate floating point playback speed to a slider value; inverts
     * the sliderPosToPlaybackSpeed translation.
     * @param playbackSpeed The actual playback speed
     * @return Slider position corresponding to the playback speed
     */
    protected int playbackSpeedToSliderPos(float playbackSpeed) {
        int toReturn = 0;

        // From default speed to PLAYBACK_MAX, scale linearly from SLIDER_DEFAULT to SLIDER_MAX
        if (playbackSpeed >= PlaybackDefaults.DEFAULT_START_SPEED) {
            toReturn = (int) linearScale(playbackSpeed, PlaybackDefaults.DEFAULT_START_SPEED,
                    PLAYBACK_MAX, (float) SLIDER_DEFAULT, (float) SLIDER_MAX);
        } else {
            toReturn = (int) linearScale(playbackSpeed, PLAYBACK_MIN,
                    PlaybackDefaults.DEFAULT_START_SPEED, (float) SLIDER_MIN, (float) SLIDER_DEFAULT);
        }

        return toReturn;
    }
}
