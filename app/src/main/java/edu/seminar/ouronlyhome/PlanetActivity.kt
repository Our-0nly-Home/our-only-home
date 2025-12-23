package edu.seminar.ouronlyhome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlanetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_planet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            val titleResId = intent.getIntExtra(EXTRA_TITLE_ID, R.string.default_title)
            val backgroundResId = intent.getIntExtra(EXTRA_BACKGROUND_ID, R.drawable.ic_launcher_background)

            title = getString(titleResId)
            findViewById<ImageView>(R.id.background_image_view).setImageResource(backgroundResId)
            findViewById<TextView>(R.id.title_text_view).setText(titleResId)

            insets
        }
    }

    companion object {
        // Schlüssel für die Intent-Extras
        const val EXTRA_TITLE_ID = "extra_title_id"
        const val EXTRA_BACKGROUND_ID = "extra_background_id"

        // Hilfsfunktion zum Starten der Activity
        fun start(context: Context, titleResId: Int, backgroundResId: Int) {
            val intent = Intent(context, PlanetActivity::class.java).apply {
                putExtra(EXTRA_TITLE_ID, titleResId)
                putExtra(EXTRA_BACKGROUND_ID, backgroundResId)
            }
            context.startActivity(intent)
        }
    }
}