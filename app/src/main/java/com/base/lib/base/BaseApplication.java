package com.base.lib.base;

import android.app.Application;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.lib.base
 * @FileName     : BaseApplication.java
 * @Author       : chao
 * @Date         : 2019/1/27
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
