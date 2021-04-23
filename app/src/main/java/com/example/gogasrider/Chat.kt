package com.example.gogasrider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_home_slider.*
import kotlinx.android.synthetic.main.activity_login_screen.*

class Chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        listeners()
    }

    fun listeners() {
        backArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })

        mic_c.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@Chat,
                    TrackScreen::class.java
                )
            )
        })
    }
}