package com.example.gogasrider

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_profile_screen.*
import kotlinx.android.synthetic.main.activity_request_screen.*
import kotlinx.android.synthetic.main.activity_upload_images.*

class ProfileScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)
        listeners()
    }

    fun listeners() {

        updatePersonalInfoTv.setOnClickListener(View.OnClickListener {
            val animOn =
                android.util.Pair.create<View, String>(updatePersonalInfoTv, "updatePersonalInfoTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)


            startActivity(
                Intent(
                    this@ProfileScreen,
                    UpdateProfileScreen::class.java
                ), activityOptionsCompat.toBundle()
            )
        })

        updateTankInfoTv.setOnClickListener(View.OnClickListener {
            val animOn =
                android.util.Pair.create<View, String>(updateTankInfoTv, "updateTankInfoTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)

            startActivity(
                Intent(
                    this@ProfileScreen,
                    UpdateTankScreen::class.java
                ), activityOptionsCompat.toBundle()
            )
        })

        updateWallet.setOnClickListener(View.OnClickListener {

            val animOn =
                android.util.Pair.create<View, String>(updateWallet, "updateWalletTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn)
            startActivity(
                Intent(
                    this@ProfileScreen,
                    Wallet::class.java
                ), activityOptionsCompat.toBundle()
            )
        })
        profileBackArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })


    }

}