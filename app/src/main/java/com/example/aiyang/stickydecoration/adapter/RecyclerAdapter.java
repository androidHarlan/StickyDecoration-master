package com.example.aiyang.stickydecoration.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aiyang.stickydecoration.R;
import com.example.aiyang.stickydecoration.bean.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aiyang on 2018/4/26.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * context
     */
    public Context mContext;

    /**
     * 集合
     */
    public List<data> mDatas = new ArrayList<>();
    /**
     * data
     */
    public data mData;

    public RecyclerAdapter(Context mContext, List<data> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    static class ViewHolde extends RecyclerView.ViewHolder {

        TextView txt;
        public ViewHolde(View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        Log.d("aaa","onCreateViewHolder————"+viewType);
        if (viewType == 1){//标题
            View item = LayoutInflater.from(mContext).inflate(R.layout.item_layout , parent ,false);
            item.setTag(true);
            return new ViewHolde(item);
        }else{
            View item1 = LayoutInflater.from(mContext).inflate(R.layout.item_layout1 , parent ,false);
            item1.setTag(false);
            return new ViewHolde(item1);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  ViewHolde){
            mData =mDatas.get(position);
           ((ViewHolde) holder).txt. setText(mData.getName());
//            Log.d("aaa","onBindViewHolder————"+mData.getName());
           if (mData.getType() == 1){
              /* ((ViewHolde) holder).txt .setTextColor(mContext.getColor(R.color.colorAccent));
               ((ViewHolde) holder).txt .setBackgroundColor(mContext.getColor(R.color.backcolor));*/
               ((ViewHolde) holder).txt .setTextSize(20);
           }else{

           }
        }
    }

    @Override
    public int getItemViewType(int position) {
//        Log.d("aaa","getItemViewType————"+ mDatas.get(position).getType());
        return mDatas.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

}
