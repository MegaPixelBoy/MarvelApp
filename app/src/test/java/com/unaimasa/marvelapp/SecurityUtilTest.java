package com.unaimasa.marvelapp;


import com.unaimasa.marvelapp.util.SecurityUtil;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SecurityUtilTest {

    private static final String START_STRING = "String to md5";
    private static final String EXPECTED_STRING = "225a7e5385a7c30b26194d8f8c8043f2";

    @Test
    public void textMD5() {
        assertEquals(EXPECTED_STRING, SecurityUtil.md5(START_STRING));
    }

}
