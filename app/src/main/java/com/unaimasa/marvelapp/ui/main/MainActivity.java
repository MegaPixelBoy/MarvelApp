package com.unaimasa.marvelapp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.unaimasa.marvelapp.ApplicationComponent;
import com.unaimasa.marvelapp.MarvelApplication;
import com.unaimasa.marvelapp.R;
import com.unaimasa.marvelapp.util.NavigationUtil;

public class MainActivity extends AppCompatActivity {

    public static final String ACTIVITY_TAG = MainActivity.class.getSimpleName();

    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Dagger 2 Injection
        ApplicationComponent applicationComponent = ((MarvelApplication) getApplication()).getApplicationComponent();

        MainFragment mainFragment =
                (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fl_main_content_frame);

        if (mainFragment == null) {
            // Create the fragment
            mainFragment = MainFragment.newInstance();
            NavigationUtil.showFragmentToActivity(
                    getSupportFragmentManager(), mainFragment, R.id.fl_main_content_frame, mainFragment.FRAGMENT_TAG);
        }

        // Create the presenter
        mMainPresenter = new MainPresenter(mainFragment, applicationComponent);
    }
}
