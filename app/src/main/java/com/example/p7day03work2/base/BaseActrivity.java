package com.example.p7day03work2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActrivity<T extends BasePresent> extends AppCompatActivity implements BaseView{
  protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getDataId());
        if(presenter==null){
            presenter=getPresenter();
            presenter.attach(this);
        }
        initData();
        initView();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getDataId();

    protected abstract T getPresenter();
}
