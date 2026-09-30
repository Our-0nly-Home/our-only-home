package edu.seminar.ouronlyhome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val totalScore = intent.getIntExtra("TOTAL_SCORE", 0)
        val maxScore = intent.getIntExtra("MAX_SCORE", 20)

        val tvTotalScore = findViewById<TextView>(R.id.tv_total_score)
        tvTotalScore.text = "$totalScore / $maxScore"

        val btnRestart = findViewById<Button>(R.id.btn_restart)
        btnRestart.setOnClickListener {
            val intent = Intent(this, Umweltbewusstsein::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
