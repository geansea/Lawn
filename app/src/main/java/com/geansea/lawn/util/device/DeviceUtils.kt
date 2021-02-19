package com.geansea.lawn.util.device

import android.os.Build

object DeviceUtils {
    fun isXiaomi() = Build.MANUFACTURER == "Xiaomi"
}