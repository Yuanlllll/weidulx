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

public class TwoAdapter extends RecyclerView.Adapter <TwoAdapter.SanListViewHolder>{
private Context context;
private List<ShowBean.ProductItemBean.ProductItem> commodityList1;

public TwoAdapter(Context context, List<ShowBean.ProductItemBean.ProductItem> commodityList1) {
        this.context = context;
        this.commodityList1 = commodityList1;
        }


    @NonNull
@Override
public SanListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_list_two, null);
        SanListViewHolder sanListViewHolder = new SanListViewHolder(view);
        return sanListViewHolder;
        }

@Override
public void onBindViewHolder(@NonNull final SanListViewHolder sanListViewHolder, final int i) {
     sanListViewHolder.name.setText(commodityList1.get(i).commodityName);
     sanListViewHolder.price.setText(commodityList1.get(i).price);
        Glide.with(context).load(commodityList1.get(i).masterPic).into(sanListViewHolder.img);
    sanListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(listener2 !=null)
            {
                listener2.onitemClickTwo(sanListViewHolder,i,commodityList1.get(i).commodityId);
            }
        }
    });
        }

@Override
public int getItemCount() {
        return commodityList1.size();
        }

public class SanListViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView name;
    TextView price;
    public SanListViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.image3);
        price = itemView.findViewById(R.id.price3);
        name =  itemView.findViewById(R.id.title3);
    }
}
    public interface setOnItemClickTwo
    {
        void onitemClickTwo(SanListViewHolder v, int position, String id);
    }
    setOnItemClickTwo listener2;
    public void setClickTwo(setOnItemClickTwo listener2)
    {
        this.listener2 =listener2;
    }
}
