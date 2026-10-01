package edu.seminar.ouronlyhome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Lebensmittelverschwendung2 : AppCompatActivity() {
    private var receivedPoints: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lebensmittelverschwendung2)

        receivedPoints = intent.getIntExtra("SCORE_POINTS", 0)

        val option1 = findViewById<Button>(R.id.btn_option1)
        val option2 = findViewById<Button>(R.id.btn_option2)
        val option3 = findViewById<Button>(R.id.btn_option3)

        option1.setOnClickListener {
            navigateToNext(10)
        }

        option2.setOnClickListener {
            navigateToNext(0)
        }

        option3.setOnClickListener {
            navigateToNext(5)
        }
    }

    private fun navigateToNext(points: Int) {
        val totalPoints = receivedPoints + points
        val intent = Intent(this, VerantwortungUnternehmen::class.java).apply {
            putExtra("SCORE_POINTS", totalPoints)
        }
        startActivity(intent)
    }
}
