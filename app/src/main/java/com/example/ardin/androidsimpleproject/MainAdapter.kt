package com.example.ardin.androidsimpleproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ardin.androidsimpleproject.R.id.textView_video_title

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

        val data = holder?.view?.findViewById<TextView>(textView_video_title)
        data?.text = video?.name

    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}