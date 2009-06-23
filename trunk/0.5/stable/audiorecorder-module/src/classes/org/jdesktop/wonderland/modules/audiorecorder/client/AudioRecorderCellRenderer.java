/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2008, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * $Revision$
 * $Date$
 * $State$
 */

package org.jdesktop.wonderland.modules.audiorecorder.client;

import com.jme.bounding.BoundingBox;
import com.jme.bounding.BoundingSphere;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.scene.Node;
import com.jme.scene.Spatial;
import com.jme.scene.shape.Box;
import com.jme.scene.shape.Cylinder;
import com.jme.scene.state.BlendState;
import com.jme.scene.state.CullState;
import com.jme.scene.state.MaterialState;
import com.jme.scene.state.RenderState;
import com.jme.scene.state.RenderState.StateType;
import com.sun.scenario.animation.Animation;
import com.sun.scenario.animation.Clip;
import com.sun.scenario.animation.Clip.RepeatBehavior;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import org.jdesktop.mtgame.CollisionComponent;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.mtgame.Entity;
import org.jdesktop.mtgame.JMECollisionSystem;
import org.jdesktop.mtgame.RenderComponent;
import org.jdesktop.wonderland.client.input.Event;
import org.jdesktop.wonderland.client.input.EventClassListener;
import org.jdesktop.wonderland.client.jme.ClientContextJME;
import org.jdesktop.wonderland.client.jme.cellrenderer.BasicRenderer;
import org.jdesktop.wonderland.client.jme.input.MouseButtonEvent3D;

import javax.media.opengl.GLContext;

import java.lang.reflect.Method;
import org.jdesktop.wonderland.client.jme.input.MouseEvent3D.ButtonId;

/**
 *
 * @author bh37721
 */
public class AudioRecorderCellRenderer extends BasicRenderer {

    private static final Logger rendererLogger = Logger.getLogger(AudioRecorderCellRenderer.class.getName());

    private static final float WIDTH = 0.6f; //x-extent
    private static final float HEIGHT = WIDTH /2 ; //y-extent was 0.3f
    private static final float DEPTH = 0.05f; //z-extent
    private static final float REEL_RADIUS = HEIGHT * 0.9f;  //was 0.16f
    private static final float BUTTON_WIDTH = WIDTH / 3; //x
    private static final float BUTTON_HEIGHT = 0.05f; //y
    private static final float BUTTON_DEPTH = DEPTH; //y
    private static final ColorRGBA RECORD_BUTTON_DEFAULT = new ColorRGBA(0.5f, 0, 0, 1f);
    private static final ColorRGBA RECORD_BUTTON_SELECTED = ColorRGBA.red.clone();
    private static final ColorRGBA STOP_BUTTON_DEFAULT = new ColorRGBA(0.2f, 0.2f, 0.2f, 1f);
    private static final ColorRGBA STOP_BUTTON_SELECTED = ColorRGBA.black.clone();
    private static final ColorRGBA PLAY_BUTTON_DEFAULT = new ColorRGBA(0, 0.5f, 0.2f, 1f);
    private static final ColorRGBA PLAY_BUTTON_SELECTED = ColorRGBA.green.clone();
    private Node root = null;
    private Button recordButton;
    private Button stopButton;
    private Button playButton;
    private Set<Animation> animations = new HashSet<Animation>();

    public AudioRecorderCellRenderer(Cell cell) {
        super(cell);
    }

    protected Node createSceneGraph(Entity entity) {
        /* Create the scene graph object*/
        root = new Node();
        attachRecordingDevice(root, entity);
        root.setModelBound(new BoundingBox());
        root.updateModelBound();
        //Set the name of the buttonRoot node
        root.setName("Cell_" + cell.getCellID() + ":" + cell.getName());

        //Set the state of the buttons
        boolean isRecording = ((AudioRecorderCell)cell).isRecording();
        boolean isPlaying = ((AudioRecorderCell)cell).isPlaying();
        setRecording(isRecording);
        setPlaying(isPlaying);
        stopButton.setSelected(!(isPlaying || isRecording));
        enableAnimations(isPlaying || isRecording);
        return root;
    }

    private void attachRecordingDevice(Node device, Entity entity) {
        addOuterCasing(device);
        entity.addEntity(createReel(device, new Vector3f(0-REEL_RADIUS, 0, 0.0f)));
        entity.addEntity(createReel(device, new Vector3f(WIDTH - REEL_RADIUS, 0, 0.0f)));
        entity.addEntity(createRecordButton(device, new Vector3f(-(WIDTH - (BUTTON_WIDTH)), HEIGHT + BUTTON_HEIGHT, 0f)));
        entity.addEntity(createStopButton(device, new Vector3f(0, HEIGHT + BUTTON_HEIGHT, 0f)));
        entity.addEntity(createPlayButton(device, new Vector3f(WIDTH - BUTTON_WIDTH, HEIGHT + BUTTON_HEIGHT, 0f)));
    }

