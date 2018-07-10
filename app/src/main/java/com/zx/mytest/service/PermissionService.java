package com.zx.mytest.service;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.zx.mytest.main.MainActivity;

/**
 * Created by Administrator on 2018/7/9 0009.
 * 使用service动态申请权限
 */

public class PermissionService extends Service {
    static  String  TAG_SERVICE = "PermissionService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG_SERVICE," permissionService start");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.w(TAG_SERVICE, "in onStartCommand");
        Log.w(TAG_SERVICE, "MyService:" + this);
        String name = intent.getStringExtra("name");
        Log.w(TAG_SERVICE, "name:" + name);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG_SERVICE,"service onDestroy");

    }
}
