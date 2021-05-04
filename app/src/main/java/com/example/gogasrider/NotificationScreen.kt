package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_notification_screen.*
import kotlinx.android.synthetic.main.activity_notification_screen.chatBackArrowIv
import kotlinx.android.synthetic.main.activity_sign_up_screen.*

class NotificationScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_screen)
        listeners()

    }

    fun listeners() {
        chatBackArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })
        cashWalletIv.setOnClickListener {
            startActivity(
                Intent(this@NotificationScreen, RequestScreen::class.java)
            )
        }

    }
}