package com.example.grointern.TriedExoplaYER

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grointern.R
import com.example.grointern.Videoplay
import com.example.grointern.model.videos
import com.example.grointern.utilis.GlideLoader
import kotlinx.android.synthetic.main.videoblog.view.*


class VideoAdap(
    val context: Context,
    var itemList: ArrayList<videos>,

    ) :
    RecyclerView.Adapter<VideoAdap.EveViewHolder>() {

    class EveViewHolder(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EveViewHolder {
        return EveViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.videoblog, parent, false)
        )
    }


    override fun onBindViewHolder(holder: EveViewHolder, position: Int) {
        val model = itemList[position]
        holder.itemView.title.text = model.getcreatorname()
        holder.itemView.desc.text = model.getlikes()
        GlideLoader(context).loadUserPicture(model.getclipurl(), holder.itemView.thumbnlmj)
        GlideLoader(context).loadUserPicture(model.getvideourl(),holder.itemView.cretimg)
holder.itemView.setOnClickListener {
    val intent=Intent(context,Videoplay::class.java)
    intent.putExtra("url",itemList[position].getclipurl())
    context.startActivity(intent)
}
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}