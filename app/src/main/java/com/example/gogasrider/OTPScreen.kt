package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_login_screen.backArrowIv
import kotlinx.android.synthetic.main.activity_o_t_p_screen.*
import kotlinx.android.synthetic.main.activity_request_screen.*

class OTPScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o_t_p_screen)
        listeners()
    }

    fun listeners() {
        loginBtn.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@OTPScreen,
                    HomeScreen::class.java
                )
            )
        })

        backArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })
    }
}
