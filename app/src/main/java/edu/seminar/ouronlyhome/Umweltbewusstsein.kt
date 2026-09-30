package edu.seminar.ouronlyhome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Umweltbewusstsein : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_umweltbewusstsein)
        val option1 = findViewById<Button>(R.id.btn_option1)
        val option2 = findViewById<Button>(R.id.btn_option2)
        val option3 = findViewById<Button>(R.id.btn_option3)

        option1.setOnClickListener {
            navigateToNext(0)
        }

        option2.setOnClickListener {
            navigateToNext(5)
        }

        option3.setOnClickListener {
            navigateToNext(10)
        }
    }


    private fun navigateToNext(points: Int) {
        val intent = Intent(this, Muelltrennung::class.java).apply {
            // This sends the point value to the next activity
            putExtra("SCORE_POINTS", points)
        }
        startActivity(intent)
    }

}


