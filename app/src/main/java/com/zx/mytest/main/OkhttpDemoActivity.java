package com.zx.mytest.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.zx.mytest.R;
import com.zx.mytest.base.BaseActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.zx.mytest.util.LogTag.OKHTTP3_TAG;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class OkhttpDemoActivity extends BaseActivity implements View.OnClickListener {

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

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_okhttp;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        okBtnGet.setOnClickListener(this);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok_btn_get:
                okGet();
                break;
            default:
                break;
        }
    }

    //异步get请求
    public void okGet(){
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
        Request request = new Request.Builder().url("http://192.168.7.223:19017").method("GET",null).build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(new Callback(){
            //请求失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(OKHTTP3_TAG,"请求失败");
            }

            //请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String result= response.body().string();
                Log.i(OKHTTP3_TAG,"请求结果："+result);
            }

        });

    }
}
