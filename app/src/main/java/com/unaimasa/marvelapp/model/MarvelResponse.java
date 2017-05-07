package com.unaimasa.marvelapp.model;


import com.google.gson.annotations.SerializedName;

public class MarvelResponse<T> {
    @SerializedName("code")
    private int mCode;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("copyright")
    private String mCopyright;

    @SerializedName("attributionText")
    private String mAttributionText;

    @SerializedName("attributionHTML")
    private String mAttributionHtml;

    @SerializedName("etag")
    private String mEtag;

    @SerializedName("data")
    private T mResponse;

    public int getCode() {
        return mCode;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getCopyright() {
        return mCopyright;
    }

    public String getAttributionText() {
        return mAttributionText;
    }

    public String getGetAttributionHtml() {
        return mAttributionHtml;
    }

    public String getEtag() {
        return mEtag;
    }

    public T getResponse() {
        return mResponse;
    }

    @Override public String toString() {
        return "MarvelResponse /n"
                + "code: " + mCode + " /n"
                + "status: " + mStatus + " /n"
                + "copyright: " + mCopyright + " /n"
                + "attributionText: " + mAttributionText + " /n"
                + "attributionHTML: " + mAttributionHtml + " /n"
                + "etag: " + mEtag + " /n"
                + "data: " + mResponse;
    }
}
