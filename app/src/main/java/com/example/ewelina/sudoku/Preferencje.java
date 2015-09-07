package com.example.ewelina.sudoku;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by ewelina on 03.09.15.
 */
public class Preferencje extends PreferenceActivity {
    private static final String opc_muzyka = "muzyka";
    private static final boolean opc_muzyka_domyslne = true;
    private static final String opc_podpowiedzi = "podpowiedzi";
    private static final boolean opc_podpowiedzi_domyslne = true;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.ustawienia);
    }

    public static boolean wezMuzyke(Context kontekst){
        return PreferenceManager.getDefaultSharedPreferences(kontekst).getBoolean(opc_muzyka, opc_muzyka_domyslne);
    }

    public static boolean wezPodpowiedz(Context kontekst){
        return PreferenceManager.getDefaultSharedPreferences(kontekst).getBoolean(opc_podpowiedzi, opc_podpowiedzi_domyslne);
    }
}
