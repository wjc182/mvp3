package com.example.p7day03work2.util;

import com.example.p7day03work2.contract.MainContract;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class NextWorkRetorfit implements MainContract.IModel {
    private static volatile NextWorkRetorfit nextWorkRetorfit;
    private final ApiService apiService;

    public NextWorkRetorfit() {
        apiService = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(URLConnect.baseUrl)
                .build()
                .create(ApiService.class);
    }
    public static NextWorkRetorfit getInstance(){
        if (nextWorkRetorfit==null)
        synchronized (NextWorkRetorfit.class){
            if(nextWorkRetorfit==null){
                nextWorkRetorfit=new NextWorkRetorfit();
            }
        }
        return nextWorkRetorfit;
    }

    @Override
    public <T> void getModel(String url, CallBack<T> callback) {
        apiService.get(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t=actualTypeArguments[0];

                            Gson gson = new Gson();
                            T json = gson.fromJson(string,t);

                            callback.ok(json);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.no("网络异常："+e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
