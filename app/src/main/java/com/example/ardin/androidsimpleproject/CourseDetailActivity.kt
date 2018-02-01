package com.example.ardin.androidsimpleproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class CourseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView_main.setBackgroundColor(Color.DKGRAY)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = CourseDetailAdapter()

        //change navbar title
        val title = intent.getStringExtra(CustomViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title = title

        fetchJson()
    }

    private fun fetchJson() {
        val videoId = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY, -1)

        val courseDetailUrl = "https://api.letsbuildthatapp.com/youtube/course_detail?id=$videoId"

        val client = OkHttpClient()
        val request = Request.Builder().url(courseDetailUrl).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {

            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()

                val courseLesson = gson.fromJson(body, Array<CourseLesson>::class.java)

            }

        })
    }


}

private class CourseDetailAdapter : RecyclerView.Adapter<CourseDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CourseDetailViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val customView = layoutInflater.inflate(R.layout.course_detail_row, parent, false)

//        val blueView = View(parent?.context)
//        blueView.setBackgroundColor(Color.BLUE)
//        blueView.minimumHeight = 50
        return CourseDetailViewHolder(customView)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: CourseDetailViewHolder?, position: Int) {

    }


}

private class CourseDetailViewHolder(val customView: View) : RecyclerView.ViewHolder(customView) {

}