package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_update_profile_screen.*

class UpdateTankScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_tank_screen)
        listeners()
    }

    fun listeners() {
        update_now_pi.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@UpdateTankScreen,
                    Wallet::class.java
                )
            )
        })
        backArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })

    }

}