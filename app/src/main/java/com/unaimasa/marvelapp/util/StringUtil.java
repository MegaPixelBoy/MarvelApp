package com.unaimasa.marvelapp.util;


public class StringUtil {

    public static String splitString(String string) {
        String[] fn = string.split("\\.");
        return fn[0] + ".";
    }

}
