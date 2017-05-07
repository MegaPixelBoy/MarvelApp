package com.unaimasa.marvelapp.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarvelComic {
    @SerializedName("id")
    private String mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("issueNumber")
    private double mIssueNumber;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("thumbnail")
    private MarvelImageInfo mThumbnail;

    @SerializedName("images")
    private List<MarvelImageInfo> mImages;

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public double getIssueNumber() {
        return mIssueNumber;
    }
    public MarvelImageInfo getThumbnail() {
        return mThumbnail;
    }

    public List<MarvelImageInfo> getImages() {
        return mImages;
    }

    @Override public String toString() {
        return("MarvelComic: /n"
                + "Id: " + mId + "/n"
                + "Title: " + mTitle + "/n"
                + "IssueNumber: " + mIssueNumber + "/n"
                + "Description: " + mDescription + "/n"
                + "Thumbnail: " + mThumbnail + "/n"
                + "Images: " + mThumbnail);
    }
}
