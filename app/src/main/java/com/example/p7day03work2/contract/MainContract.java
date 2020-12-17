package com.example.p7day03work2.contract;

import com.example.p7day03work2.base.BasePresent;
import com.example.p7day03work2.base.BaseView;
import com.example.p7day03work2.bean.JavaBean;
import com.example.p7day03work2.util.CallBack;

import javax.security.auth.callback.Callback;

public class MainContract {
    public interface IModel{
     <T> void getModel(String url, CallBack<T> callback);
    }
    public interface IPresenter{
      void pre();
    }

    public interface IView extends BaseView {
        void ok(JavaBean javaBean);

        void no(String error);

    }
}
