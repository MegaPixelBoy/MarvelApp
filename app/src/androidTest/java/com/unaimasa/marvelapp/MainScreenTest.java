package com.unaimasa.marvelapp;


import android.support.design.widget.CollapsingToolbarLayout;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;

import com.jakewharton.espresso.OkHttp3IdlingResource;
import com.unaimasa.marvelapp.ui.main.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import okhttp3.OkHttpClient;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class MainScreenTest {

    public static final String CHARACTER_NAME = "Captain America";
    public static final String CHARACTER_DESCRIPTION = "Vowing to serve his country any way he could, young Steve Rogers took the super soldier serum to become America's one-man army.";
    public static final String COMIC_TITLE = "Secret Empire (2017) #1";

    private IdlingResource mIdlingResource;

    @Rule
    public ActivityTestRule<MainActivity>
            mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        // Idling Resources
        MarvelApplication marvelApplication = (MarvelApplication) mActivityRule.getActivity().getApplication();
        ApplicationComponent applicationComponent = marvelApplication.getApplicationComponent();
        OkHttpClient okHttpClient = applicationComponent.okHttpClient();
        mIdlingResource = OkHttp3IdlingResource.create("OkHttp", okHttpClient);

        Espresso.registerIdlingResources(mIdlingResource);

    }

    /**
     * Given Home Screen With Internet Connection
     * When Recycler View Shown
     * Then First User Correctly Shown
     */
    @Test
    public void testGivenMainScreenWithInternetConnectionWhenShownThenCharacterCorrectlyShown() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(isAssignableFrom(CollapsingToolbarLayout.class)).check(matches(withCollapsibleToolbarTitle(is(CHARACTER_NAME))));
        onView(withId(R.id.tv_character_description)).check(matches(withText(CHARACTER_DESCRIPTION)));

        onView(withId(R.id.rv_character_comics)).check(matches(hasDescendant(withText(COMIC_TITLE))));

        onView(withId(R.id.pb_load_main_info)).check(matches(not(isDisplayed())));

    }

    @After
    public void tearDown() {
        Espresso.unregisterIdlingResources(mIdlingResource);
    }

    public static Matcher<Object> withCollapsibleToolbarTitle(final Matcher<String> textMatcher) {
        return new BoundedMatcher<Object, CollapsingToolbarLayout>(CollapsingToolbarLayout.class) {
            @Override public void describeTo(Description description) {
                description.appendText("with toolbar title: ");
                textMatcher.describeTo(description);
            }
            @Override protected boolean matchesSafely(CollapsingToolbarLayout toolbarLayout) {
                return textMatcher.matches(toolbarLayout.getTitle());
            }
        };
    }
}
