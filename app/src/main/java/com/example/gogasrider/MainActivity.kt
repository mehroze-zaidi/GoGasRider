package com.example.gogasrider

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    var isFromChecked = false
    var isFromSharedPreferences = false
    override fun onStart() {
        super.onStart()
        setDarkMode()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//// Remember that you should never show the action bar if the
//// status bar is hidden, so hide that too if necessary.
//        actionBar?.hide()
        listeners()
    }

    fun listeners() {
        //using Rx
//        val d: Disposable = RxView.clicks(getStartedBtn).throttleFirst(100, TimeUnit.MILLISECONDS)
//            .subscribe(object : Consumer<Any?> {
//                override fun accept(o: Any?) {
//                    Toast.makeText(applicationContext, "Button clicked", Toast.LENGTH_SHORT).show()
//                }
//            })

//        getStartedBtn.setOnClickListener(View.OnClickListener {
//            startActivity(Intent(this@MainActivity, LoginScreen::class.java))
//        })
    }

    fun setDarkMode() {
        if (!isFromChecked) {
            val sharedPref: SharedPreferences = applicationContext.getSharedPreferences(
                "stateKey",
                MODE_PRIVATE
            )
            val state = sharedPref.getInt("state", -1)
            if (state == 1) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                // delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                isFromSharedPreferences = true
            }
        }
    }


    //    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        if (hasFocus) hideSystemUI()
//    }
//    private fun hideSystemUI() {
//        // Enables regular immersive mode.
//        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
//        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
//                // Set the content to appear under the system bars so that the
//                // content doesn't resize when the system bars hide and show.
//                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                // Hide the nav bar and status bar
//                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_FULLSCREEN)
//    }
//
//    // Shows the system bars by removing all the flags
//// except for the ones that make the content appear under the system bars.
//    private fun showSystemUI() {
//        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
//    }
//    override fun onConfigurationChanged(newConfig: Configuration) {
//        Log.d("TAG", "onConfigurationChanged: called")
//        val currentNightMode: Int = newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK
//        when (currentNightMode) {
//            Configuration.UI_MODE_NIGHT_NO -> {
//                Toast.makeText(applicationContext, " light mode", Toast.LENGTH_SHORT).show()
//            }
//            Configuration.UI_MODE_NIGHT_YES -> {
//                Log.d("TAG", "onConfigurationChanged: yes called")
//
//                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
//                Toast.makeText(applicationContext, " dark mode", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//    }

}