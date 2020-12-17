package com.example.p7day03work2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.p7day03work2.R;
import com.example.p7day03work2.adapter.MyAdafel;
import com.example.p7day03work2.base.BaseActrivity;
import com.example.p7day03work2.bean.JavaBean;
import com.example.p7day03work2.contract.MainContract;
import com.example.p7day03work2.presenter.PresenterImi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActrivity<PresenterImi> implements MainContract.IView {

   private RecyclerView rec;
    private ArrayList<JavaBean.ResultsDTO> list;
    private MyAdafel myAdafel;

    @Override
    protected void initView() {
        rec=findViewById(R.id.rew_main);
        rec.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdafel = new MyAdafel(this, list);
        rec.setAdapter(myAdafel);
    }

    @Override
    protected void initData() {
        presenter.pre();
    }

    @Override
    protected int getDataId() {
        return R.layout.activity_main;
    }

    @Override
    protected PresenterImi getPresenter() {
        return new PresenterImi();
    }

    @Override
    public void ok(JavaBean javaBean) {
        List<JavaBean.ResultsDTO> results = javaBean.getResults();
        list.addAll(results);
        myAdafel.notifyDataSetChanged();
    }

    @Override
    public void no(String error) {

    }
}