package com.unaimasa.marvelapp.ui.detail;


import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class DetailPresenter implements DetailContract.Presenter {

    private static final String PRESENTER_TAG = "_main_presenter";

    private final DetailContract.View mDetailContractView;

    public DetailPresenter(@NonNull DetailContract.View mainContractView) {
        mDetailContractView = checkNotNull(mainContractView, "DetailContract.View cannot be null!");
        mDetailContractView.setPresenter(this);
    }

    // ----- Detail Contract Presenter Methods ----- //
    @Override
    public void fillInfo(String title, String description, String thumbnail) {
       mDetailContractView.setComicInformation(title, description, thumbnail);
    }
}
