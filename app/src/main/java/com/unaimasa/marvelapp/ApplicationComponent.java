package com.unaimasa.marvelapp;


import com.unaimasa.marvelapp.network.MarvelRepository;
import com.unaimasa.marvelapp.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MainPresenter mainPresenter);

    void inject(MarvelRepository marvelRepository);

    // Expose the dependencies
    OkHttpClient okHttpClient();
}
