package com.zx.mytest.util;

import android.app.Application;

import com.androidnetworking.interceptors.GzipRequestInterceptor;
import com.zx.mytest.base.MyApplication;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;


/**
 * Created by Administrator on 2018/4/4 0004.
 */

public class OkhttpUtil {
    private static OkHttpClient mOKHttpClient;
    //设置缓存目录
    private static final File cacheDirectory = new File(MyApplication.getInstance().getCacheDir().getAbsolutePath(), "httpCache");
    private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 2014);
    static OkHttpClient okHttpClient;

    /**
     * 以builder的形式构建 okhttp,如果只是通过new的形式,创建不了拦截器
     *
     * @return
     */
    public static OkHttpClient getOkhttpInstance() {
        if (okHttpClient == null) {
            synchronized (OkhttpUtil.class) {// 双重加锁机制,后面也要对空判断,假设两个线程都到这里,不判断,下一个线程还是会再创建
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
//                    okHttpClient = new OkHttpClient.Builder();
//                            .addInterceptor(new LoggingInterceptor())
//                            .build();
                }
            }
        }
        return okHttpClient;
    }


}
