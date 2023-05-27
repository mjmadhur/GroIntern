package com.example.grointern.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grointern.R
import com.example.grointern.TriedExoplaYER.VideoViewHolder
import com.example.grointern.model.videos
import com.example.grointern.utilis.GlideLoader

class VideoAdapter(
    val context: Context,
    private val videoUrls: ArrayList<videos>) : RecyclerView.Adapter<VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_video, parent, false)
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videoUrls[position].getclipurl())
        GlideLoader(context).loadUserPicture(videoUrls[position].getvideourl(),holder.thumbnailView)
        holder.playerView.player = holder.player

        holder.itemView.setOnClickListener {
        holder.player!!.play()
        // holder.click()
        }
    }

    override fun getItemCount(): Int {
        return videoUrls.size
    }

    override fun onViewRecycled(holder: VideoViewHolder) {
        super.onViewRecycled(holder)
        holder.releasePlayer()
    }
}
