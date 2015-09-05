package com.example.ewelina.sudoku;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by ewelina on 03.09.15.
 */
public class Preferencje extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.ustawienia);
    }
}
