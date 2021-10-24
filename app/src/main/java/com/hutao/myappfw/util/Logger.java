package com.hutao.myappfw.util;

import android.util.Log;

import com.hutao.myappfw.BuildConfig;

import java.util.Locale;
/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.util
 * @ClassName: Logger
 * @Description: 打印封装
 * @Author: hutao
 * @CreateDate: 2021/10/23 18:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 18:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Logger {
    private static final String TAG = "Logger";

    private Logger() {
        throw new RuntimeException("No instances!");
    }

    private static boolean isLoggable() {
        return BuildConfig.DEBUG;
    }

    public static void i(String tag, String fmt, Object... args) {
        if (isLoggable()) {
            Log.i(tag, format(fmt, args));
        }
    }

    public static void d(String tag, String fmt, Object... args) {
        if (isLoggable()) {
            Log.d(tag, format(fmt, args));
        }
    }

    public static void w(String tag, String fmt, Object... args) {
        if (isLoggable()) {
            Log.w(tag, format(fmt, args));
        }
    }

    public static void e(String tag, String fmt, Object... args) {
        if (isLoggable()) {
            Log.e(tag, format(fmt, args));
        }
    }

    public static void e(String tag, Throwable t, String fmt, Object... args) {
        if (isLoggable()) {
            Log.e(tag, format(fmt, args), t);
        }
    }

    private static String format(String fmt, Object... args) {
        if (args.length == 0) {
            return fmt;
        } else {
            return String.format(Locale.getDefault(), fmt, args);
        }
    }
}
