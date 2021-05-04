package com.example.gogasrider

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_sign_up_screen.*
import kotlinx.android.synthetic.main.activity_update_profile_screen.*
import kotlinx.android.synthetic.main.activity_update_profile_screen.update_now_pi
import kotlinx.android.synthetic.main.activity_update_tank_screen.*
import kotlinx.android.synthetic.main.activity_update_tank_screen.backTankIv
import kotlinx.android.synthetic.main.activity_update_tank_screen.frontTankIv
import java.io.File

class UpdateTankScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_tank_screen)
        listeners()
    }

    fun listeners() {
        update_now_pi.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@UpdateTankScreen,
                    Wallet::class.java
                )
            )
        })
        updateTankeBackArrowIv.setOnClickListener(View.OnClickListener { onBackPressed() })

        frontTankIv.setOnClickListener {
            ImagePicker.with(this)

                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .cropSquare()    //Crop square image, its same as crop(1f, 1f)
                .compress(1024)    //Final image size will be less than 1 MB
                .setImageProviderInterceptor { imageProvider -> //Intercept ImageProvider
                    Log.d("ImagePicker", "Selected ImageProvider: " + imageProvider.name)
                }
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
                        frontTankIv.setImageURI(fileUri)

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

        backTankIv.setOnClickListener {
            ImagePicker.with(this)

                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .cropSquare()    //Crop square image, its same as crop(1f, 1f)
                .compress(1024)    //Final image size will be less than 1 MB
                .setImageProviderInterceptor { imageProvider -> //Intercept ImageProvider
                    Log.d("ImagePicker", "Selected ImageProvider: " + imageProvider.name)
                }
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
                        backTankIv.setImageURI(fileUri)

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
    }

}