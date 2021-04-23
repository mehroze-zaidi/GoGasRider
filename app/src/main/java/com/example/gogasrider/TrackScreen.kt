package com.example.gogasrider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_chat.mic_c
import kotlinx.android.synthetic.main.activity_home_slider.*
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_track_screen.*
import kotlinx.android.synthetic.main.activity_track_screen.backArrowIv

class TrackScreen : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_screen)
        val mapFragment = supportFragmentManager
            .findFragmentById(com.example.gogasrider.R.id.map1) as SupportMapFragment
        mapFragment.getMapAsync(this)
        listeners()

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    fun listeners() {
        backArrowIv.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@TrackScreen,
                    RequestScreen::class.java
                )
            )
        })

        backArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })

    }
}