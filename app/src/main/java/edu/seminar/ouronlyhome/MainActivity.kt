package edu.seminar.ouronlyhome

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)

    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    findViewById<Button>(R.id.button_mars).setOnClickListener {
      PlanetActivity.start(
        context = this,
        titleResId = R.string.planet_mars_title,
        backgroundResId = R.drawable.ic_launcher_background,
      )
    }

    findViewById<Button>(R.id.button_jupiter).setOnClickListener {
      PlanetActivity.start(
        this,
        R.string.planet_jupiter_title,
        com.google.android.material.R.drawable.m3_split_button_chevron_avd,
      )
    }

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }
  }
}
