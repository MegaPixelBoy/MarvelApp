package com.unaimasa.marvelapp.model;


import com.google.gson.annotations.SerializedName;

public class MarvelCharacter {

    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("thumbnail")
    private MarvelImageInfo mThumbnail;

    @Override
    public String toString() {
        return("MarvelCharacter: /n"
                + "Id: " + mId + "/n"
                + "Name: " + mName + "/n"
                + "Description: " + mDescription + "/n"
                + "Thumbnail: " + mThumbnail);
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public MarvelImageInfo getThumbnail() {
        return mThumbnail;
    }
}
