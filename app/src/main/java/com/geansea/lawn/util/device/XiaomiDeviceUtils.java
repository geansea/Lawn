package com.geansea.lawn.util.device;

import android.annotation.SuppressLint;
import android.view.Window;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class XiaomiDeviceUtils {
    @SuppressLint("PrivateApi")
    public static void setStatusBarDarkMode(Window window, boolean darkMode) {
        try {
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field darkModeField = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            int darkModeFlag = darkModeField.getInt(layoutParams);

            Class<?> clazz = window.getClass();
            Method extraFlagMethod = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagMethod.invoke(window, darkMode ? darkModeFlag : 0, darkModeFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
