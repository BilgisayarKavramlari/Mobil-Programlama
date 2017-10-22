package com.example.kutai.kotlin_game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_oyun.*
import android.view.View
import org.jetbrains.anko.alert
import java.util.*

class oyunActivity : AppCompatActivity() {
        var sonKart=-1
        var skor=0
        var hata=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun)
        val isim = intent.getStringExtra("mesaj")
        txt2_isim.setText(isim)
        var cards = arrayOfNulls<kart>(16)
        for (a in 0..15){
            cards[a]= kart(this,a)

        }
        for (b in 0..15){
            var rand=(Math.random()*16).toInt() //yer değiştirme için random atıyoruz.
            //val mc=cards[rand]
            cards[rand]=cards[b].also { cards[b]=cards[rand] }
            //cards[b]=mc
            //rand=cards[b] .also { cards[b]=rand } //swapping işlemi için .also fonksiyonu kullanabiliriz.

        }
        for (t in 0..15){
            cards[t]!!.setOnClickListener{
                cards[t]!!.cevir()
                if (sonKart!=-1){
                    var k2=findViewById(sonKart) as kart
                    if(k2.onPlanId==cards[t]!!.onPlanId && k2.id!=cards[t]!!.id){
                        //ESLEŞTİLER
                        k2.cevrilebilir=false
                        cards[t]!!.cevrilebilir=false
                        skor++
                        tv_skor.setText("Skorunuz: $skor")
                        sonKart=-1 //eğer bunu koymazsak, doğru sonuçtan sonraki ilk adım hata gözüküyor.
                        if(skor == 8){
                            //oyun bitti
                            val intentSonuc=Intent(this,sonucActivity::class.java)
                            intentSonuc.putExtra("Puan",hata)
                            intentSonuc.putExtra("mesaj",isim)
                            startActivity(intentSonuc)
                        }
                    }
                    else{
                        // eşleşmediler kapat 2 kartı da
                        Handler().postDelayed({
                            cards[t]!!.cevir()
                            k2.cevir()
                        },500)


                        hata++

                        tv_hata.setText("Hata : $hata")


                        sonKart=-1
                    }
                }
                else sonKart = cards[t]!!.id
            }
        }

        for (c in 0..15) {
            val myCard=cards[c]
            gl_btn.addView(myCard)// butona resimi eklerken id'de ekliyoruz. 1'den 16'ya kadar.
        }
    }
}
