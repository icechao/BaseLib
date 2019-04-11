package com.base.netlib;

import android.os.Build;
import android.support.annotation.RequiresApi;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.netlib
 * @FileName     : NetException.java
 * @Author       : chao
 * @Date         : 2019/4/11
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class NetException extends Exception {

    private int code;

    public NetException(int code, String msg) {
        this(msg);
        this.code = code;
    }

    public NetException(String message) {
        super(message);
    }

    public NetException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetException(Throwable cause) {
        super(cause);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public NetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getCode() {
        return code;
    }
}
