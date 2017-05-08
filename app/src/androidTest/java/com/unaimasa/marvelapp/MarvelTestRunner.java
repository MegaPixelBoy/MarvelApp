package com.unaimasa.marvelapp;


import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * This Runner has been implemented because I had to use MarvelTestApplication instead
 * MarvelApplication class during Espresso Test for Dagger 2
 */
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