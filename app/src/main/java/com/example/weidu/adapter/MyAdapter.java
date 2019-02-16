package com.example.weidu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.weidu.R;
import com.example.weidu.bean.ShowBean;

import java.util.List;

public class  MyAdapter extends RecyclerView.Adapter {
    Context context;
    private final int RXXP_VIEW = 0;
    private final int MLSS_VIEW = 1;
    private final int PZSH_VIEW = 2;
    private List<ShowBean.ProductItemBean> resultBeans;

    private List<ShowBean.ProductItemBean.ProductItem> commodityList1;
    private OneAdapter oneAdapter;
    private TwoAdapter sanAdapter;
    private SanAdapter twoAdapter;
    private Intent intent;
    public MyAdapter(Context context,List<ShowBean.ProductItemBean> resultBeans) {
        this.context =context;
        this.resultBeans=resultBeans;
    }



    @Override
    public int getItemViewType(int position) {
        switch (position)
        {
            case 0:
                return RXXP_VIEW;
            case 1:
                return MLSS_VIEW;

        }
        return PZSH_VIEW;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView;
        if(i==RXXP_VIEW)
        {
            mView=View.inflate(viewGroup.getContext(),R.layout.shouye_1,null);
            return new Item1ViewHolder(mView);
        }else if(i == MLSS_VIEW)
        {
            return new Item2ViewHolder(LayoutInflater.from(context).inflate(R.layout.shouye_2,viewGroup,false));
        }
        else {
            return new Item3ViewHolder(LayoutInflater.from(context).inflate(R.layout.shouye_3,viewGroup,false));
        }
    }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i)
    {
        if(viewHolder instanceof Item1ViewHolder)
        {
            ((Item1ViewHolder) viewHolder).rxxp.setText(resultBeans.get(i).name);
            commodityList1 = resultBeans.get(i).commodityList;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            ((Item1ViewHolder) viewHolder).rv.setLayoutManager(linearLayoutManager);
            oneAdapter = new OneAdapter(context,commodityList1);
            ((Item1ViewHolder) viewHolder).rv.setAdapter(oneAdapter);

        }
        if(viewHolder instanceof Item2ViewHolder){
        ((Item2ViewHolder) viewHolder).mlss.setText(resultBeans.get(i).name);
            Log.i("onBidddddwHoldeddr: ",resultBeans.get(i).name);
        commodityList1 = resultBeans.get(i).commodityList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        ((Item2ViewHolder) viewHolder).rv2.setLayoutManager(linearLayoutManager);
            sanAdapter = new TwoAdapter(context,commodityList1);
            ((Item2ViewHolder) viewHolder).rv2.setAdapter(sanAdapter);

    }
       if(viewHolder instanceof  Item3ViewHolder)
        { ((Item3ViewHolder) viewHolder).pzsh.setText(resultBeans.get(i).name);
            Log.i("aaonBiddwHoldeddr: ",resultBeans.get(i).name);
            commodityList1 = resultBeans.get(i).commodityList;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
            gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            ((Item3ViewHolder) viewHolder).rv3.setLayoutManager(gridLayoutManager);
             twoAdapter = new SanAdapter(context,commodityList1);
            ((Item3ViewHolder) viewHolder).rv3.setAdapter(twoAdapter);



        }

    }
    @Override
    public int getItemCount() {
        return  resultBeans.size();

    }
    class Item1ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv;
        TextView rxxp;

        public Item1ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv);
            rxxp = itemView.findViewById(R.id.rxxptv);
        }
    }

    class Item2ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv2;
        TextView mlss;
        public Item2ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv2 = itemView.findViewById(R.id.rv2);
            mlss = itemView.findViewById(R.id.mlsstv);
        }
    }
    class Item3ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rv3;
        TextView pzsh;
        public Item3ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv3 = itemView.findViewById(R.id.rv3);
            pzsh = itemView.findViewById(R.id.pzshtv);
        }
    }

}
