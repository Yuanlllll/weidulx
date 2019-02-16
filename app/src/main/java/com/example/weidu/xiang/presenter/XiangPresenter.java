package com.example.weidu.xiang.presenter;


import com.example.weidu.XiangQingActivity;
import com.example.weidu.bean.XiangBean;
import com.example.weidu.xiang.model.Imodel;
import com.example.weidu.xiang.model.XiangModel;

public class XiangPresenter implements Ipresenter
{
    XiangQingActivity xview;
    private final XiangModel xiangModel;
    public XiangPresenter( XiangQingActivity xview) {
        this.xview = xview;
        xiangModel = new XiangModel();
    }

    @Override
    public void getPdata(String xid)
    {
        xiangModel.getMdata(new Imodel.ListCallBack() {
            @Override
            public void getSuccess(XiangBean xiangBean) {
                xview.getVdata(xiangBean);
            }

            @Override
            public void getFailed() {

            }
        });

    }
}
