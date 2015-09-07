package com.example.ewelina.sudoku;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by ewelina on 06.09.15.
 */
public class Muzyka {
    private static MediaPlayer mp = null;

    public static void play(Context kontekst, int zasob){
        stop(kontekst);
        if (Preferencje.wezMuzyke(kontekst)) {
            mp = MediaPlayer.create(kontekst, zasob);
            mp.setLooping(true);
            mp.start();
        }
    }

    public static void stop(Context kontekst){
        if (mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
