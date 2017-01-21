package com.turkapp.kt.villademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Market extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        RelativeLayout rl_icecekler = (RelativeLayout) findViewById(R.id.rl_icecekler);
        rl_icecekler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Market.this,ProductList.class));

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.progressDialog.dismiss();
    }
}
