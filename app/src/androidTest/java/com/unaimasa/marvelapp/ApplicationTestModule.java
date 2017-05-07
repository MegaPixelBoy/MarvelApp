package com.unaimasa.marvelapp;


import android.content.Context;

import com.unaimasa.marvelapp.network.MarvelAPI;
import com.unaimasa.marvelapp.network.MarvelRepository;

import javax.inject.Singleton;

import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationTestModule extends ApplicationModule {

    public static final String BASE_URL = "http://gateway.marvel.com";

    private MarvelApplication mApplication;

    public ApplicationTestModule(MarvelApplication application) {
        super(application);
        mApplication = application;
    }

    private ApplicationComponent getApplicationComponent() {
        return mApplication.getApplicationComponent();
    }

    @Provides
    @Singleton
    Context providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient() {
        Interceptor interceptor = new MarvelInterceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        return client;
    }

    @Provides
    @Singleton
    String providesBaseUrl() { return BASE_URL; }

    @Provides
    @Singleton
    MarvelAPI providesBaseProjectAPI(OkHttpClient okHttpClient, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MarvelAPI.class);
    }

    @Provides
    @Singleton
    MarvelRepository providesMarvelRepository() {
        MarvelRepository marvelRepository = new MarvelRepository();

        ApplicationComponent applicationComponent = getApplicationComponent();
        applicationComponent.inject(marvelRepository);

        return marvelRepository;
    }
}
