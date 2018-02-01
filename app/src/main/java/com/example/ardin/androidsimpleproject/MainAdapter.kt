package com.example.ardin.androidsimpleproject

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ardin.androidsimpleproject.R.id.*
import com.squareup.picasso.Picasso

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {
    val videoList = listOf<String>("Jumanji", "Dilan")

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return CustomViewHolder(layoutInflater.inflate(R.layout.video_row, parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val video = homeFeed.videos.get(position)

        val title = holder?.view?.findViewById<TextView>(textView_video_title)
        title?.text = video.name

        val channelName = holder?.view?.findViewById<TextView>(textView_channel_name)
        channelName?.text = video.channel.name

        val thumbnailImage = holder?.view?.findViewById<ImageView>(imageView_video_thumbnail)
        Picasso.with(holder?.view?.context).load(video.imageUrl).into(thumbnailImage)

        val channelImage = holder?.view?.findViewById<ImageView>(imageView_channel_profile)
        Picasso.with(holder?.view?.context).load(video.channel.profileImageUrl).into(channelImage)

        holder?.video = video
    }
}

class CustomViewHolder(val view: View, var video: Video? = null) : RecyclerView.ViewHolder(view) {
    companion object {
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CourseDetailActivity::class.java)
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)
            view.context.startActivity(intent)
        }
    }
}