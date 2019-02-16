package com.example.weidu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.weidu.R;
import com.example.weidu.bean.ShowBean;

import java.util.List;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.HlistViewHodel> {
    Context context;
    List<ShowBean.ProductItemBean.ProductItem> list;
    public OneAdapter(Context context, List<ShowBean.ProductItemBean.ProductItem> list) {
        this.context=context;
        this.list=list;

    }


    @NonNull
    @Override
    public HlistViewHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView;
        mView=View.inflate(viewGroup.getContext(),R.layout.item_shouye1,null);
        return new HlistViewHodel(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HlistViewHodel hlistViewHodel, final int i) {
        hlistViewHodel.name.setText(list.get(i).commodityName);
        hlistViewHodel.price.setText("¥"+list.get(i).price);
        Glide.with(context).load(list.get(i).masterPic).into(hlistViewHodel.img);
        hlistViewHodel.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener !=null)
                {
                    listener.onitemClick(hlistViewHodel,i,list.get(i).commodityId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HlistViewHodel extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public HlistViewHodel(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            price = itemView.findViewById(R.id.price1);
            name =  itemView.findViewById(R.id.name1);
        }
    }
    public interface setOnItemClick
    {
        void onitemClick(HlistViewHodel v, int position, String id);
    }
    setOnItemClick listener;
    public void setClick(setOnItemClick listener)
    {
        this.listener =listener;
    }
}
