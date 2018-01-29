package com.example.ardin.androidsimpleproject

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)

        listView.adapter = MyCustomAdapter() // adapter telling my list what to render

    }

    private class MyCustomAdapter() : BaseAdapter() {
//        private val mContext: Context
        private val names = arrayListOf<String>(
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki",
                "Donald Trump", "Jokowi", "Steve Jobs", "Steve Aoki"
        )


//        init {
//            this.mContext = context
//        }

        //responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowMain: View


            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(parent!!.context)
                rowMain = layoutInflater.inflate(R.layout.activity_row_main, parent, false)

//                val nTextView = rowMain.name_textView
//                val pTextView = rowMain.position_textview
//
//
//                val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
//                val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)

                val viewHolder = ViewHolder(rowMain.name_textView, rowMain.position_textview)

                rowMain.tag = viewHolder
            } else {
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder

            viewHolder.nameTextView.text = names.get(position)
            viewHolder.positionTextView.text = "Row Number : $position"

            return rowMain
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)


        override fun getItem(position: Int): Any {
            return "COBA DISINI"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return names.size
        }

    }

}
