package com.example.ardin.androidsimpleproject

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        val redColor = Color.parseColor("#FF0000")
        listView.setBackgroundColor(redColor)

        listView.adapter = MyCustomAdapter(this) // adapter telling my list what to render

    }

    private class MyCustomAdapter(context: Context) : BaseAdapter() {
        private val mContext: Context

        init {
            this.mContext = context
        }

        //responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val textView = TextView(mContext)

            textView.text = "Lorem ipsum dolor"
            return textView
        }


        override fun getItem(position: Int): Any {
            return "COBA DISINI"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return 5
        }

    }
}
