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
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import com.example.ardin.androidsimpleproject.R.id.*
import com.squareup.picasso.Picasso

class CourseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView_main.setBackgroundColor(Color.DKGRAY)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
//        recyclerView_main.adapter = CourseDetailAdapter()

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

                runOnUiThread {
                    recyclerView_main.adapter = CourseDetailAdapter(courseLesson)
                }
            }

        })
    }


}

private class CourseDetailAdapter(val courseLesson: Array<CourseLesson>) : RecyclerView.Adapter<CourseDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CourseDetailViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val customView = layoutInflater.inflate(R.layout.course_detail_row, parent, false)

        return CourseDetailViewHolder(customView)
    }

    override fun getItemCount(): Int {
        return courseLesson.size
    }

    override fun onBindViewHolder(holder: CourseDetailViewHolder?, position: Int) {
        val courseLesson = courseLesson.get(position)

        val courseTitle = holder?.customView?.findViewById<TextView>(textView_course_lesson_title)
        courseTitle?.text = courseLesson.name

        val duration = holder?.customView?.findViewById<TextView>(textView_duration)
        duration?.text = courseLesson.duration

        val thumbnail = holder?.customView?.findViewById<ImageView>(imageView_course_lesson_thumbnail)

        Picasso.with(holder?.customView?.context).load(courseLesson.imageUrl).into(thumbnail)
    }


}

private class CourseDetailViewHolder(val customView: View) : RecyclerView.ViewHolder(customView) {
    init {
        customView.setOnClickListener {
            val intent = Intent(customView.context, CourseLessonActivity::class.java)
            customView.context.startActivity(intent)
        }
    }
}