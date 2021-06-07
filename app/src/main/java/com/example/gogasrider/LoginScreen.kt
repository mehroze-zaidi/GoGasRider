package com.example.gogasrider


import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_main.*


class LoginScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        listeners()


    }

    fun listeners() {
        continueBtn.setOnClickListener {


            val animOn = android.util.Pair.create<View, String>(continueBtn, "continueBtn")
            val animOn1 = android.util.Pair.create<View, String>(textView, "splashBtn")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn, animOn1)

            startActivity(
                Intent(this@LoginScreen, OTPScreen::class.java),
                activityOptionsCompat.toBundle()
            )

        }

        signUptTv.setOnClickListener(View.OnClickListener {

            val animOn = android.util.Pair.create<View, String>(signUptTv, "signUpTv")
            val animOn1 = android.util.Pair.create<View, String>(mobNoEt, "mobNoEt")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn, animOn1)

            startActivity(
                Intent(this@LoginScreen, SignUpScreen::class.java),
                activityOptionsCompat.toBundle()
            )
        })
        chatBackArrowIv.setOnClickListener(View.OnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.slide_out_right,R.anim.slide_in_left)
        })


    }

//    override fun onConfigurationChanged(newConfig: Configuration) {
//        Log.d("TAG", "onConfigurationChanged: called"  )
//        val currentNightMode: Int = newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK
//        when (currentNightMode) {
//            Configuration.UI_MODE_NIGHT_NO -> {
//                Toast.makeText(applicationContext, " light mode", Toast.LENGTH_SHORT).show()
//            }
//            Configuration.UI_MODE_NIGHT_YES -> {
//                Toast.makeText(applicationContext, " dark mode", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//    }
}