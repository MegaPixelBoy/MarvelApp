package com.unaimasa.marvelapp.ui.main;


import android.support.annotation.NonNull;

import com.unaimasa.marvelapp.ApplicationComponent;
import com.unaimasa.marvelapp.model.MarvelCharacterData;
import com.unaimasa.marvelapp.model.MarvelComicData;
import com.unaimasa.marvelapp.model.MarvelResponse;
import com.unaimasa.marvelapp.network.MarvelRepository;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainPresenter implements MainContract.Presenter {

    private static final String PRESENTER_TAG = "_main_presenter";

    private final MainContract.View mMainContractView;

    private int mOffset = 0;

    @Inject
    MarvelRepository mMarvelRepository;

    public MainPresenter(@NonNull MainContract.View mainContractView, ApplicationComponent applicationComponent) {
        mMainContractView = checkNotNull(mainContractView, "MainContract.View cannot be null!");
        mMainContractView.setPresenter(this);

        // Dagger 2 Injection
        applicationComponent.inject(this);
    }

    // ----- Main Presenter Methods ----- //
    private void fetchCharacterInfo(final String characterId) {
        Observable<MarvelResponse<MarvelCharacterData>> observableMarvelCharacter = mMarvelRepository
                .getMarvelCharacterObservable(characterId);

        observableMarvelCharacter.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<MarvelResponse<MarvelCharacterData>>(){

                    @Override
                    public void onNext(MarvelResponse<MarvelCharacterData> value) {
                        switch (value.getCode()) {
                            case 200:
                                mMainContractView.showCharacterInfo(value.getResponse().getCharacters().get(0));
                                break;
                            default:
                                mMainContractView.showErrorToast();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMainContractView.showErrorToast();
                    }

                    @Override
                    public void onComplete() {
                        fetchCharacterComicsInfo(characterId);
                    }
                });
    }

    private void fetchCharacterComicsInfo(String characterId) {
        Observable<MarvelResponse<MarvelComicData>> observableMarvelCharacterComics = mMarvelRepository
                .getMarvelCharacterComicsObservable(characterId, mOffset);

        observableMarvelCharacterComics.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<MarvelResponse<MarvelComicData>>(){

                    @Override
                    public void onNext(MarvelResponse<MarvelComicData> value) {
                        switch (value.getCode()) {
                            case 200:
                                mMainContractView.showCharacterComics(value.getResponse().getComics());
                                mOffset = mOffset + 20;
                                break;
                            default:
                                mMainContractView.showErrorToast();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMainContractView.showErrorToast();
                    }

                    @Override
                    public void onComplete() {
                        mMainContractView.startLoading();
                    }
                });
    }

    // ----- Main Contract Presenter Methods ----- //
    @Override
    public void populateCharacterInfo(String characterId) {
        fetchCharacterInfo(characterId);
    }

    @Override
    public void populateCharacterComicList(String characterId) {
        fetchCharacterComicsInfo(characterId);
    }
}
