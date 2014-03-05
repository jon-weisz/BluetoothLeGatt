package com.example.android.bluetoothlegatt;

import android.app.Activity;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.AndARActivity;
import edu.dhbw.andar.exceptions.AndARException;

public class ARScanningActivity extends AndARActivity {
    ARToolkit artoolkit;
    List<LocalizationMarker> localizationMarkers;
    private final static List<String> MARKERLIST =
            Collections.unmodifiableList(Arrays.asList("android.patt, patt.hiro, barcode.patt"));

    public void addLocalizationMarker(String markerName){
        LocalizationMarker newMarker;
        newMarker = new LocalizationMarker(markerName, markerName, 10.f, new double[]{0,0});
        localizationMarkers.add(newMarker);
        try{
            artoolkit.registerARObject(newMarker);
        }
        catch(AndARException ex)
            {
               Log.e("LocalizationMarker:Failed to load localization marker - name:" +markerName,
                       ex.getMessage());
            }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_arscanning);
        artoolkit = super.getArtoolkit();

        for( String lmName : MARKERLIST)
        {
            addLocalizationMarker(lmName);
        }

        startPreview();

    }


    @Override
     public void uncaughtException(Thread thread, Throwable ex)
    {
        Log.e("AndAR Exception", ex.getMessage());
        finish();
    }

}
