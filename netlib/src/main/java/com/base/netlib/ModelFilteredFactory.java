package com.base.netlib;

import android.os.Build;
import android.support.annotation.RequiresApi;
import io.reactivex.*;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.netlib
 * @FileName     : asdfas.java
 * @Author       : chao
 * @Date         : 2019/4/11
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class ModelFilteredFactory {


    private final static ObservableTransformer transformer = new SimpleTransformer();

    /**
     * 将Observable<BaseResponse<T>>转化Observable<T>,并处理BaseResponse
     *
     * @return 返回过滤后的Observable.
     */
    @SuppressWarnings("unchecked")
    public static <T> Observable<T> compose(Observable<Response<T>> observable) {
        return observable.compose(transformer);
    }

    /**
     * 这里就不细讲了,具体可以去看rxjava的使用.这个类的意义就是转换Observable.
     */
    private static class SimpleTransformer<T> implements ObservableTransformer<Response<T>, T> {

        /**
         * 处理请求结果,BaseResponse
         *
         * @param response 请求结果
         * @return 过滤处理, 返回只有data数据的Observable
         */
        private Observable<T> flatResponse(Response<T> response) {
            return Observable.create(new ObservableOnSubscribe<T>() {
                @Override
                public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                    if (emitter.isDisposed()) {
                        return;
                    }
                    if (response.getCode() == NetConstants.NET_SUCCESS) {//请求成功

                        emitter.onNext(response.getData());

                    } else {//请求失败

                        //这里抛出自定义的一个异常.可以处理服务器返回的错误.
                        emitter.onError(new NetException(response.getCode(), response.getMsg()));

                        return;
                    }
                    //请求完成
                    emitter.onComplete();

                }
            });
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public ObservableSource<T> apply(Observable<Response<T>> upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidScheduler.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .timeout(5, TimeUnit.SECONDS)//重连间隔时间
                    .retry(5)//重连次数
                    .flatMap((Function<Response<T>, Observable<T>>) tResponse -> flatResponse(tResponse));
        }
    }
}