package com.example.gogasrider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                    ConfirmRideScreen::class.java
                )
            )
        })
    }

}