package com.unaimasa.marvelapp.util;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class NavigationUtil {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void showFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                               @NonNull Fragment fragment,
                                               int frameId,
                                               @NonNull String frameTag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment, frameTag);
        transaction.commitNow();
    }

}
