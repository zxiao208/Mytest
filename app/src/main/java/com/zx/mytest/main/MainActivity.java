package com.zx.mytest.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zx.mytest.R;
import com.zx.mytest.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.main_mvp)
    Button btnMVP;
    @BindView(R.id.main_qijian_mvp)
    Button mianQijianMvp;
    @BindView(R.id.main_openprot)
    Button mainOpenprot;
    @BindView(R.id.main_btn_recyclerview)
    Button mainBtnRecyclerview;
    @BindView(R.id.main_btn_okhttp)
    Button mainBtnOkhttp;


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
        mainBtnRecyclerview.setOnClickListener(this);
        mainBtnOkhttp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_mvp:
                Intent intent = new Intent(getApplicationContext(), MvpActivity.class);
                startActivity(intent);
                break;
            case R.id.main_openprot:
                break;
            case R.id.main_btn_recyclerview:
                Intent intent1 = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                startActivity(intent1);
                break;
            case R.id.main_btn_okhttp:
                Intent intent2 = new Intent(getApplicationContext(), OkhttpDemoActivity.class);
                startActivity(intent2);
                break;
            default:
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
