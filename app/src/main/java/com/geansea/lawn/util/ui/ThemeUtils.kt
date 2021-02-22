package com.geansea.lawn.util.ui

import android.content.Context
import android.util.Log
import android.util.TypedValue

object ThemeUtils {
    private val TAG = this::class.java.simpleName

    fun getAttribute(context: Context, resId: Int, defaultValue: Boolean): Boolean {
        val value = TypedValue()
        if (!context.theme.resolveAttribute(resId, value, true)) {
            Log.e(TAG, "Failed to resolve attribute $resId")
            return defaultValue
        }
        if (value.type != TypedValue.TYPE_INT_BOOLEAN) {
            Log.e(TAG, "Unexpected type ${value.type} to resolve attribute $resId")
            return defaultValue
        }
        return value.data != 0
    }
}