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
package org.jdesktop.wonderland.modules.marbleous.client;

import com.jme.math.Vector3f;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * A class that keeps a time-series of samples during a simulation. This class
 * stores a number of samples, with a certain number of samples per second.
 * <p>
 * @author jslott, kmontag, deronj
 */
public class SimTrace {

    private static Logger logger = Logger.getLogger(SimTrace.class.getName());

    // An array of samples
    private List<SampleInfo> sampleList = new ArrayList();

    // The acceleration due to gravity (g), a negative value in the +y axis
    private float g = 0.0f;

    // The number of samples per second.
    private int samplesPerSecond = 0;

    /**
     * Constructor, takes the acceleration due to gravity, always assumed to
     * be directed along the +y axis (so it's a negative value). Also takes
     * the number of samples per second.
     */
    public SimTrace(float g, int samplesPerSecond) {
        this.g = g;
        this.samplesPerSecond = samplesPerSecond;
    }

    /**
     * Appends a new sample to the end of the list of samples given the linear
     * velocity vector and position of the sample. Returns the new sample
     * created.
     * <p>
     * @param m The mass of the object
     * @param p The position of the object
     * @param v The linear velocity of the object
     * @return The new sample created
     */
    public synchronized SampleInfo appendSample(float m, Vector3f p, Vector3f v) {
        // In order to compute the acceleration, we first need the previous
        // acceleration. The first sample in the series has no acceleration
        Vector3f a = Vector3f.ZERO;
        if (sampleList.size() > 0) {
            SampleInfo lastSample = sampleList.get(sampleList.size() - 1);
            float deltaT = 1.0f / (float)samplesPerSecond;
            Vector3f deltaV = v.subtract(lastSample.getVelocity());
            a = deltaV.divide(deltaT);
        }

        // Create a new SampleInfo with the position, velocity, acceleration
        // and mass. The SampleInfo class will figure everything else out
        float time = sampleList.size() * (float)samplesPerSecond;
        SampleInfo sample = new SampleInfo(m, p, v, a, time, g);
        sampleList.add(sample);
        return sample;
    }
    
    /**
     * Returns the sample information for time t. If no sample exists for the
     * given time, then this method returns the linear interpolation of
     * existing samples. If the given time is negative or if the time is
     * greater than the number of samples that exist, return null.
     *
     * @param t The time t (in seconds)
     * @return The sample at time t
     */
    public synchronized SampleInfo getSampleInfo(float t) {
        // XXX TODO
        // For now, just take the closest sample, do not interpolate
        // XXX TODO

        // Convert the time into a sample number, round down
        int sample = (int)(t * (float)samplesPerSecond);
        if (sample < 0 || sample >= sampleList.size()) {
            logger.warning("Invalid time given, t=" + t + ", sample=" + sample);
            return null;
        }
        return sampleList.get(sample);
    }

    /**
     * Returns the time of the last sample in the trace.
     *
     * @return The number of seconds represented by the trace.
     */
    public synchronized float getEndTime() {
        // Adjust the number of samples we have for samples per second
        return (float)(sampleList.size()-1) / (float)getSamplesPerSecond();
    }

    /**
     * Returns G, the gravitational constant, a positive value assumed to be
     * in the -y direction.
     *
     * @return The acceleleration due to gravity
     */
    public float getGravity() {
        return g;
    }

    /**
     * Returns the integer number of samples per second.
     *
     * @return The samples per second
     */
    public int getSamplesPerSecond() {
        return samplesPerSecond;
    }
}

