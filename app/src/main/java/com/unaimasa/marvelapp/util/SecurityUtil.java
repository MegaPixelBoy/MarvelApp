package com.unaimasa.marvelapp.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;

public class SecurityUtil {

    public static final String getTimeStamp() {
        try {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            long timeStamp = calendar.getTimeInMillis() / 1000;
            return String.valueOf(timeStamp);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final String md5(String in) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(in.getBytes());
            byte[] a = digest.digest();
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 0x0f, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
