package com.unaimasa.marvelapp.util;


import com.unaimasa.marvelapp.model.MarvelImageInfo;

public class ImageUtil {

    private static final String IMAGE_DOT = ".";
    private static final String IMAGE_SEPARATOR = "/";
    private static final String IMAGE_PORTRAIT_MEDIUM = "portrait_medium";
    private static final String IMAGE_PORTRAIT_INCREDIBLE = "portrait_incredible";

    public static String getMarvelImageProtraitMedium(MarvelImageInfo marvelImageInfo){
        String path = marvelImageInfo.getPath();
        String extension = marvelImageInfo.getExtension();
        return path + IMAGE_SEPARATOR + IMAGE_PORTRAIT_MEDIUM + IMAGE_DOT + extension;
    }

    public static String getMarvelImagePortraitIncredible(MarvelImageInfo marvelImageInfo){
        String path = marvelImageInfo.getPath();
        String extension = marvelImageInfo.getExtension();
        return path + IMAGE_SEPARATOR + IMAGE_PORTRAIT_INCREDIBLE + IMAGE_DOT + extension;
    }
}
