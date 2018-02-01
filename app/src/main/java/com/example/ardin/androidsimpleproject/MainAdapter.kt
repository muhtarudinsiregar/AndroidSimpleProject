package com.example.ardin.androidsimpleproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ardin.androidsimpleproject.R.id.*
import com.squareup.picasso.Picasso
import android.content.Intent
/**
 * Created by ardin on 29/01/18.
 */
class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {
    val videoList = listOf<String>("Jumanji", "Dilan")

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context);
        return CustomViewHolder(layoutInflater.inflate(R.layout.video_row, parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val video = homeFeed.videos.get(position)

        val title = holder?.view?.findViewById<TextView>(textView_video_title)
        title?.text = video?.name

        val channelName = holder?.view?.findViewById<TextView>(textView_channel_name)
        channelName?.text = video?.channel?.name

        val thumbnailImage = holder?.view?.findViewById<ImageView>(imageView_video_thumbnail)
        Picasso.with(holder?.view?.context).load(video?.imageUrl).into(thumbnailImage)

        val channelImage = holder?.view?.findViewById<ImageView>(imageView_channel_profile)
        Picasso.with(holder?.view?.context).load(video?.channel?.profileImageUrl).into(channelImage)

    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CourseDetailActivity::class.java)

            view.context.startActivity(intent)
        }
    }
}