    private void addOuterCasing(Node device) {
        Box casing = new Box("Audio Recorder Casing", new Vector3f(0, 0, 0), WIDTH, HEIGHT, DEPTH); //x, y, z
        casing.setModelBound(new BoundingBox());
        casing.updateModelBound();
        ColorRGBA casingColour = new ColorRGBA(0f, 0f, 1f, 0.2f);
        MaterialState matState = (MaterialState) ClientContextJME.getWorldManager().getRenderManager().createRendererState(StateType.Material);
        matState.setDiffuse(casingColour);
        casing.setRenderState(matState);
        //casing.setLightCombineMode(Spatial.LightCombineMode.Off);
        BlendState as = (BlendState) ClientContextJME.getWorldManager().getRenderManager().createRendererState(StateType.Blend);
        as.setEnabled(true);
        as.setBlendEnabled(true);
        as.setSourceFunction(BlendState.SourceFunction.SourceAlpha);
        as.setDestinationFunction(BlendState.DestinationFunction.OneMinusSourceAlpha);
        casing.setRenderState(as);

        CullState cs = (CullState) ClientContextJME.getWorldManager().getRenderManager().createRendererState(StateType.Cull);
        cs.setEnabled(true);
        cs.setCullFace(CullState.Face.Back);
        casing.setRenderState(cs);
        device.attachChild(casing);
        
    }

    private Entity createReel(Node device, Vector3f position) {
        Node reelRoot = new Node();
        Entity reelEntity = new Entity("Reel");
        Cylinder outerReel = new Cylinder("Outer Reel", 10, 100, REEL_RADIUS, DEPTH * 2f, true);
        Cylinder innerReel = new Cylinder("Inner Reel", 10, 5, REEL_RADIUS/3, DEPTH * 2.10f, true);
        reelRoot.attachChild(outerReel);
        reelRoot.attachChild(innerReel);
        ColorRGBA outerReelColour = ColorRGBA.brown.clone();
        outerReel.setSolidColor(outerReelColour);
        ColorRGBA innerReelColour = ColorRGBA.white.clone();
        innerReel.setSolidColor(innerReelColour);
        reelRoot.setLightCombineMode(Spatial.LightCombineMode.Off);
        reelRoot.setModelBound(new BoundingBox());
        // Calculate the best bounds for the object you gave it
        reelRoot.updateModelBound();
        // Move the box to its position
        reelRoot.setLocalTranslation(position);

        device.attachChild(reelRoot);
        
        RenderComponent rc = ClientContextJME.getWorldManager().getRenderManager().createRenderComponent(reelRoot);
        reelEntity.addComponent(RenderComponent.class, rc);

        RotationAnimationProcessor spinner = new RotationAnimationProcessor(reelEntity, reelRoot, 0f, 360, new Vector3f(0f,0f,1f));
        Clip clip = Clip.create(1000, Clip.INDEFINITE, spinner);
        clip.setRepeatBehavior(RepeatBehavior.LOOP);
        clip.start();
        animations.add(clip);

        return reelEntity;
    }

    private Entity createRecordButton(Node device, Vector3f position) {
        recordButton = addButton(device, "Record", position);
        recordButton.setColor(RECORD_BUTTON_DEFAULT);
        recordButton.setSelectedColor(RECORD_BUTTON_SELECTED);
        recordButton.setDefaultColor(RECORD_BUTTON_DEFAULT);
        return recordButton.getEntity();
    }

    private Entity createStopButton(Node device, Vector3f position) {
        stopButton = addButton(device, "Stop", position);
        stopButton.setColor(STOP_BUTTON_DEFAULT);
        stopButton.setSelectedColor(STOP_BUTTON_SELECTED);
        stopButton.setDefaultColor(STOP_BUTTON_DEFAULT);
        return stopButton.getEntity();
    }

    private Entity createPlayButton(Node device, Vector3f position) {
        playButton = addButton(device, "Play", position);
        playButton.setColor(PLAY_BUTTON_DEFAULT);
        playButton.setSelectedColor(PLAY_BUTTON_SELECTED);
        playButton.setDefaultColor(PLAY_BUTTON_DEFAULT);
        return playButton.getEntity();
    }

