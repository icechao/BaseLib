package com.base.lib.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.base.lib.base.rx.RxBus;
import com.base.lib.base.rx.RxEvent;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.ParameterizedType;

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
public abstract class BasePresenter<T extends BaseContract.View, Q extends BaseLogicWork> implements LifecycleObserver, BaseContract.Presenter {

    private T view;
    private Q work;
    private String rxEventType;
    private final CompositeDisposable subscriptions = new CompositeDisposable();

    public BasePresenter(T view) {
        this.view = view;
        rxEventType = getClass().getSimpleName();
        ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class clazz = (Class<Q>) ptype.getActualTypeArguments()[1];
        try {
            work = (Q) clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * RxBus消息,主线程执行
     *
     * @param event
     */
    private void onMainEvent(RxEvent event) {

    }

    /**
     * RxBus消息,子线程执行
     *
     * @param event
     */
    private void onNewThreadEvent(RxEvent event) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        RxBus.getInstance().toObservable(RxEvent.class).observeOn(Schedulers.io()).filter(new Predicate<RxEvent>() {
            @Override
            public boolean test(RxEvent rxEvent) {
                if (null != rxEvent && rxEvent.getEventType().equals(rxEventType)) {
                    onMainEvent(rxEvent);
                }
                return true;
            }
        }).observeOn(Schedulers.newThread()).filter(new Predicate<RxEvent>() {
            @Override
            public boolean test(RxEvent rxEvent) {
                if (null != rxEvent && rxEvent.getEventType().equals(rxEventType)) {
                    onNewThreadEvent(rxEvent);
                }
                return true;
            }
        }).subscribe(new Observer<RxEvent>() {
            @Override
            public void onSubscribe(Disposable d) {
                subscriptions.add(d);
            }

            @Override
            public void onNext(RxEvent rxEvent) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

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
        if (subscriptions.isDisposed()) {
            subscriptions.dispose();
        }
    }
}

