package com.zx.mytest.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zx.mytest.R;
import com.zx.mytest.base.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.zx.mytest.util.LogTag.OKHTTP3_TAG;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class OkhttpDemoActivity extends BaseActivity implements View.OnClickListener {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final String URLStr = "http://192.168.7.128:8080/";
    public static final int POSTSTR = 1;

    @BindView(R.id.ok_btn_get)
    Button okBtnGet;
    @BindView(R.id.ok_tv_get)
    TextView okTvGet;
    @BindView(R.id.ok_btn_poststring)
    Button okBtnPoststring;
    @BindView(R.id.ok_tv_poststring)
    TextView okTvPoststring;
    @BindView(R.id.ok_btn_postmap)
    Button okBtnPostmap;
    @BindView(R.id.ok_tv_postmap)
    TextView okTvPostmap;
    @BindView(R.id.ok_btn_poststream)
    Button okBtnPoststream;
    @BindView(R.id.ok_tv_poststream)
    TextView okTvPoststream;
    @BindView(R.id.ok_btn_postform)
    Button okBtnPostform;
    @BindView(R.id.ok_tv_postform)
    TextView okTvPostform;
    @BindView(R.id.ok_btn_postupfile)
    Button okBtnPostupfile;
    @BindView(R.id.ok_tv_postupfile)
    TextView okTvPostupfile;
    @BindView(R.id.ok_btn_httpheader)
    Button okBtnHttpheader;
    @BindView(R.id.ok_tv_httpheader)
    TextView okTvHttpheader;
    @BindView(R.id.ok_btn_synchronousget)
    Button okBtnSynchronousget;
    @BindView(R.id.ok_tv_synchronousget)
    TextView okTvSynchronousget;
    @BindView(R.id.ok_btn_asynchronousget)
    Button okBtnAsynchronousget;
    @BindView(R.id.ok_tv_asynchronousget)
    TextView okTvAsynchronousget;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case POSTSTR:
                    okTvPoststring.setText(msg.obj+"");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_okhttp;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        okBtnGet.setOnClickListener(this);
        okBtnPoststring.setOnClickListener(this);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_btn_get:
                okGet();
                break;
            case R.id.ok_btn_poststring:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("name", "lisan");
                            jsonObject.put("age", 1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        String url = URLStr+"test/register.do";
                        String result = okPostStr(url, jsonObject.toString());
                        Message message =new Message();
                        message.what=POSTSTR;
                        message.obj=result;
                        handler.sendMessage(message);
                        Log.i("okpoststr", "result== " + result);

                    }
                }).start();


                break;
            default:
                break;
        }
    }

    //异步get请求
    public void okGet() {
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
        Request request = new Request.Builder().url(URLStr+"test/getregister.do").method("GET", null).build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(new Callback() {
            //请求失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(OKHTTP3_TAG, "请求失败");
            }

            //请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                OkhttpDemoActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i(OKHTTP3_TAG, "请求结果：" + result);
                        okTvGet.setText(result);

                    }
                });
            }

        });

    }

    public String okPostStr(String url, String json) {
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            if (response != null) {
                Log.i("TAG", response.header("head1", "空") + response.header("head2", "空"));
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String okPostMap(){

        return null;
    }

}
