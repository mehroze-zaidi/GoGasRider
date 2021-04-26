package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_request_screen.*
import kotlinx.android.synthetic.main.activity_track_screen.*

class RequestScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_screen)
        listeners()
    }

    fun listeners() {
        acceptBtn.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@RequestScreen,
                    ConfirmRideScreen::class.java
                )
            )
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        })
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    }
}