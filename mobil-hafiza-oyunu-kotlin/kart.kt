package com.example.kutai.kotlin_game

import android.content.Context
import android.support.v7.widget.AppCompatDrawableManager
import android.widget.Button



/**
 * Created by kutai on 21.10.2017.
 */
open class kart : Button {
    var acikMi: Boolean = false
    var onPlanId = 0
    val arkaPlanId = R.drawable.arka
    var cevrilebilir: Boolean=true
    constructor(ctx: Context, id: Int) : super(ctx) {
        setId(id)


        if (id % 8 == 1) {
            onPlanId = R.drawable.resim1
        }
        if (id % 8 == 2) {
            onPlanId = R.drawable.resim2
        }
        if (id % 8 == 3) {
            onPlanId = R.drawable.resim3
        }
        if (id % 8 == 4) {
            onPlanId = R.drawable.resim4
        }
        if (id % 8 == 5) {
            onPlanId = R.drawable.resim5
        }
        if (id % 8 == 6) {
            onPlanId = R.drawable.resim6
        }
        if (id % 8 == 7) {
            onPlanId = R.drawable.resim7
        }
        if (id % 8 == 0) {
            onPlanId = R.drawable.resim8
        }

        setBackgroundResource(arkaPlanId)
    }

    open fun cevir() {
        if(cevrilebilir){


            if (!acikMi) { //kapalıysa
                acikMi = true
                return setBackgroundResource(onPlanId)

            }
            else { //açıksa
                acikMi = false
                return setBackgroundResource(arkaPlanId)

            }
        }
    }
}

