package com.example.p7day03work2.model;

import com.example.p7day03work2.base.BaseActrivity;
import com.example.p7day03work2.bean.JavaBean;
import com.example.p7day03work2.contract.MainContract;
import com.example.p7day03work2.util.CallBack;
import com.example.p7day03work2.util.NextWorkRetorfit;

public class ModelImp implements MainContract.IModel {
    private MainContract.IPresenter presenter;

    public ModelImp(MainContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getModel(String url, CallBack<T> callback) {
        NextWorkRetorfit.getInstance().getModel(url,callback);
    }
}
