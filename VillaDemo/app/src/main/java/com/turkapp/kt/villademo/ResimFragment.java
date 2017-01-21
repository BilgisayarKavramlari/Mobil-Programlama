package com.turkapp.kt.villademo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ResimFragment extends Fragment {

    private int resimId;
    private View rootView;
    private ImageView iv_oda;
    private PhotoViewAttacher photoViewAttacher;

    private void init(){

        iv_oda = (ImageView) rootView.findViewById(R.id.imageView_oda);

    }

    public ResimFragment() {
    }

    public void setResimId(int resimId) {
        this.resimId = resimId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_resim, container, false);

        init();

        iv_oda.setImageDrawable(getResources().getDrawable(resimId));

        photoViewAttacher = new PhotoViewAttacher(iv_oda);

        photoViewAttacher.update();

        return rootView;
    }

}
