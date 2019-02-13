package com.base.lib.base.rx;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.huobi.demo
 * @FileName     : RxBus.java
 * @Author       : chao
 * @Date         : 2019/1/23
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/

public class RxBus {
    private static volatile RxBus instance;
    private final Relay<Object> rxBus;

    public RxBus() {
        this.rxBus = PublishRelay.create().toSerialized();
    }

    public static RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = Holder.BUS;
                }
            }
        }
        return instance;
    }

    public void post(Object obj) {
        rxBus.accept(obj);
    }

    public <T> Observable<T> toObservable(Class<T> tClass) {
        return rxBus.ofType(tClass);
    }

    public Observable<Object> toObservable() {
        return rxBus;
    }

    public boolean hasObservers() {
        return rxBus.hasObservers();
    }

    private static class Holder {
        private static final RxBus BUS = new RxBus();
    }

}