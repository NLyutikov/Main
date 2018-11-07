package com.example.nikita.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_last.*

class LastActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        val score = intent.getIntExtra("score", 0)
        score_text.text = "Твой результат:\n$score очков!"

        when {
            score < 50 -> rating_text.text = "Слабовато!"
            score >= 50 -> rating_text.text = "Недурно!"
            score >= 100 -> rating_text.text = "Читер!"
        }
    }

    fun resetMe(view: View) {
        val resetIntent = Intent(applicationContext, SecondActivity::class.java)
        startActivity(resetIntent)
        finish()
    }
}
