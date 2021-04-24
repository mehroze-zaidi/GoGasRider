package com.example.gogasrider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_home_slider.*


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
            startActivity(
                Intent(
                    this@HomeScreen,
                    UploadImages::class.java
                )
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

        })

        viewWalletTv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HomeScreen, Wallet::class.java))
        })

    }
}