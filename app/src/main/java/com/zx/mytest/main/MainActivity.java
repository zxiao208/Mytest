package com.zx.mytest.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zx.mytest.R;
import com.zx.mytest.base.BaseActivity;
import com.zx.mytest.service.PermissionService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public static final int INSTALL_PACKAGES_REQUESTCODE = 212;  //随便赋值一个整数，不能大于65536

    public static MainActivity mainActivity;
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
    @BindView(R.id.main_btn_startService)
    Button mainBtnStartService;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mainActivity = this;
        init();
    }

    private void init() {
        btnMVP.setOnClickListener(this);
        mainOpenprot.setOnClickListener(this);
        mainBtnRecyclerview.setOnClickListener(this);
        mainBtnOkhttp.setOnClickListener(this);
        mainBtnStartService.setOnClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case INSTALL_PACKAGES_REQUESTCODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //  installapk  申请成功执行安装操作
                } else {
                    Uri packageURI = Uri.parse("package:" + getPackageName());
                    Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,packageURI);
                    startActivityForResult(intent, 100);
                }
                break;

        }
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
            case R.id.main_btn_startService:
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.REQUEST_INSTALL_PACKAGES},INSTALL_PACKAGES_REQUESTCODE);
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
