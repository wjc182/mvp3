package com.example.p7day03work2.util;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ResponseBody> get(@Url String url);
}
