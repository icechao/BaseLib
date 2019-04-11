package com.base.netlib;

import android.util.Log;
import org.reactivestreams.Subscriber;
import retrofit2.HttpException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.netlib
 * @FileName     : asdfaf.java
 * @Author       : chao
 * @Date         : 2019/4/11
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/

public abstract class SimpleSubscriber<T> implements Subscriber<T> {

    @Override
    public void onComplete() {

    }


    @Override
    public void onError(Throwable e) {//这里通常就处理异常
        if (e instanceof NetException) {
            NetException exception = (NetException) e;
//            ToastUtil.showToast(exception.message);
        } else if (e instanceof UnknownHostException) {
//            ToastUtil.showToast("请打开网络");
        } else if (e instanceof SocketTimeoutException) {
//            ToastUtil.showToast("请求超时");
        } else if (e instanceof ConnectException) {
//            ToastUtil.showToast("连接失败");
        } else if (e instanceof HttpException) {
//            ToastUtil.showToast("请求超时");
        } else {
//            ToastUtil.showToast("请求失败");
        }
        Log.e("net", e.getMessage());
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {//这里的是获得了数据,方法意思很明显,下一步干啥
        if (t != null) {//这里最好判断一下是否为null.
            call(t);
        } else {
//            ToastUtil.showToast("连接失败");
        }
    }

    /**
     * 因为具体的处理这里无法得知,所以抽象.
     */
    public abstract void call(T t);
}