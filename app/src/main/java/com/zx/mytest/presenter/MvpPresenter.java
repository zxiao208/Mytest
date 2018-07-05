package com.zx.mytest.presenter;

import com.zx.mytest.base.BasePresenter;
import com.zx.mytest.callback.MvpCallback;
import com.zx.mytest.model.MvpModel;
import com.zx.mytest.viewInterface.MvpView;

/**
 * Created by Administrator on 2018/3/1 0001.
 */

public class MvpPresenter extends BasePresenter<MvpView> {
    // View接口
    private MvpView mView;

    public MvpPresenter() {
        //构造方法中不再需要View参数
    }

    /*
      * 绑定view，一般在初始化中调用该方法
      */
    public void attachView(MvpView mvpView) {
        this.mView = mvpView;
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached() {
        return mView != null;
    }

    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    public void getData(String params) {
        //显示正在加载进度条
        mView.showLoading();
        // 调用Model请求数据
        MvpModel.getNetData(params, new MvpCallback<String>() {
            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据
                if (isViewAttached()) {
                    mView.showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                //调用view接口提示失败信息
                if (isViewAttached()) {
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                //调用view接口提示请求异常
                if (isViewAttached()) {
                    getView().showErr();
                }
            }

            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                if (isViewAttached()) {
//                    getView().hideLoading();
                }
            }
        });
    }
}
