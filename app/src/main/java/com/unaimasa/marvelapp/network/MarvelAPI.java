package com.unaimasa.marvelapp.network;


import com.unaimasa.marvelapp.model.MarvelCharacter;
import com.unaimasa.marvelapp.model.MarvelCharacterData;
import com.unaimasa.marvelapp.model.MarvelComicData;
import com.unaimasa.marvelapp.model.MarvelResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelAPI {

    @GET("/v1/public/characters/{characterId}")
    Observable<MarvelResponse<MarvelCharacterData>> getMarvelCharacter(@Path("characterId") String characterId,
                                                                       @Query("ts") String timestamp,
                                                                       @Query("apikey") String apikey,
                                                                       @Query("hash") String hashSignature);

    @GET("/v1/public/characters/{characterId}/comics")
    Observable<MarvelResponse<MarvelComicData>> getMarvelCharacterComics(@Path("characterId") String characterId,
                                                                         @Query("offset") String offset,
                                                                         @Query("ts") String timestamp,
                                                                         @Query("apikey") String apikey,
                                                                         @Query("hash") String hashSignature);

}
