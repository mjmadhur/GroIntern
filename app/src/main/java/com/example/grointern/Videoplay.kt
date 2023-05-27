package com.example.grointern

import android.media.session.MediaController
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_videoplay.*

class Videoplay : AppCompatActivity() {
    lateinit var videoView: VideoView

    // on below line we are creating
    // a variable for our video url.
    lateinit var videoUrl:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplay)

        // on below line we are initializing
        // our buttons with id.
        videoUrl=intent.getStringExtra("url")!!
        videoView = videoview;

        // on below line we are creating
        // uri for our video view.
        val uri: Uri = Uri.parse(videoUrl)

        // on below line we are setting
        // video uri for our video view.
        videoView.setVideoURI(uri)

        // on below line we are creating variable
        // for media controller and initializing it.
        val mediaController = android.widget.MediaController(this)

        // on below line we are setting anchor
        // view for our media controller.
        mediaController.setAnchorView(videoView)

        // on below line we are setting media player
        // for our media controller.
        mediaController.setMediaPlayer(videoView)

        // on below line we are setting media
        // controller for our video view.
        videoView.setMediaController(mediaController)

        // on below line we are
        // simply starting our video view.
        videoView.start()

    }
}
