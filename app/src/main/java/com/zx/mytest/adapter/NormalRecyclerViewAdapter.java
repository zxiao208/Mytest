package com.zx.mytest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zx.mytest.R;
import com.zx.mytest.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater layoutInflater;
    private final Context context;
    private final ArrayList<String> list;
    OnItemClickListener onItemClickListener;
    public NormalRecyclerViewAdapter(Context context, ArrayList<String> list) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(layoutInflater.inflate(R.layout.item_recyclerview,parent,false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, final int position) {
            holder.item_tv.setText(list.get(position));
            if(onItemClickListener!=null){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onClick(position);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        onItemClickListener.onLongClick(position);
                        return false;
                    }
                });
            }


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder{
        TextView item_tv;
        Button item_btn;
        public NormalTextViewHolder(View itemView) {
            super(itemView);
            item_tv = itemView.findViewById(R.id.item_tv);

        }
    }

    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. onItemClickListener=onItemClickListener;
    }

}
