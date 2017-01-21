package com.turkapp.kt.villademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;


public class KullaniciKilavuzlari extends Activity {

    private CardView cv_Kumanda,cv_Firin,cv_Washer;
    public static int manualSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_kilavuzlari);

        cv_Kumanda = (CardView) findViewById(R.id.cardviewKumanda);
        cv_Firin = (CardView) findViewById(R.id.cardviewFirin);
        cv_Washer = (CardView) findViewById(R.id.cardviewWasher);

        cv_Kumanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                manualSelect = 0;
                startActivity(new Intent(KullaniciKilavuzlari.this,KKinside.class));

            }
        });

        cv_Firin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                manualSelect = 1;
                startActivity(new Intent(KullaniciKilavuzlari.this,KKinside.class));

            }
        });

        cv_Washer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                manualSelect = 2;
                startActivity(new Intent(KullaniciKilavuzlari.this,KKinside.class));

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.progressDialog.dismiss();
    }

}
