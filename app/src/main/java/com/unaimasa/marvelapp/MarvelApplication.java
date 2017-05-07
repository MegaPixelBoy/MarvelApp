package com.unaimasa.marvelapp;


import android.app.Application;

public class MarvelApplication extends Application {

    protected ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }
}
