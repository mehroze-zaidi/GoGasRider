package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_empty_state.*
import kotlinx.android.synthetic.main.activity_home_slider.*

class EmptyState : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty_state)
        listeners()
    }

    fun listeners() {
        emptyScreenImg.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@EmptyState,
                    RideEndScreen::class.java
                )
            )
        })
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)

    }

}