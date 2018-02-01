package com.example.ardin.androidsimpleproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

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