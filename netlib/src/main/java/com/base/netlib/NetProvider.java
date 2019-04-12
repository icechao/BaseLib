package com.base.netlib;

import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/*************************************************************************
 * Description   :
 *
 * @PackageName  : com.base.netlib
 * @FileName     : NetProvider.java
 * @Author       : chao
 * @Date         : 2019/4/11
 * @Email        : icechliu@gmail.com
 * @version      : V1
 *************************************************************************/
public class NetProvider<Q> {
    private static NetProvider provider;
    private Q service;
    private String url;

    private NetProvider(String url) {
        this.url = url;
    }

    /**
     * 根据给的url和apiService重新生成一个retrofit对外
     *
     * @param url
     * @param clazz
     * @return
     */
    public static <T> T newInstance(String url, Class<T> clazz) {
        provider = new NetProvider(url);
        return provider.getRetrofit().create(clazz);
    }

    /**
     * 获取已经生成的对象
     *
     * @param url
     * @return
     */
    public NetProvider getInstance(String url) {
        if (null == provider) {
            synchronized (NetProvider.class) {
                if (null == provider) {
                    provider = new NetProvider(url);
                }
            }
        }
        return provider;
    }

    public Q getService() {
        if (null == service) {
            throw new RuntimeException("service has not init!");
        } else {
            return service;
        }
    }

    public void withService(Class<Q> clazz) {
        service = provider.getRetrofit().create(clazz);
    }


    /**
     * 获取retrofit实例
     *
     * @return {@link Retrofit}
     */
    public Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> {
            if (BuildConfig.DEBUG) {
                try {
                    String text = URLDecoder.decode(message, "utf-8");
                    Log.e("OKHttp-----", text);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    Log.e("OKHttp-----", message);
                }
            }
        });

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
