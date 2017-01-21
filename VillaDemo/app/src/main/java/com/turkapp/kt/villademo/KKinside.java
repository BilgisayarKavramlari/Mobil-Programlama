package com.turkapp.kt.villademo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class KKinside extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kkinside);

        ImageView imageView = (ImageView) findViewById(R.id.imageView_kkinside);
        PhotoViewAttacher attacher = new PhotoViewAttacher(imageView);

        switch (KullaniciKilavuzlari.manualSelect){

            case 0:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.kumandamanual));
                break;
            case 1:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.firinmanual));
                break;
            case 2:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.washermanual));
                break;

        }

        attacher.update();
    }
}
