package com.example.gogasrider


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
        continueBtn.setOnClickListener(View.OnClickListener
        {
            startActivity(Intent(this@LoginScreen, OTPScreen::class.java))

        })

        signUptTv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@LoginScreen, SignUpScreen::class.java))
        })
        backArrowIv.setOnClickListener(View.OnClickListener {
            onBackPressed()
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