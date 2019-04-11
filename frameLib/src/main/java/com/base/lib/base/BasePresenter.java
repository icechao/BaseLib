package com.base.lib.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.lib.base
 * @FileName     : BasePresenter.java
 * @Author       : chao
 * @Date         : 2019/1/27
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class BasePresenter<T extends BaseContract.View> implements LifecycleObserver, BaseContract.Presenter {

    private T view;
    private String rxEventType = getClass().getName();

    public BasePresenter(T view) {
        this.view = view;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        view = null;
    }
}

