package com.example.randroidapp

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //where layout connects to activity

        //get access to each view `findViewById<_type_>(r.id._its id_)
        val rollButton = findViewById<Button>(R.id.rollButton)
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val seekBarValue = findViewById<TextView>(R.id.seekBarValue)

        //prompt user to pick a value on seek bar
        seekBarValue.text = "Select a value!"

        //when the button is clicked, set what it does
        rollButton.setOnClickListener {
            //error handling for 0
            if(seekBar.progress == 0){
                resultsTextView.text = 0.toString()
            } else {
                val rand = Random.nextInt(seekBar.progress) + 1
                resultsTextView.text = rand.toString()
            }
        }

        //display which value seek bar is on
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                seekBarValue.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }
}