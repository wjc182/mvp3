package com.example.p7day03work2.base;

public class BasePresent<P extends BaseView>{
    public P Views;

    public void attach(P p){
        Views=p;
    }
}
