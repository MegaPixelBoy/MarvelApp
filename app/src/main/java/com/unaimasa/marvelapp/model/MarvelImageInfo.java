package com.unaimasa.marvelapp.model;


import com.google.gson.annotations.SerializedName;

public class MarvelImageInfo {

    @SerializedName("path")
    private String mPath;

    @SerializedName("extension")
    private String mExtension;

    @Override
    public String toString() {
        return("MarvelCharacter: /n"
                + "Path: " + mPath + "/n"
                + "Extension: " + mExtension);
    }

    public String getPath() {
        return mPath;
    }

    public String getExtension() {
        return mExtension;
    }
}
