package com.example.nikita.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val timeMe = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer_text.text = ("У тебя осталось: " + millisUntilFinished/1000 + " секунд!")
            }

            override fun onFinish() {
                val secondIntent = Intent(applicationContext, LastActivity::class.java)

                secondIntent.putExtra("score", count_text.text)

                startActivity(secondIntent)
            }

        }

        timeMe.start()
    }

    fun countMe(view: View) {
        val countString = count_text.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++

        count_text.text = count.toString()
    }
}
