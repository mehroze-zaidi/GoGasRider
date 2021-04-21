package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up_screen.*


class SignUpScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_screen)
        listeners()
    }

    fun listeners() {
        termAndConditionTv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@SignUpScreen, TermAndConditionScreen::class.java))

        })

        privacyPolicyTv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@SignUpScreen, PrivacyPolicyScreen::class.java))


        })

        signUpBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@SignUpScreen, WaitingScreen::class.java))


        })
    }


}
