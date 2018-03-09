package com.zx.mytest.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zx.mytest.R;
import com.zx.mytest.base.BaseActivity;
import com.zx.mytest.callback.MvpCallback;
import com.zx.mytest.presenter.MvpPresenter;
import com.zx.mytest.viewInterface.MvpView;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/1 0001.
 */

public class MvpActivity extends BaseActivity implements View.OnClickListener,MvpView{

    @BindView(R.id.mvpdemo_btn_getdata)
     Button btn_getdata;
    @BindView(R.id.mvpdemo_btn_getdataff)
     Button btn_getdataff;
    @BindView(R.id.mvpdemo_btn_getdatafe)
     Button btn_getdatafe;
    @BindView(R.id.mvpdemo_text)
     TextView tv_content;

    private ProgressDialog progressDialog;
    private MvpPresenter presenter;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_mvpdemo;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        // 初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        //初始化Presenter
        presenter = new MvpPresenter();
        // 绑定View引用
        presenter.attachView(this);

        btn_getdata.setOnClickListener(this);
        btn_getdatafe.setOnClickListener(this);
        btn_getdataff.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mvpdemo_btn_getdata:
                presenter.getData("normal");
                break;
            case R.id.mvpdemo_btn_getdataff:
                presenter.getData("failure");
                break;
            case R.id.mvpdemo_btn_getdatafe:
                presenter.getData("error");
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoading() {
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showErr() {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showData(String data) {
        tv_content.setText(data);
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        tv_content.setText(msg);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        tv_content.setText("网络请求数据出现异常");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
