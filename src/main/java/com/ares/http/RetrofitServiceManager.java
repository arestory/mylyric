package com.ares.http;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 用于管理 retrofit 的 OkHttpClient
 * Created by ares on 2017/4/25.
 */

public class RetrofitServiceManager implements RxActionManager {


    //默认的retrofit
    private Retrofit mDefaultRetrofit;
    private static RetrofitServiceManager sInstance = null;
    private Map<Object, Disposable> maps;

    //保存多个retrofit，用于多种请求
    private Map<String, Retrofit> retrofitList = new HashMap<>();

    public void initHostList(List<String> urlList) {

        retrofitList.clear();
        for (String url : urlList) {
            retrofitList.put(url, createNewRetrofit(url));
        }

    }

    public static  String BASE_URL="https://wenzhi.api.qcloud.com";

    private CompositeDisposable compositeDisposable;

    private RetrofitServiceManager() {
        maps = new HashMap<>();
        compositeDisposable = new CompositeDisposable();
        if (mDefaultRetrofit == null) {

            mDefaultRetrofit = createNewRetrofit(BASE_URL);
        }
    }


    /**
     * 根据baseURL创建一个新的retrofit
     *
     * @param baseUrl
     * @return
     */
    private Retrofit createNewRetrofit(String baseUrl) {


        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.connectTimeout(AppConstants.HTTP.TIME_OUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(AppConstants.HTTP.TIME_OUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(AppConstants.HTTP.TIME_OUT, TimeUnit.SECONDS);
        httpClientBuilder.retryOnConnectionFailure(true);
        httpClientBuilder.addInterceptor(new GlobalParameter());
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置Debug Log模式，上传图片文件时会写入两次，导致出现两次进度显示，所以发布时请注释httpLoggingInterceptor
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        OkHttpClient client = httpClientBuilder.build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }


    public static RetrofitServiceManager getManager() {

        if (sInstance == null) {
            synchronized (RetrofitServiceManager.class) {
                if (sInstance == null) {
                    sInstance = new RetrofitServiceManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * 根据根路径创建接口类
     *
     * @param baseUrl
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(String baseUrl, final Class<T> service) {

        if (!retrofitList.containsKey(baseUrl)) {
            retrofitList.put(baseUrl, createNewRetrofit(baseUrl));
        }
        Retrofit retrofit = retrofitList.get(baseUrl);
        if (retrofit == null) {
            return mDefaultRetrofit.create(service);
        }
        return retrofit.create(service);
    }

    /**
     * 用默认retrofit创建接口类
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(final Class<T> service) {

        return mDefaultRetrofit.create(service);
    }



    @Override
    public void add(Object tag, Disposable disposable) {

        compositeDisposable.add(disposable);
        maps.put(tag, disposable);

    }


    @Override
    public void remove(Object tag) {
        if (!maps.isEmpty()) {
            maps.remove(tag);
            Disposable disposable = maps.get(tag);
            if (disposable != null)
                compositeDisposable.remove(disposable);

        }
    }

    @Override
    public void cancel(Object tag) {

        if (maps.isEmpty()) {
            return;
        }
        Disposable disposable = maps.get(tag);

        if (disposable == null) {
            return;
        }

        if (!disposable.isDisposed()) {
            compositeDisposable.remove(disposable);
            disposable.dispose();
            maps.remove(tag);
        }
    }

    @Override
    public void cancel(Object... tag) {
        if (maps.isEmpty()) {
            return;
        }

        for (Object o : tag) {
            Disposable disposable = maps.get(o);
            if (disposable != null && !disposable.isDisposed()) {
                compositeDisposable.remove(disposable);
                disposable.dispose();
                maps.remove(o);
            }
        }

    }

    @Override
    public void cancelAll() {
        if (maps.isEmpty()) {
            return;
        }
        Set<Object> keys = maps.keySet();
        for (Object apiKey : keys) {
            cancel(apiKey);
        }

    }
}
