package com.example.gogasrider

import android.app.ActivityOptions
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
import kotlinx.android.synthetic.main.activity_home_slider.privacyPolicyTv
import kotlinx.android.synthetic.main.activity_home_slider.termAndConditionTv
import kotlinx.android.synthetic.main.activity_sign_up_screen.*
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
            val animOn =
                android.util.Pair.create<View, String>(logoutBtn, "continueBtn")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)
            startActivity(
                Intent(
                    this@HomeSlider,
                    LoginScreen::class.java
                ), activityOptionsCompat.toBundle()
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
            val animOn =
                android.util.Pair.create<View, String>(tankInformationTv, "setUpYourProfileTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)


            startActivity(
                Intent(
                    this@HomeSlider,
                    HomeScreen::class.java
                ), activityOptionsCompat.toBundle()
            )
        })

        walletTv.setOnClickListener(View.OnClickListener {
            val animOn =
                android.util.Pair.create<View, String>(walletTv, "updateWalletTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)

            startActivity(
                Intent(
                    this@HomeSlider,
                    Wallet::class.java
                ), activityOptionsCompat.toBundle()
            )
        })

        profileTv.setOnClickListener(View.OnClickListener {

            val animOn = android.util.Pair.create<View, String>(profileTv, "tankOverViewTv")
            val animOn1 = android.util.Pair.create<View, String>(profilePic2Iv, "profilePicIv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn, animOn1)
            startActivity(
                Intent(
                    this@HomeSlider,
                    ProfileScreen::class.java
                ), activityOptionsCompat.toBundle()
            )
        })

        termAndConditionTv.setOnClickListener(View.OnClickListener {
            val animOn =
                android.util.Pair.create<View, String>(termAndConditionTv, "termAndCondition")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)

            startActivity(
                Intent(
                    this@HomeSlider,
                    TermAndConditionScreen::class.java
                ), activityOptionsCompat.toBundle()
            )
        })

        privacyPolicyTv.setOnClickListener(View.OnClickListener {
            val animOn = android.util.Pair.create<View, String>(privacyPolicyTv, "privacyPolicy")
            val activityOptionsCompat = ActivityOptions.makeSceneTransitionAnimation(this, animOn)


            startActivity(
                Intent(
                    this@HomeSlider,
                    PrivacyPolicyScreen::class.java
                ), activityOptionsCompat.toBundle()
            )
        })

        sliderMenuIv.setOnClickListener(View.OnClickListener {

            onBackPressed()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        })
        profilePic2Iv.setOnClickListener(View.OnClickListener {
            val animOn = android.util.Pair.create<View, String>(profilePic2Iv, "profilePicIv")
            val animOn1 = android.util.Pair.create<View, String>(profileTv, "tankOverViewTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn, animOn1)



            startActivity(
                Intent(this@HomeSlider, ProfileScreen::class.java),
                activityOptionsCompat.toBundle()
            )
        })

        notificationTv.setOnClickListener(View.OnClickListener {
            val animOn = android.util.Pair.create<View, String>(notificationTv, "notificationTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)



            startActivity(
                Intent(this@HomeSlider, NotificationScreen::class.java),
                activityOptionsCompat.toBundle()
            )
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

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    }


}