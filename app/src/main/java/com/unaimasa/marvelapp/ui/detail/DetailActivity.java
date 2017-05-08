package com.unaimasa.marvelapp.ui.detail;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unaimasa.marvelapp.R;
import com.unaimasa.marvelapp.util.NavigationUtil;

public class DetailActivity extends AppCompatActivity {

    public static final String ACTIVITY_TAG = DetailActivity.class.getSimpleName();

    private DetailContract.Presenter mDetailPresenter;
    private String mComicTitle;
    private String mComicDescription;
    private String mComicImageUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailFragment detailFragment =
                (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fl_detail_content_frame);

        if (detailFragment == null) {
            // Create the fragment
            detailFragment = DetailFragment.newInstance();
            NavigationUtil.showFragmentToActivity(
                    getSupportFragmentManager(), detailFragment, R.id.fl_detail_content_frame, detailFragment.FRAGMENT_TAG);
        }

        // Create the presenter
        mDetailPresenter = new DetailPresenter(detailFragment);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            mComicTitle = bundle.getString("marvel_comic_title");
            mComicDescription = bundle.getString("marvel_comic_description");
            mComicImageUrl = bundle.getString("marvel_comic_image_url");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDetailPresenter.fillInfo(mComicTitle, mComicDescription, mComicImageUrl);
    }
}
