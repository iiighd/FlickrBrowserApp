package com.example.myfliker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class PhotoDetailActivity : AppCompatActivity() {
    lateinit var photoImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)
        val photoURL = intent.getStringExtra("photoURL")
        photoImageView = findViewById(R.id.photo_expanded_iv)
        Glide.with(this)
            .load("${photoURL}_b.jpg")
            .into(photoImageView)
    }
}