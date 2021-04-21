package com.example.gogasrider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home_alpha_screen.*
import kotlinx.android.synthetic.main.activity_home_alpha_screen.uploadTankAlphaIv
import kotlinx.android.synthetic.main.activity_upload_images.*

class UploadImages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_images)
        listeners()
    }

    fun listeners() {
        uploadDetailsBtn.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@UploadImages,
                    HomeSlider::class.java
                )
            )
        })
    }
}