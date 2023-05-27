package com.example.grointern.utilis

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.grointern.R

import java.io.IOException

class GlideLoader(val context: Context) {


    fun loadUserPicture(image: Any, imageView: ImageView) {
        try {
            Glide
                .with(context)
                .load(image)
                .placeholder(R.drawable.ic_baseline_verified_user_24)
                .into(imageView)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}