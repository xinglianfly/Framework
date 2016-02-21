package com.example.administrator.frameworkdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.frameworkdemo.R;

import java.util.List;

/**
 * Created by xiner on 16/2/21.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public RecyclerAdapter(List<String> mItems){
        this.mItems = mItems;
    }

    List<String> mItems;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = mItems.get(position);
        holder.mTextview.setText(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            private final TextView mTextview;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextview = (TextView) itemView.findViewById(R.id.listivwew_text);
        }
    }

}
