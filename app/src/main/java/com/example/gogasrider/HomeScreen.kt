package com.example.gogasrider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home_alpha_screen.*
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        listeners()
    }

    fun listeners() {
        uploadTankIv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeScreen,
                    HomeAlphaScreen::class.java
                )
            )
        })
    }
}