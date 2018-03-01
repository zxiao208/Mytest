package com.zx.mytest.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    private Button btn_getdata;
    @BindView(R.id.mvpdemo_btn_getdataff)
    private Button btn_getdataff;
    @BindView(R.id.mvpdemo_btn_getdatafe)
    private Button btn_getdatafe;
    @BindView(R.id.mvpdemo_text)
    private TextView tv_content;

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
        presenter = new MvpPresenter(this);
        btn_getdata.setOnClickListener(this);
        btn_getdatafe.setOnClickListener(this);
        btn_getdataff.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mvpdemo_btn_getdata:

                break;
            case R.id.mvpdemo_btn_getdataff:

                break;
            case R.id.mvpdemo_btn_getdatafe:

                break;
            default:
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData(String data) {

    }

    @Override
    public void showFailureMessage(String msg) {

    }

    @Override
    public void showErrorMessage() {

    }
}
