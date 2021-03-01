package com.geansea.lawn.page.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import com.geansea.lawn.R
import com.geansea.lawn.util.ui.SystemUiUtils
import com.geansea.lawn.util.ui.ThemeUtils

class HomeActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
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
        initCells()
    }

    private fun enableFullscreen() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val statusBarDarkText = ThemeUtils.getAttribute(this,
                R.attr.fullscreenStatusBarDarkText, false)
        Log.i(TAG, "Use dark text on status bar: $statusBarDarkText")
        if (SystemUiUtils.setStatusBarDarkText(window, statusBarDarkText)) {
            Log.i(TAG, "SystemUiUtils.setStatusBarDarkText success")
        } else {
            Log.w(TAG, "SystemUiUtils.setStatusBarDarkText failed")
            container.setBackgroundColor(Color.BLACK)
        }
    }

    private fun initCells() {
    }
}