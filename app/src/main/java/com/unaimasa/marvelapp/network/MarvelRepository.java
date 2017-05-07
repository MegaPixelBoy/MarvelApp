package com.unaimasa.marvelapp.network;


import com.unaimasa.marvelapp.model.MarvelCharacter;
import com.unaimasa.marvelapp.model.MarvelCharacterData;
import com.unaimasa.marvelapp.model.MarvelComicData;
import com.unaimasa.marvelapp.model.MarvelResponse;
import com.unaimasa.marvelapp.util.SecurityUtil;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;

public class MarvelRepository {

    public static final String MARVEL_PUBLIC_KEY = "0990cd31700f807b8b54609750af08ad";
    public static final String MARVEL_PRIVATE_KEY = "b640c9b82256fbacf06d5e177c21887206d6727c";

    @Inject
    MarvelAPI mMarvelAPI;

    public MarvelRepository() {
    }

    public Observable<MarvelResponse<MarvelCharacterData>> getMarvelCharacterObservable(String characterId) {
        String timestamp = SecurityUtil.getTimeStamp();
        String hashSignature = SecurityUtil.md5(timestamp + MARVEL_PRIVATE_KEY+ MARVEL_PUBLIC_KEY);
        return mMarvelAPI.getMarvelCharacter(characterId, timestamp, MARVEL_PUBLIC_KEY, hashSignature);
    }

    public Observable<MarvelResponse<MarvelComicData>> getMarvelCharacterComicsObservable(String characterId, int offset) {
        String os = String.valueOf(offset);
        String timestamp = SecurityUtil.getTimeStamp();
        String hashSignature = SecurityUtil.md5(timestamp + MARVEL_PRIVATE_KEY+ MARVEL_PUBLIC_KEY);
        return mMarvelAPI.getMarvelCharacterComics(characterId, os, timestamp, MARVEL_PUBLIC_KEY, hashSignature);
    }

}
