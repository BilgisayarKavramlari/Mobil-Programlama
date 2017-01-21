package com.turkapp.kt.villademo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProductList extends Activity {

    int sepetSayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        LinearLayout container = (LinearLayout) findViewById(R.id.activity_product_list);

        String[] urunler = getResources().getStringArray(R.array.urunler);

        int[] imgres = {R.drawable.cocacola,R.drawable.fanta,R.drawable.sprite,R.drawable.icetea};

        for (int i = 0 ; i<urunler.length ; i++ ){

            View row = makeRow(urunler[i],imgres[i]);

            container.addView(row);

        }

    }

    private View makeRow(String urunAdi,int imgres){

        View view = getLayoutInflater().inflate(R.layout.urunlist,null);

        final RelativeLayout rl_sepet = (RelativeLayout) view.findViewById(R.id.rl_sepet);

        final Button btnSiparis = (Button) findViewById(R.id.buttonSiparis);

        ImageView simge = (ImageView) view.findViewById(R.id.simgeliste);
        //ImageView sepeteEkle = (ImageView) view.findViewById(R.id.imageView_sepeteekle);
        TextView urunadi = (TextView) view.findViewById(R.id.urunadi_liste);
        final TextView sepetAdet = (TextView) findViewById(R.id.tv_sepetAdet);

        NumberPicker np = (NumberPicker) view.findViewById(R.id.numberPicker);
        np.setMinValue(0);
        np.setMaxValue(20);
        np.setWrapSelectorWheel(true);

        simge.setImageResource(imgres);
        urunadi.setText(urunAdi);

        rl_sepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RelativeLayout rl = (RelativeLayout) v;
                ImageView iv = (ImageView) rl.getChildAt(1);

                if (!v.isSelected()){

                    v.setSelected(true);
                    iv.setImageResource(R.drawable.shoppingcart_green);

                    if (sepetAdet.getVisibility() == View.INVISIBLE){

                        sepetSayi++;
                        sepetAdet.setText(""+sepetSayi);
                        sepetAdet.setVisibility(View.VISIBLE);
                        btnSiparis.setVisibility(View.VISIBLE);

                    }else {

                        sepetSayi++;
                        sepetAdet.setText(""+sepetSayi);

                    }

                }else {

                    v.setSelected(false);
                    iv.setImageResource(R.drawable.shopping_cart);

                    if (sepetAdet.getVisibility() != View.INVISIBLE){

                        sepetSayi--;
                        sepetAdet.setText(""+sepetSayi);

                        if (sepetSayi < 1){

                            sepetAdet.setVisibility(View.INVISIBLE);
                            btnSiparis.setVisibility(View.INVISIBLE);

                        }

                    }

                }

            }
        });

        return view;
    }

}
