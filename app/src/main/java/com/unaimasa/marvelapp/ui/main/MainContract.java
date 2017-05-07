package com.unaimasa.marvelapp.ui.main;


import com.unaimasa.marvelapp.model.MarvelCharacter;
import com.unaimasa.marvelapp.model.MarvelComic;
import com.unaimasa.marvelapp.ui.BasePresenter;
import com.unaimasa.marvelapp.ui.BaseView;

import java.util.List;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void startLoading();

        void showCharacterInfo(MarvelCharacter marvelCharacter);

        void showCharacterComics(List<MarvelComic> marvelComics);

        void showErrorToast();
    }

    interface Presenter extends BasePresenter {

        void populateCharacterInfo(String characterId);

        void populateCharacterComicList(String characterId);

    }
}
