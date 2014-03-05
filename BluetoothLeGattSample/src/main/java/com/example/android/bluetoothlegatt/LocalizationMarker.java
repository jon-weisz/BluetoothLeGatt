package com.example.android.bluetoothlegatt;

import edu.dhbw.andar.ARObject;
import edu.dhbw.andar.util.GraphicsUtil;
import org.lwjgl.util.glu.Cylinder;

import javax.microedition.khronos.opengles.GL10;

import static org.lwjgl.util.glu.GLU.*;


/**
 * Created by jweisz on 2/28/14.
 */
public class LocalizationMarker extends ARObject{
    private Cylinder axisMarkerDrawer;
    private float axisLength;
    private float axisRadius;

public LocalizationMarker(String name, String patternName,
                        double markerWidth, double[] markerCenter) {
    super(name, patternName, markerWidth, markerCenter);
        axisMarkerDrawer = new Cylinder();
        axisLength = 10.f;
        axisRadius = 10.f;

    }

    public void draw(GL10 gl)
    {

        axisMarkerDrawer.setDrawStyle(GLU_LINE);

        axisMarkerDrawer.draw(axisRadius, axisRadius, axisLength, 10,10);
    }
       @Override
        public void init(GL10 gl) {
        }

 }
