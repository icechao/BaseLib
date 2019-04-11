package com.base.netlib;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Executor;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.netlib
 * @FileName     : asdfasdf.java
 * @Author       : chao
 * @Date         : 2019/4/11
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/

public class AndroidScheduler implements Executor {

    private static AndroidScheduler instance;

    private final Scheduler mMainScheduler;
    private final Handler mHandler;

    private AndroidScheduler() {
        mHandler = new Handler(Looper.myLooper());
        mMainScheduler = Schedulers.from(this);
    }

    public static synchronized Scheduler mainThread() {
        if (instance == null) {
            instance = new AndroidScheduler();
        }
        return instance.mMainScheduler;
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mHandler.post(command);
    }

}
