package com.example.gogasrider

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_profile_screen.*
import kotlinx.android.synthetic.main.activity_request_screen.*
import kotlinx.android.synthetic.main.activity_upload_images.*
import java.io.File

class ProfileScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)
        listeners()
    }

    fun listeners() {


        profileText.setOnClickListener {
            ImagePicker.with(this)

                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .cropSquare()	//Crop square image, its same as crop(1f, 1f)
                .compress(1024)	//Final image size will be less than 1 MB
                .setImageProviderInterceptor { imageProvider -> //Intercept ImageProvider
                    Log.d("ImagePicker", "Selected ImageProvider: "+imageProvider.name)
                }
                .saveDir(File(Environment.getExternalStorageDirectory(), "ImagePicker"))
                .galleryMimeTypes(  //Exclude gif images
                    mimeTypes = arrayOf(
                        "image/png",
                        "image/jpg",
                        "image/jpeg"
                    )
                )
                .start { resultCode, data ->
                    if (resultCode == Activity.RESULT_OK) {
                        //Image Uri will not be null for RESULT_OK
                        val fileUri = data?.data
                        profile_image.setImageURI(fileUri)

                        //You can get File object from intent
                        val file: File? = ImagePicker.getFile(data)

                        //You can also get File Path from intent
                        val filePath: String? = ImagePicker.getFilePath(data)
                    } else if (resultCode == ImagePicker.RESULT_ERROR) {
                        Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
                    }
                }
        }

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