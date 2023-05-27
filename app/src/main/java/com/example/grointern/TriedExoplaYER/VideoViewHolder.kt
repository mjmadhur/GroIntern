package com.example.grointern.TriedExoplaYER

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.grointern.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val playerView: PlayerView = itemView.findViewById(R.id.player_view)
    val thumbnailView: ImageView = itemView.findViewById(R.id.thumbnail_view)
    var player: SimpleExoPlayer? = null
    //private val player: SimpleExoPlayer = SimpleExoPlayer.Builder(itemView.context).build()

    fun bind(videoUrl: String) {
        val mediaItem = MediaItem.fromUri(videoUrl)
        player!!.setMediaItem(mediaItem)
        player!!.prepare()
       // player!!.play()
        playerView.player = player
    }

    fun releasePlayer() {
        player!!.release()
    }
    fun click(){
        player!!.stop()
    }
}
