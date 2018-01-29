package com.example.ardin.androidsimpleproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by ardin on 29/01/18.
 */
class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return 2
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context);
        return CustomViewHolder(layoutInflater.inflate(R.layout.video_row, parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

    }
}

class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val card = view

}