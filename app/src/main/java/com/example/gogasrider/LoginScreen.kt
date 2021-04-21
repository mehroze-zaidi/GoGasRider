package com.example.gogasrider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        listeners()
    }

    fun listeners() {
        continueBtn.setOnClickListener(View.OnClickListener
        {
            startActivity(Intent(this@LoginScreen, OTPScreen::class.java))

        })

        signUptTv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@LoginScreen, SignUpScreen::class.java))
        })
    }


}