package com.example.kutai.kotlin_game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class Main_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_basla.setOnClickListener {
            val intent= Intent(this,oyunActivity::class.java)
            intent.putExtra("mesaj",edt_isim.text.toString())
            startActivity(intent)
        }

    }
}
