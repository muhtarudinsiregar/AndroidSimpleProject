package com.example.ardin.androidsimpleproject

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course_lesson.*

class CourseLessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_lesson)

        webview_course_lesson.setBackgroundColor(Color.YELLOW)
        webview_course_lesson.loadUrl("https://www.google.com")
    }
}