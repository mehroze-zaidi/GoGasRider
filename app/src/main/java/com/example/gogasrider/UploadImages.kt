package com.example.gogasrider

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_upload_images.*
import kotlinx.android.synthetic.main.activity_upload_images.chatBackArrowIv

class UploadImages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_images)
        listeners()
    }

    fun listeners() {
        uploadDetailsBtn.setOnClickListener(View.OnClickListener {
          //  val animOn = android.util.Pair.create<View, String>(uploadImageTv, "uploadIv")
            val animOn1 =
                android.util.Pair.create<View, String>(uploadDetailsBtn, "setUpYourProfileTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn1)
            startActivity(
                Intent(
                    this@UploadImages,
                    HomeScreen::class.java
                ),activityOptionsCompat.toBundle()
            )
        })

        chatBackArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })


    }
}