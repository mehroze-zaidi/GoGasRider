package com.example.gogasrider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home_slider.*
import kotlinx.android.synthetic.main.activity_upload_images.*
import kotlinx.android.synthetic.main.activity_upload_images.uploadDetailsBtn

class HomeSlider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_slider)
        listeners()
    }

    fun listeners() {
        logoutBtn.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeSlider,
                    EmptyState::class.java
                )
            )
        })
    }
}