package com.unaimasa.marvelapp;


import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

public class MarvelTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(
            ClassLoader cl, String className, Context context)
            throws InstantiationException,
            IllegalAccessException,
            ClassNotFoundException {
        return super.newApplication(cl, MarvelTestApplication.class.getName(), context);
    }
}