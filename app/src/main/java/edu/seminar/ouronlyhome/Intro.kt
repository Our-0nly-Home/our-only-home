package edu.seminar.ouronlyhome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro)
        val startButton = findViewById<Button>(R.id.button)
        startButton.setOnClickListener {
            val intent = Intent(this, Intro_erweiternung_1::class.java)
            startActivity(intent)
            R.drawable.test_background
        }
    }
}