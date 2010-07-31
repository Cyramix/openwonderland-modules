/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.scriptingComponent.client;

import com.jme.math.Vector3f;

/**
 *
 * @author morrisford
 */
public class ScriptingRunnable implements Runnable
    {
    public float x;
    public float y;
    public float z;
    public int a;
    public String avatar;
    public String[] nameArray;
    public String animation;
    public String string1;
    public String string2;
    public String string3;
    public String string4;
    public String string5;
    public Vector3f animationStartTranslate;
    public float[] animationStartRotation;
    public int animationTimeMultiplier;
    public int animationStartKeyframe = 0;
    public int animationEndKeyframe = 0;
    public int animationIceCode = 0;
    public boolean animationSaveTransform = false;
    public boolean animationPlayReverse = false;

    public void setNameArray(String[] NameArray)
        {
        nameArray = NameArray;
        }

    public String[] getNameArray()
        {
        return nameArray;
        }

    public void setAnimation(String Animation)
        {
        animation = Animation;
        }

    public void setAvatar(String Avatar)
        {
        avatar = Avatar;
        }
    
    public void setPoint(float X, float Y, float Z)
        {
        x = X;
        y = Y;
        z = Z;
        }

    public void set2Strings(String one, String two)
        {
        string1 = one;
        string2 = two;
        }

    public void set3Strings(String one, String two, String three)
        {
        string1 = one;
        string2 = two;
        string3 = three;
        }
    
    public void set4Strings(String one, String two, String three, String four)
        {
        string1 = one;
        string2 = two;
        string3 = three;
        string4 = four;
        }

    public void set5Strings(String one, String two, String three, String four, String five)
        {
        string1 = one;
        string2 = two;
        string3 = three;
        string4 = four;
        string5 = five;
        }

    public void setSingleInt(int A)
        {
        a = A;
        }

    public void setAnimationStartTranslate(Vector3f startTranslate)
        {
        animationStartTranslate = startTranslate;
        }

    public void setAnimationStartRotation(float[] startRotation)
        {
        animationStartRotation = startRotation;
        }

    public void setAnimationTimeMultiplier(int timeMultiplier)
        {
        animationTimeMultiplier = timeMultiplier;
        }
    public void setAnimationStartKeyframe(int start)
        {
        animationStartKeyframe = start;
        }

    public void setAnimationEndKeyframe(int end)
        {
        animationEndKeyframe = end;
        }

    public void setAnimationIceCode(int code)
        {
        animationIceCode = code;
        }

    public void setAnimationSaveTransform(boolean save)
        {
        animationSaveTransform = save;
        }

    public void setAnimationPlayReverse(boolean reverse)
        {
        animationPlayReverse = reverse;
        }

    public void run()
        {

        }

    }
