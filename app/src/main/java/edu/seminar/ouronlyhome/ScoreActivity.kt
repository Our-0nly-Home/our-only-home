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
        val maxScore = intent.getIntExtra("MAX_SCORE", 140)

        val tvTotalScore = findViewById<TextView>(R.id.tv_total_score)
        tvTotalScore.text = "$totalScore / $maxScore"

        val tvScoreMessage = findViewById<TextView>(R.id.tv_score_message)
        if (totalScore <= 70) {
            tvScoreMessage.text =
                "Leider konntest du dem Planeten nicht helfen. Der Ausgangszustand ist gleich oder hat sich verschlechtert. Versuche es nochmal!"
        }else if (totalScore > 70 && totalScore < 105) {
            tvScoreMessage.text = "Der Planet wird sich in Zukunft erhohlen, jedoch nur sehr langsam. Beim nächsten Mal schaffst du es besser!"
        } else if (totalScore > 105 && totalScore < 140) {
            tvScoreMessage.text = "Dank deiner Hilfe geht es dem Planeten und deren Bevölkerung besser. In den nächsten Jahren wird der Planet wieder sauberer."
        } else if (totalScore == 140) {
            tvScoreMessage.text = "Super gemacht! Du hast alle Fragen richtig beantwortet. Dank dir wird sich der Planet erholen."
        }

        val btnRestart = findViewById<Button>(R.id.btn_restart)
        btnRestart.setOnClickListener {
            val intent = Intent(this, ankunft::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
