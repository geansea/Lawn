package com.geansea.lawn.activity

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import com.geansea.lawn.R
import com.geansea.lawn.util.device.DeviceUtils

class HomeActivity : AppCompatActivity() {
    private lateinit var container: ViewGroup
    private lateinit var cells: GridLayout
    private lateinit var bottomBar: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        container = findViewById(R.id.container)
        cells = findViewById(R.id.cells)
        bottomBar = findViewById(R.id.bottom_bar)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        enableFullscreen()
    }

    private fun enableFullscreen() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val uiNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        val statusBarLightMode = uiNightMode != Configuration.UI_MODE_NIGHT_YES
        Log.i("HomeActivity", "statusBarLightMode: $statusBarLightMode")
        if (DeviceUtils.setStatusBarLightMode(window, statusBarLightMode)) {
            Log.i("HomeActivity", "StatusBarLightMode success")
        } else {
            Log.w("HomeActivity", "StatusBarLightMode fallback")
            container.setBackgroundColor(Color.BLACK)
        }
    }
}