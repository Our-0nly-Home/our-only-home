package edu.seminar.ouronlyhome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ankunft : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ankunft)

        val btnStart = findViewById<Button>(R.id.btn_start_quiz)
        btnStart.setOnClickListener {
            val intent = Intent(this, Umweltbewusstsein::class.java)
            startActivity(intent)
        }
    }
}
