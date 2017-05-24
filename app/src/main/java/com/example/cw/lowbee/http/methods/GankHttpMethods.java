package com.example.cw.lowbee.http.methods;

import com.example.cw.lowbee.App;
import com.example.cw.lowbee.http.api.GankApi;
import com.example.cw.lowbee.model.Article;
import com.example.cw.lowbee.model.HttpResult;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by cw on 2017/5/22.
 */

public class GankHttpMethods {
    public static final String BASE_URL = "http://gank.io/api/";
    private static final int DEFAULT_TIMEOUT = 5;
    private static volatile GankHttpMethods instance;

    private Retrofit retrofit;
    private GankApi api;

    public static GankHttpMethods getInstance(){
        if(instance == null){
            synchronized(GankHttpMethods.class){
                if(instance == null){
                    instance = new GankHttpMethods();
                }
            }
        }
        return instance;
    }

    private GankHttpMethods(){
        //Log
        HttpLoggingInterceptor interceptorLog = new HttpLoggingInterceptor();
        if(App.IsRelease){
            interceptorLog.setLevel(HttpLoggingInterceptor.Level.NONE);
        }else{
            interceptorLog.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(interceptorLog);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(ResponseConvertFactory.create())//for 对http请求结果进行统一的预处理 GosnResponseBodyConvert
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        api = retrofit.create(GankApi.class);
    }

    //统一回调到View层
    private <T> void toSubscribe(Observable<T> observable, Observer<T> observer){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
        @Override
        public T call(HttpResult<T> httpResult) {
            if ("true".equals(httpResult.getError())) {
                throw new ApiException(100);
            }
            return httpResult.getSubjects();
        }
    }

    /**
     * 获取干货前200条ALL类型数据
     * @param observer
     */
    public void getGankAllArticle(Observer<List<Article>> observer){
        Observable observable = api.getGankAll().map(new HttpResultFunc<List<Article>>());

        toSubscribe(observable, observer);
    }

    /**
     * 获取干货前100条Android类型数据
     * @param observer
     */
    public void getGankAndroidArticle(Observer<List<Article>> observer){
        Observable observable = api.getGankAndroid().map(new HttpResultFunc<List<Article>>());

        toSubscribe(observable, observer);
    }

    /**
     * 获取干货前100条IOS类型数据
     * @param observer
     */
    public void getGankIOSArticle(Observer<List<Article>> observer){
        Observable observable = api.getGankIOS().map(new HttpResultFunc<List<Article>>());

        toSubscribe(observable, observer);
    }
}
