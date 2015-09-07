package com.example.ewelina.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.MenuInflater;
import android.util.Log;




public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View przyciskKontynuacja = findViewById(R.id.main_kontynuacja);
        przyciskKontynuacja.setOnClickListener(this);
        View przyciskNowa = findViewById(R.id.main_nowa_gra);
        przyciskNowa.setOnClickListener(this);
        View przyciskInformacje = findViewById(R.id.main_informacje);
        przyciskInformacje.setOnClickListener(this);
        View przyciskWyjscie = findViewById(R.id.main_wyjscie);
        przyciskWyjscie.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater wypelniacz = getMenuInflater();
        wypelniacz.inflate(R.menu.menu_main, menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.ustawienia:
                startActivity(new Intent(this, Preferencje.class));
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_informacje:
                Intent i = new Intent(this, Informacje.class);
                startActivity(i);
                break;
            case R.id.main_kontynuacja:
                uruchomGre(NowaGra.trudnosc_kontynuacji);
                break;
            case R.id.main_nowa_gra:
                otworzDialogGra();
                break;
            case R.id.main_wyjscie:
                finish();
                break;
        }
    }

    private static final String ZNACZNIK = "Sudoku";

    private void otworzDialogGra() {
        new AlertDialog.Builder(this).setTitle(R.string.tytul_nowa_gra)
                .setItems(R.array.trudnosc, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int i){
                        uruchomGre(i);
                    }
                }).show();
    }

    private void uruchomGre(int i) {
        Log.d(ZNACZNIK, "kliknieto " + i);
        Intent intencja = new Intent(MainActivity.this, NowaGra.class);
        intencja.putExtra(NowaGra.TRUDNOSC_KLUCZ, i);
        startActivity(intencja);
    }

//    @Override
//    protected void onResume(){
//        super.onResume();
//        Muzyka.play(this, R.raw.main);
//    }
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        Muzyka.stop(this);
//    }
}
