package com.example.ardin.androidsimpleproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textView_Progress.translationY

        //handle text view animation when seekbar is in action
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_Progress.text = progress.toString()

                val translationDistance = (initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textView_Progress.animate().translationY(translationDistance)

                if (!fromUser)
                    textView_Progress.animate().setDuration(500).rotationBy(360f).translationY(
                            initialTextViewTranslationY
                    )

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        //button reset

        button_reset.setOnClickListener {
            seekBar.progress = 0

        }
    }
}
