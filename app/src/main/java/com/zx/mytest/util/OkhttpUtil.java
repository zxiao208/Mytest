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
    private static final File cacheDirectory = new File(MyApplication.getInstance().getCacheDir().getAbsolutePath(),"httpCache");
    private static Cache cache = new Cache(cacheDirectory,10*1024*2014);



}
