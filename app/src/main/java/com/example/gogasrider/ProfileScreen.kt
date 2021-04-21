package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile_screen.*
import kotlinx.android.synthetic.main.activity_request_screen.*

class ProfileScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)
        listeners()
    }

    fun listeners() {
        circleIv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@ProfileScreen,
                    UpdateProfileScreen::class.java
                )
            )
        })
    }

}