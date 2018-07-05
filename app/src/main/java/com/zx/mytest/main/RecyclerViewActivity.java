package com.zx.mytest.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zx.mytest.R;
import com.zx.mytest.adapter.NormalRecyclerViewAdapter;
import com.zx.mytest.base.BaseActivity;
import com.zx.mytest.util.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class RecyclerViewActivity extends BaseActivity {

    @BindView(R.id.recyclerdemo)
    RecyclerView recyclerdemo;

    private ArrayList<String> list = new ArrayList<String>();
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_recyclerview;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("大潘");
        list.add("刘文");
        NormalRecyclerViewAdapter normalRecyclerViewAdapter = new NormalRecyclerViewAdapter(this,list);
        recyclerdemo.setLayoutManager(new LinearLayoutManager(this));
        recyclerdemo.setAdapter(normalRecyclerViewAdapter);
        normalRecyclerViewAdapter.setOnItemClickListener(new NormalRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ToastUtils.shortShow(getApplicationContext(),"短按"+position);
            }

            @Override
            public void onLongClick(int position) {
                ToastUtils.longShow(getApplicationContext(),"长按"+position);
            }
        });
    }
}
