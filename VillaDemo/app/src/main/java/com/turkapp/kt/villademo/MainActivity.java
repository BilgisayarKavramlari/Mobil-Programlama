package com.turkapp.kt.villademo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RelativeLayout rl_odalar,rl_market,rl_kullanicikilavuzlari,rl_places;
    public static ProgressDialog progressDialog;


    private void init(){

        rl_odalar = (RelativeLayout) findViewById(R.id.rl_odalar);
        rl_market = (RelativeLayout) findViewById(R.id.rl_market);
        rl_kullanicikilavuzlari = (RelativeLayout) findViewById(R.id.rl_kullanicikilavuzlari);
        rl_places = (RelativeLayout) findViewById(R.id.rl_places);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Yükleniyor...");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        rl_odalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();
                startActivity(new Intent(MainActivity.this,Odalar.class));

            }
        });

        rl_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();
                startActivity(new Intent(MainActivity.this,Market.class));

            }
        });

        rl_kullanicikilavuzlari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();
                startActivity(new Intent(MainActivity.this,KullaniciKilavuzlari.class));


            }
        });

        rl_places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();
                startActivity(new Intent(MainActivity.this,PlacesKategori.class));

            }
        });

    }
}
