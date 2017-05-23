package com.example.cw.lowbee.http.api;

import com.example.cw.lowbee.model.Article;
import com.example.cw.lowbee.model.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by cw on 2017/5/22.
 */

public interface GankApi {

    @GET("data/all/500/1")
    Observable<HttpResult<List<Article>>> getGankAll();

    @GET("data/Android/100/1")
    Observable<HttpResult<List<Article>>> getGankAndroid();

    @GET("data/iOS/100/1")
    Observable<HttpResult<List<Article>>> getGankIOS();
}
