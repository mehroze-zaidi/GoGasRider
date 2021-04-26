package com.example.gogasrider

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_sign_up_screen.*
import kotlinx.android.synthetic.main.activity_waiting_screen.*

class WaitingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiting_screen)
        listeners()
    }

    fun listeners() {
        homeBtn.setOnClickListener {
            val animOn = android.util.Pair.create<View, String>(waitingTv, "setUpYourProfileTv")
            val animOn1 = android.util.Pair.create<View, String>(homeBtn, "signUpTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn, animOn1)

            startActivity(
                Intent(this@WaitingScreen, HomeScreen::class.java),
                activityOptionsCompat.toBundle()
            )

        }

        waitingBackArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })
    }
}