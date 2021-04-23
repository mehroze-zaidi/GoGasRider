package com.example.gogasrider

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*

class PrivacyPolicyScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy_screen)
        listeners()
    }

    fun listeners() {
        backArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })

    }
}