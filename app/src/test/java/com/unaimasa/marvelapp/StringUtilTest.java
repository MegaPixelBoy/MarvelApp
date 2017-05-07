package com.unaimasa.marvelapp;


import com.unaimasa.marvelapp.util.StringUtil;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringUtilTest {

    private static final String START_STRING = "Vowing to serve his country any way he could, young Steve Rogers took the super soldier serum to become America's one-man army. Fighting for the red, white and blue for over 60 years, Captain America is the living, breathing symbol of freedom and liberty.";
    private static final String EXPECTED_STRING = "Vowing to serve his country any way he could, young Steve Rogers took the super soldier serum to become America's one-man army.";

    @Test
    public void testSplitScreen() throws Exception {
        assertEquals(EXPECTED_STRING, StringUtil.splitString(START_STRING));
    }
}
