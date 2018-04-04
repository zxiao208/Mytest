package com.zx.mytest.model;

import android.os.Handler;
import android.util.JsonWriter;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zx.mytest.callback.MvpCallback;
import com.zx.mytest.main.MvpActivity;
import com.zx.mytest.util.OkhttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/3/1 0001.
 */

public class MvpModel {
    /**
     * 获取网络接口数据
     * @param param 请求参数
     * @param callback 数据回调接口
     */
    public static void getNetData(final String param, final MvpCallback callback){
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        new Thread(new Runnable(){
            @Override
            public void run() {
                switch (param){
                    case "normal":
                        String url = "https://www.easy-mock.com/mock/5ac4681e3c79552ff7a14b58/example/zhaoxiao";
                        OkHttpClient okhttpClient = new OkHttpClient();
                        Request request = new Request.Builder().get().url(url).build();
                        okhttp3.Call call = okhttpClient.newCall(request);
                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }
                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String result = response.body().string();
                                 Log.e("result 网络请求结果是 :::", "onResponse: " + result);
                                Gson gson = new Gson();
                                callback.onSuccess(result);
                                callback.onComplete();
                            }
                        });
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }

            }
        }).start();
    }



    private static void getJson(final MvpCallback callback) throws IOException {

    }
}
