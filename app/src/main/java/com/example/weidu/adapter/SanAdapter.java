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

class SanAdapter extends RecyclerView.Adapter <SanAdapter.TwoListViewHolder>{
   private Context context;
    private List<ShowBean.ProductItemBean.ProductItem> commodityList1;

    public SanAdapter(Context context, List<ShowBean.ProductItemBean.ProductItem> commodityList1) {
        this.context = context;
        this.commodityList1 = commodityList1;
    }


    @NonNull
    @Override
    public TwoListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_list_two, null);
        TwoListViewHolder twoListViewHolder = new TwoListViewHolder(view);
        return twoListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TwoListViewHolder twoListViewHolder, final int i) {
      twoListViewHolder.name.setText(commodityList1.get(i).commodityName);
        twoListViewHolder.price.setText(commodityList1.get(i).price);
        Glide.with(context).load(commodityList1.get(i).masterPic).into(twoListViewHolder.img);
        twoListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener3 !=null)
                {
                    listener3.onitemClickSan(twoListViewHolder,i,commodityList1.get(i).commodityId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList1.size();
    }

    public class TwoListViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public TwoListViewHolder(@NonNull View itemView) {
            super(itemView);
             img = itemView.findViewById(R.id.image3);
            price = itemView.findViewById(R.id.price3);
            name =  itemView.findViewById(R.id.title3);
        }
    }
    public interface setOnItemClickSan
    {
        void onitemClickSan(TwoListViewHolder v, int position, String id);
    }
    setOnItemClickSan listener3;
    public void setClickSan(setOnItemClickSan listener3)
    {
        this.listener3 =listener3;
    }
}
