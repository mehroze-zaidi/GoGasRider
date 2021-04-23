package com.example.gogasrider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_waiting_screen.*

class WaitingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiting_screen)
        listeners()
    }

    fun listeners() {
        homeBtn.setOnClickListener(
            View.OnClickListener
            {
                startActivity(Intent(this@WaitingScreen, HomeScreen::class.java))

            })
        waitingBackArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })
    }
}