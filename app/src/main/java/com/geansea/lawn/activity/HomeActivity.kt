package com.geansea.lawn.activity

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.geansea.lawn.R
import com.geansea.lawn.util.device.DeviceUtils

class HomeActivity : AppCompatActivity() {
    private lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        container = findViewById(R.id.container)

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