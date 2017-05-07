package com.unaimasa.marvelapp;

import com.unaimasa.marvelapp.model.MarvelImageInfo;
import com.unaimasa.marvelapp.util.ImageUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ImageUtilTest {

    private static  final String EXPECTED_IMAGE_PORTRAIT_MEDIUM = "http://i.annihil.us/u/prod/marvel/i/mg/3/50/537ba56d31087/portrait_medium.jpg";
    private static  final String EXPECTED_IMAGE_PORTRAIT_INCREDIBLE = "http://i.annihil.us/u/prod/marvel/i/mg/3/50/537ba56d31087/portrait_incredible.jpg";

    @Mock
    MarvelImageInfo marvelImageInfo;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        when(marvelImageInfo.getPath()).thenReturn("http://i.annihil.us/u/prod/marvel/i/mg/3/50/537ba56d31087");
        when(marvelImageInfo.getExtension()).thenReturn("jpg");
    }

    @Test
    public void testGetMarvelImagePortraitMedium() throws Exception {
        assertEquals(EXPECTED_IMAGE_PORTRAIT_MEDIUM, ImageUtil.getMarvelImageProtraitMedium(marvelImageInfo));
    }

    @Test
    public void testGetMarvelImagePortraitIncredible() throws Exception {
        assertEquals(EXPECTED_IMAGE_PORTRAIT_INCREDIBLE, ImageUtil.getMarvelImagePortraitIncredible(marvelImageInfo));
    }
}