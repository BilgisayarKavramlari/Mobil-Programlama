package com.example.kutai.kotlin_game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sonuc.*

class sonucActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)
        val isim = intent.getStringExtra("mesaj")
        val sonuc = intent.getIntExtra("Puan",0)
        tv_sonuc.setText("Tebrikler $isim, bu oyunu $sonuc hata ile de olsa kazandın!")
        btn_tekrar.setOnClickListener {
            val tekrar = Intent(this, Main_Activity::class.java)
            startActivity(tekrar)
        }
    }
}
