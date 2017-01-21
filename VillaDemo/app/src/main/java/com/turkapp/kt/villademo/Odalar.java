package com.turkapp.kt.villademo;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Odalar extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPagerFixed mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odalar);

        getSupportActionBar().hide();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPagerFixed) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                setIvAlpha(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_odalar, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setIvAlpha(int pos){


        ImageView mutfak = (ImageView) findViewById(R.id.odalar_Mutfak);
        ImageView salon = (ImageView) findViewById(R.id.odalar_Salon);
        ImageView yatakodasi = (ImageView) findViewById(R.id.odalar_YatakOdasi);
        ImageView bahce = (ImageView) findViewById(R.id.odalar_Bahce);
        ImageView banyo = (ImageView) findViewById(R.id.odalar_Banyo);

        switch (pos){

            case 0:
                mutfak.setAlpha(1f);
                salon.setAlpha(0.4f);
                yatakodasi.setAlpha(0.4f);
                bahce.setAlpha(0.4f);
                banyo.setAlpha(0.4f);
                break;
            case 1:
                mutfak.setAlpha(0.4f);
                salon.setAlpha(1f);
                yatakodasi.setAlpha(0.4f);
                bahce.setAlpha(0.4f);
                banyo.setAlpha(0.4f);
                break;
            case 2:
                mutfak.setAlpha(0.4f);
                salon.setAlpha(0.4f);
                yatakodasi.setAlpha(1f);
                bahce.setAlpha(0.4f);
                banyo.setAlpha(0.4f);
                break;
            case 3:
                mutfak.setAlpha(0.4f);
                salon.setAlpha(0.4f);
                yatakodasi.setAlpha(0.4f);
                bahce.setAlpha(1f);
                banyo.setAlpha(0.4f);
                break;
            case 4:
                mutfak.setAlpha(0.4f);
                salon.setAlpha(0.4f);
                yatakodasi.setAlpha(0.4f);
                bahce.setAlpha(0.4f);
                banyo.setAlpha(1f);
                break;

        }

    }

    public void odalarClick(View view) {

        int id = view.getId();

        switch (id){

            case R.id.odalar_Mutfak:
                mViewPager.setCurrentItem(0);
                setIvAlpha(0);
                break;
            case R.id.odalar_Salon:
                mViewPager.setCurrentItem(1);
                setIvAlpha(1);
                break;
            case R.id.odalar_YatakOdasi:
                mViewPager.setCurrentItem(2);
                setIvAlpha(2);
                break;
            case R.id.odalar_Bahce:
                mViewPager.setCurrentItem(3);
                setIvAlpha(3);
                break;
            case R.id.odalar_Banyo:
                mViewPager.setCurrentItem(4);
                setIvAlpha(4);
                break;

        }

    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_odalar, container, false);
            return rootView;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        startActivity(new Intent(Odalar.this,Odalar.class));
        finish();

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ResimFragment fragment = null;

            switch (position){

                case 0:

                    fragment = new ResimFragment();
                    fragment.setResimId(R.drawable.mutfak);

                    break;
                case 1:

                    fragment = new ResimFragment();
                    fragment.setResimId(R.drawable.salon);

                    break;
                case 2:

                    fragment = new ResimFragment();
                    fragment.setResimId(R.drawable.bedroom);

                    break;
                case 3:

                    fragment = new ResimFragment();
                    fragment.setResimId(R.drawable.bahce);

                    break;
                case 4:

                    fragment = new ResimFragment();
                    fragment.setResimId(R.drawable.banyo);

                    break;

            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MUTFAK";
                case 1:
                    return "SALON";
                case 2:
                    return "YATAK ODASI";
                case 3:
                    return "BAHÇE";
                case 4:
                    return "BANYO";
            }
            return null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.progressDialog.dismiss();
    }
}
