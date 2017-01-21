package com.turkapp.kt.villademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class PlacesKategori extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_kategori);

        RelativeLayout rl_tarihiyerler = (RelativeLayout) findViewById(R.id.rl_tarihiyerler);

        rl_tarihiyerler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(PlacesKategori.this,Places.class));

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.progressDialog.dismiss();
    }

}
