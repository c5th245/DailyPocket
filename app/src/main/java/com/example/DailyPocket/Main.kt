package com.example.DailyPocket

import android.os.Bundle
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.FrameLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var backgroundImage: ImageView
    private lateinit var progressBar: ProgressBar
    private var zoomLevel = 1.0f  // zoom 1 = close, 0.8 = zoomed out

    private lateinit var menuToggleButton: ImageButton
    private lateinit var menuButtonsLayout: LinearLayout
    private lateinit var rootLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backgroundImage = findViewById(R.id.backgroundImage)
        progressBar = findViewById(R.id.progressBar)
        rootLayout = findViewById(R.id.rootLayout)

        simulateProgress()
        setupMenu()
    }

    private fun simulateProgress() {
        // Simulate progress for testing
        val progress = 40
        progressBar.progress = progress


        zoomLevel = 1f - (progress / 200f)
        applyZoomToBackground()
    }

    private fun applyZoomToBackground() {
        val zoom = ScaleAnimation(
            1f, zoomLevel, 1f, zoomLevel,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f
        )
        zoom.fillAfter = true
        zoom.duration = 800
        backgroundImage.startAnimation(zoom)

    }

    private fun setupMenu() {
        menuToggleButton = findViewById(R.id.menuToggleButton)
        menuButtonsLayout = findViewById(R.id.menuButtonsLayout)

        // Toggle menu visibility
        menuToggleButton.setOnClickListener {
            menuButtonsLayout.visibility =
                if (menuButtonsLayout.isVisible) View.GONE else View.VISIBLE
        }

        // Collapse menu if user taps outside
        rootLayout.setOnClickListener {
            if (menuButtonsLayout.isVisible) {
                menuButtonsLayout.visibility = View.GONE
            }
        }

        findViewById<Button>(R.id.profileButton).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        findViewById<Button>(R.id.calendarButton).setOnClickListener {
            startActivity(Intent(this, CalendarActivity::class.java))
        }
        findViewById<Button>(R.id.treeButton).setOnClickListener {
            startActivity(Intent(this, TreeActivity::class.java))
        }
        findViewById<Button>(R.id.noticeButton).setOnClickListener {
            startActivity(Intent(this, NoticeActivity::class.java))
        }
    }
}