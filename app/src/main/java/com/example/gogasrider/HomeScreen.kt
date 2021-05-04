package com.example.gogasrider

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shasin.notificationbanner.Banner
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_home_slider.*
import kotlinx.android.synthetic.main.activity_waiting_screen.*
import kotlinx.android.synthetic.main.pop_up_notification_design.*
import kotlinx.android.synthetic.main.pop_up_notification_design.view.*


class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        listeners()
    }

    fun listeners() {

//        val d: Disposable = RxView.clicks(uploadTankAlphaIv).subscribe(object : Consumer<Any?> {
//            override fun accept(o: Any?) {
//                Toast.makeText(applicationContext, "Button clicked", Toast.LENGTH_SHORT).show()
//            }
//        })


        uploadTankAlphaIv.setOnClickListener(View.OnClickListener {

            val animOn = android.util.Pair.create<View, String>(uploadTankAlphaIv, "uploadIv")
            val animOn1 =
                android.util.Pair.create<View, String>(tankOverViewTv, "setUpYourProfileTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn, animOn1)


            startActivity(
                Intent(
                    this@HomeScreen,
                    UploadImages::class.java
                ), activityOptionsCompat.toBundle()
            )
        })

        infoIv.setOnClickListener(View.OnClickListener {
            black_Shade.visibility = View.VISIBLE
            round_view.visibility = View.VISIBLE
            infoTv.visibility = View.VISIBLE


        })

        black_Shade.setOnClickListener(View.OnClickListener {
            black_Shade.visibility = View.GONE
            round_view.visibility = View.GONE
            infoTv.visibility = View.GONE
        })

        menuIv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HomeScreen, HomeSlider::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)

        })

        viewWalletTv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HomeScreen, Wallet::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)


        })
        profilePicIv.setOnClickListener(View.OnClickListener {
            val animOn = android.util.Pair.create<View, String>(profilePicIv, "profilePicIv")
            val animOn1 = android.util.Pair.create<View, String>(activeBalTv, "activeBalTv")
            val animOn2 = android.util.Pair.create<View, String>(tankOverViewTv, "tankOverViewTv")
            val activityOptionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, animOn, animOn1, animOn2)


            startActivity(

                Intent(this@HomeScreen, ProfileScreen::class.java),
                activityOptionsCompat.toBundle()
            )
        })
        bellIv.setOnClickListener {
            startActivity(

                Intent(this@HomeScreen, NotificationScreen::class.java)
            )
        }


        earningTv.setOnClickListener {
            callBanner()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    }

    private fun callBanner() {
        Banner.make(
            findViewById(android.R.id.content),
            application,
            Banner.TOP,
            R.layout.pop_up_notification_design
        )
        Banner.getInstance().duration = 4000
        Banner.getInstance().setCustomAnimationStyle(R.style.NotificationAnimationTop)
        Banner.getInstance().show()
        Banner.getInstance().bannerView.notiTv.setOnClickListener {
            Toast.makeText(
                application,
                "clicked",
                Toast.LENGTH_SHORT
            )
        }
    }
}