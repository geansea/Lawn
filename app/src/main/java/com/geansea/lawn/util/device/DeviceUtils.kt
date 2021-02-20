package com.geansea.lawn.util.device

import android.os.Build
import android.view.View
import android.view.Window

object DeviceUtils {
    fun setStatusBarLightMode(window: Window, lightMode: Boolean): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val oldFlag = window.decorView.systemUiVisibility
            window.decorView.systemUiVisibility = if (lightMode) {
                oldFlag or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                oldFlag and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
            return true
        }
        if (isXiaomi()) {
            return XiaomiDeviceUtils.setStatusBarTextDarkMode(window, lightMode)
        }
        return false
    }

    fun isXiaomi() = Build.MANUFACTURER == "Xiaomi"
}