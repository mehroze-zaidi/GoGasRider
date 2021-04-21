package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_end_ride_screen.*
import kotlinx.android.synthetic.main.activity_request_screen.*

class RideEndScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_ride_screen)
        listeners()
    }

    fun listeners() {
        dollarTv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@RideEndScreen,
                    ProfileScreen::class.java
                )
            )
        })
    }

}