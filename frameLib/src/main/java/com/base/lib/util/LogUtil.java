package com.huobi.demo;

import android.util.Log;

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
    private final static String TAG = "CHAO=>";

    public static void i(Object o) {
        Logger.e(TAG, String.valueOf(o));
    }

    public static void d(Object o) {
        Logger.e(TAG, String.valueOf(o));
    }

    public static void e(Object o) {
        Logger.e(TAG, String.valueOf(o));
    }

    public static void w(Object o) {
        Logger.e(TAG, String.valueOf(o));
    }

}
