package com.zx.mytest.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.zx.mytest.R;
import com.zx.mytest.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class OkhttpDemoActivity extends BaseActivity {
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
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }
}
