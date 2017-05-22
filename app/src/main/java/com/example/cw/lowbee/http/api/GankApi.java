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

    @GET("data/Android/500/1")
    Observable<HttpResult<List<Article>>> getGankAndroid();
}
