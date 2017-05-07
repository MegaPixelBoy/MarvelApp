package com.unaimasa.marvelapp.ui.detail;

import com.unaimasa.marvelapp.ui.BasePresenter;
import com.unaimasa.marvelapp.ui.BaseView;

public interface DetailContract {

    interface View extends BaseView<DetailContract.Presenter> {

        void setComicInformation(String title, String description, String thumbnail);

    }

    interface Presenter extends BasePresenter {

        void fillInfo(String title, String description, String thumbnail);

    }
}
