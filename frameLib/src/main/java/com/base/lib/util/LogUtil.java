package com.base.lib.util;


import android.os.Build;
import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.Logger;


/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.huobi.klinelib.utils
 * @FileName     : LogUtil.java
 * @Author       : chao
 * @Date         : 2019/1/10
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class LogUtil {
    private final static String TAG = "LogUtil=>";

    public static void i(Object o) {
        if (BuildConfig.DEBUG) {
            Logger.e(TAG, String.valueOf(o));
        }
    }

    public static void d(Object o) {
        if (BuildConfig.DEBUG) {
            Logger.e(TAG, String.valueOf(o));
        }
    }

    public static void e(Object o) {
        if (BuildConfig.DEBUG) {
            Logger.e(TAG, String.valueOf(o));
        }
    }

    public static void w(Object o) {
        if (BuildConfig.DEBUG) {
            Logger.e(TAG, String.valueOf(o));
        }
    }

}
