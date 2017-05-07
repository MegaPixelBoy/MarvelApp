package com.unaimasa.marvelapp.model;


import java.util.List;

public class MarvelCharacterData extends MarvelCollection<MarvelCharacter> {

    public List<MarvelCharacter> getCharacters() {
        return getResults();
    }

    @Override public String toString() {
        return "CharactersDto /n"
                + "offset: " + getOffset() + "/n"
                + "limit: " + getLimit() + "/n"
                + "total: " + getTotal() + "/n"
                + "count: " + getCount() + "/n"
                + "characters: " + getCharacters().toString();
    }

}
