package com.geansea.lawn.util.ui

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.view.View
import android.view.Window
import com.geansea.lawn.util.device.DeviceUtils

object SystemUiUtils {
    private val TAG = this::class.java.simpleName

    fun setStatusBarDarkText(window: Window, darkText: Boolean): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val oldFlag = window.decorView.systemUiVisibility
            window.decorView.systemUiVisibility = if (darkText) {
                oldFlag or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                oldFlag and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
            return true
        }
        if (DeviceUtils.isXiaomi()) {
            return setMiuiStatusBarDarkText(window, darkText)
        }
        return false
    }

    @SuppressLint("PrivateApi")
    fun setMiuiStatusBarDarkText(window: Window, darkText: Boolean): Boolean {
        try {
            val layoutParamsClass = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
            val darkModeField = layoutParamsClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
            val darkModeFlag = darkModeField.getInt(layoutParamsClass)

            val windowClass = window.javaClass
            val extraFlagMethod = windowClass.getMethod("setExtraFlags", Int::class.javaPrimitiveType, Int::class.javaPrimitiveType)
            if (darkText) {
                extraFlagMethod.invoke(window, darkModeFlag, darkModeFlag)
            } else {
                extraFlagMethod.invoke(window, 0, darkModeFlag)
            }
            return true
        } catch (e: Exception) {
            Log.e(TAG, "Failed to set EXTRA_FLAG_STATUS_BAR_DARK_MODE on MIUI", e)
            return false
        }
    }
}