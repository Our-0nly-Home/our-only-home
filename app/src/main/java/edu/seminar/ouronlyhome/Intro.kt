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
        val option1 = findViewById<Button>(R.id.btn_option1)
        val option2 = findViewById<Button>(R.id.btn_option2)
        val option3 = findViewById<Button>(R.id.btn_option3)

        // 2. Set click listeners for each, passing different point values
        option1.setOnClickListener {
            navigateToNext(10) // Option 1 gives 10 points
        }

        option2.setOnClickListener {
            navigateToNext(5)  // Option 2 gives 5 points
        }

        option3.setOnClickListener {
            navigateToNext(0)  // Option 3 gives 0 points
        }
    }

    /**
     * Helper function to handle navigation and pass point data
     */
    private fun navigateToNext(points: Int) {
        val intent = Intent(this, Intro_erweiternung_1::class.java).apply {
            // This sends the point value to the next activity
            putExtra("SCORE_POINTS", points)
        }
        startActivity(intent)
    }

}


