package com.unaimasa.marvelapp;


public class MarvelTestApplication extends MarvelApplication {

    protected ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationTestModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }
}
