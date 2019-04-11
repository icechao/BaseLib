package com.base.netlib;

import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.netlib
 * @FileName     : asdf.java
 * @Author       : chao
 * @Date         : 2019/4/11
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> io_main() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidScheduler.mainThread());
    }
}
