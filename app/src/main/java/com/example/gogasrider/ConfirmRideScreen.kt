package com.example.gogasrider


import android.content.Intent
import android.graphics.Color
import android.graphics.Color.YELLOW
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_confirm_ride_screen.*
import kotlinx.android.synthetic.main.activity_home_slider.*


class ConfirmRideScreen : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_ride_screen)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(com.example.gogasrider.R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setMultipleColorsInTextView()
        listeners()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
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

    fun setMultipleColorsInTextView() {
        // val textView = findViewById<View>(R.id.onTheWayTv) as TextView
        val word: Spannable = SpannableString("On the way to ")

        word.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0,
            word.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        onTheWayTv.text = word
        val wordTwo: Spannable = SpannableString("Zeeshan ")




        wordTwo.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.yellow)),
            0,
            wordTwo.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        onTheWayTv.append(wordTwo)
        val wordThree: Spannable = SpannableString("Home ")

        wordThree.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0,
            wordThree.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        onTheWayTv.append(wordThree)
    }

    fun listeners() {
        trackRideBtn.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@ConfirmRideScreen,
                    Chat::class.java
                )
            )
        })
    }
}