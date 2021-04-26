package com.example.gogasrider

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_sign_up_screen.*
import kotlinx.android.synthetic.main.activity_sign_up_screen.chatBackArrowIv


class SignUpScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_screen)
        listeners()
    }

    fun listeners() {
        termAndConditionTv.setOnClickListener(View.OnClickListener {
            val animOn =
                android.util.Pair.create<View, String>(termAndConditionTv, "termAndCondition")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)

            startActivity(
                Intent(this@SignUpScreen, TermAndConditionScreen::class.java),
                activityOptionsCompat.toBundle()
            )

        })

        privacyPolicyTv.setOnClickListener {

            val animOn = android.util.Pair.create<View, String>(privacyPolicyTv, "privacyPolicy")
            val activityOptionsCompat = ActivityOptions.makeSceneTransitionAnimation(this, animOn)


            startActivity(
                Intent(this@SignUpScreen, PrivacyPolicyScreen::class.java),
                activityOptionsCompat.toBundle()
            )


        }

        signUpBtn.setOnClickListener(View.OnClickListener {
            val animOn = android.util.Pair.create<View, String>(signUpBtn, "signUpBtn")
            val animOn1 = android.util.Pair.create<View, String>(setUpYourProfileTv, "signUpTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn, animOn1)



            startActivity(
                Intent(this@SignUpScreen, WaitingScreen::class.java),
                activityOptionsCompat.toBundle()
            )


        })
        chatBackArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })

    }


}
