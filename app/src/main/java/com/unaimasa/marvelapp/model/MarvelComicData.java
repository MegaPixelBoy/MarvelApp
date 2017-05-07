package com.unaimasa.marvelapp.model;


import java.util.List;

public class MarvelComicData extends MarvelCollection<MarvelComic> {

    public List<MarvelComic> getComics() {
        return getResults();
    }

    @Override
    public String toString() {
        return "CharactersDto /n"
                + "offset: " + getOffset() + "/n"
                + "limit: " + getLimit() + "/n"
                + "total: " + getTotal() + "/n"
                + "count: " + getCount() + "/n"
                + "characters: " + getComics().toString();
    }
}
