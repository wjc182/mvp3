package com.example.p7day03work2.presenter;

import com.example.p7day03work2.base.BaseActrivity;
import com.example.p7day03work2.base.BasePresent;
import com.example.p7day03work2.bean.JavaBean;
import com.example.p7day03work2.contract.MainContract;
import com.example.p7day03work2.model.ModelImp;
import com.example.p7day03work2.util.CallBack;
import com.example.p7day03work2.util.NextWorkRetorfit;

public class PresenterImi extends BasePresent<MainContract.IView> implements MainContract.IPresenter {

    private final ModelImp modelImp;


    public PresenterImi() {
        modelImp = new ModelImp(this);
    }

    @Override
    public void pre() {
        modelImp.getModel("%E7%A6%8F%E5%88%A9/20/3", new CallBack<JavaBean>() {
            @Override
            public void ok(JavaBean javaBean) {
                Views.ok(javaBean);
            }

            @Override
            public void no(String error) {
                Views.no(error);
            }
        });
    }
}