    private Button addButton(Node device, String name, final Vector3f position) {
        Button aButton = new Button(name, new Vector3f(0, 0, 0), BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_DEPTH);
        
        // Move the button
        aButton.getRoot().setLocalTranslation(position);

        device.attachChild(aButton.getRoot());
        
        return aButton;
    }

    void setRecording(boolean b) {
        recordButton.setSelected(b);
        stopButton.setSelected(!b);
        enableAnimations(b);
    }

    void setPlaying(boolean b) {
        playButton.setSelected(b);
        stopButton.setSelected(!b);
        enableAnimations(b);
    }

    private void enableAnimations(boolean b) {
        for (Animation anim : animations) {
            if (b) {
                anim.resume();
            } else {
                anim.pause();
            }
        }
    }

    // Make this buttonEntity pickable by adding a collision component to it
        protected void makeEntityPickable(Entity entity, Node node) {
            JMECollisionSystem collisionSystem = (JMECollisionSystem) ClientContextJME.getWorldManager().getCollisionManager().
                    loadCollisionSystem(JMECollisionSystem.class);

            CollisionComponent cc = collisionSystem.createCollisionComponent(node);
            entity.addComponent(CollisionComponent.class, cc);
        }

    class Button {

        private boolean isSelected;
        private Box box;
        private Node buttonRoot;
        private Entity buttonEntity;
        private ColorRGBA selectedColor;
        private ColorRGBA defaultColor;

        private Button(String name, Vector3f vector3f, float f, float BUTTON_WIDTH, float BUTTON_HEIGHT) {
            box = new Box(name, vector3f, f, BUTTON_WIDTH, BUTTON_HEIGHT);
            box.setLightCombineMode(Spatial.LightCombineMode.Off);
            box.setModelBound(new BoundingSphere());
            // Calculate the best bounds for the object you gave it
            box.updateModelBound();
            buttonRoot = new Node();
            buttonRoot.attachChild(box);
            buttonEntity = new Entity(name);
            RenderComponent rc = ClientContextJME.getWorldManager().getRenderManager().createRenderComponent(buttonRoot);
            buttonEntity.addComponent(RenderComponent.class, rc);

            //Listen to mouse events
            ButtonListener listener = new ButtonListener(this);
            listener.addToEntity(buttonEntity);

            // Make the secondary object pickable separately from the primary object
            makeEntityPickable(buttonEntity, buttonRoot);
        }

        Node getRoot() {
            return buttonRoot;
        }

        Entity getEntity() {
            return buttonEntity;
        }

        boolean isSelected() {
            return isSelected;
        }

        void setSelected(boolean selected) {
            //rendererLogger.info("setSelected: " + selected);
            this.isSelected = selected;
            updateColor();
        }

        

        void setSelectedColor(ColorRGBA selectedColor) {
            this.selectedColor = selectedColor;
        }
        
        void setDefaultColor(ColorRGBA defaultColor) {
            this.defaultColor = defaultColor;
        }

        void setColor(ColorRGBA color) {
            box.setSolidColor(color);
        }

        public void updateColor() {
            if (isSelected) {
                setColor(selectedColor);
            } else {
                setColor(defaultColor);
            }
            ClientContextJME.getWorldManager().addToUpdateList(box);
        }

        private void printComponents() {
            //System.out.println(buttonEntity);
            //Iterator entityComponents = buttonEntity.getComponents().iterator();
            //while (entityComponents.hasNext()) {
            //    System.out.println(entityComponents.next());
            //}
        }
    }

    class ButtonListener extends EventClassListener {
        private Button button; 

        ButtonListener(Button aButton) {
            super();
            setSwingSafe(true);
            button = aButton;
        }

        @Override
        public Class[] eventClassesToConsume() {
            return new Class[]{MouseButtonEvent3D.class};
        }

        // Note: we don't override computeEvent because we don't do any computation in this listener.
        @Override
        public void commitEvent(Event event) {
            //rendererLogger.info("commit " + event + " for ");
            //button.printComponents();
            MouseButtonEvent3D mbe = (MouseButtonEvent3D) event;
            if (mbe.isClicked() == false) {
                return;
            }
            //Ignore if it's not the left mouse button
            if (mbe.getButton() != ButtonId.BUTTON1) {
                return;
            }

            if (button == stopButton) {
                /*
                 * We always handle the stop button.
                 */
                ((AudioRecorderCell) cell).stop();
                return;
            }
            //
            //Only care about the case when the button isn't already selected'
            if (!button.isSelected()) {
                if (button == recordButton) {
                    ((AudioRecorderCell) cell).startRecording();
                } else if (button == playButton) {
                    ((AudioRecorderCell) cell).startPlaying();
                }
                return;
            }
        }
    }
}
