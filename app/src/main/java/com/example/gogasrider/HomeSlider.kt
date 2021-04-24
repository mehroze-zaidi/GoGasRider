package com.example.gogasrider

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_home_slider.*
import kotlinx.android.synthetic.main.activity_upload_images.*

class HomeSlider : AppCompatActivity() {
    var isFromChecked = false
    var isFromSharedPreferences = false

    override fun onStart() {
        super.onStart()
        setDarkMode()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_slider)
        listeners()

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            darkModeSwitch.visibility = View.GONE
            switchTextTv.visibility = View.GONE
        }


    }

    fun listeners() {
        logoutBtn.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeSlider,
                    EmptyState::class.java
                )
            )
        })

        darkModeSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            // do something, the isChecked will be
            // true if the switch is in the On position
            if (isFromSharedPreferences) {
                isFromSharedPreferences = false
                return@OnCheckedChangeListener
            }
            if (isChecked) {

                val context: Context = applicationContext
                val sharedPref = context.getSharedPreferences(
                    "stateKey", MODE_PRIVATE
                )
                sharedPref.edit().putInt("state", 1).apply()
                isFromChecked = true
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            } else {
                val context: Context = applicationContext
                val sharedPref = context.getSharedPreferences(
                    "stateKey", MODE_PRIVATE
                )
                sharedPref.edit().putInt("state", 0).apply()
                isFromChecked = true
                switchTextTv.text = "Light Mode"
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
            }
        })

        tankInformationTv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeSlider,
                    HomeScreen::class.java
                )
            )
        })

        walletTv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeSlider,
                    Wallet::class.java
                )
            )
        })

        profileTv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeSlider,
                    ProfileScreen::class.java
                )
            )
        })

        termAndConditionTv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeSlider,
                    TermAndConditionScreen::class.java
                )
            )
        })

        privacyPolicyTv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeSlider,
                    PrivacyPolicyScreen::class.java
                )
            )
        })

        sliderMenuIv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@HomeSlider,
                    HomeScreen::class.java
                )
            )
        })
        profilePic2Iv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HomeSlider, ProfileScreen::class.java))
        })

        notificationTv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HomeSlider, RequestScreen::class.java))
        })


    }

    fun setDarkMode() {
        if (!isFromChecked) {
            val sharedPref: SharedPreferences = applicationContext.getSharedPreferences(
                "stateKey",
                MODE_PRIVATE
            )
            val state = sharedPref.getInt("state", -1)
            if (state == 1) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                // delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                isFromSharedPreferences = true
                darkModeSwitch.isChecked = true
            }
            if (state == 0) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchTextTv.setText("Light Mode")
            }
        }
    }

}