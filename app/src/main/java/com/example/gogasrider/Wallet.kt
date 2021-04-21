package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_update_profile_screen.*
import kotlinx.android.synthetic.main.activity_wallet.*

class Wallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        listeners()
    }

    fun listeners() {
        add_card_wd.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@Wallet,
                    ViewEarningScreen::class.java
                )
            )
        })
    }

}