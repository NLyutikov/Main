package com.example.nikita.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_last.*
import java.lang.Integer.parseInt

class LastActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        val score = intent.getStringExtra("score")
        score_text.text = "Твой результат: $score очков!"

        val rating = parseInt(score)
        if (rating < 50) {
            rating_text.text = "Слабовато!"
        } else if (rating >= 50) {
            rating_text.text = "Недурно!"
        } else if (rating >= 100) {
            rating_text.text = "Читер!"
        }
    }

    fun resetMe(view: View) {
        val resetIntent = Intent(this, SecondActivity::class.java)
        startActivity(resetIntent)
    }
}
