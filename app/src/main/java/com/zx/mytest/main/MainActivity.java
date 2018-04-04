package com.zx.mytest.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zx.mytest.R;
import com.zx.mytest.base.BaseActivity;
import com.zx.mytest.util.ToastUtils;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.main_mvp)
    Button btnMVP;
    @BindView(R.id.mian_qijian_mvp)
    Button mianQijianMvp;
    @BindView(R.id.main_openprot)
    Button mainOpenprot;


    String url = "https://www.easy-mock.com/mock/5ac4681e3c79552ff7a14b58/example/zhaoxiao";

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        init();
    }

    private void init() {
        btnMVP.setOnClickListener(this);
        mainOpenprot.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_mvp:
                Intent intent = new Intent(getApplicationContext(), MvpActivity.class);
                startActivity(intent);
                break;
            case R.id.main_openprot:
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        OkHttpClient okhttpClient = new OkHttpClient();  //
                        Request request = new Request.Builder().get().url(url).build();
                        okhttp3.Call call = okhttpClient.newCall(request);
                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Toast.makeText(getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                final String  result = response.body().string();
                                  Log.e("TAG", "onResponse: " + result);
                                Gson gson = new Gson();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), result+"", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                    }
                }.start();
                        break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
