package com.example.nikita.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        count_text.text = "0"

        val timeMe = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer_text.text = "У тебя осталось:\n${millisUntilFinished / 1000} секунд!"
            }

            override fun onFinish() {
                val secondIntent = Intent(applicationContext, LastActivity::class.java)
                secondIntent.putExtra("score", count)
                startActivity(secondIntent)
                finish()
            }
        }
        timeMe.start()
    }

    fun countMe(view: View) {
        count++
        count_text.text = count.toString()
    }
}
