package com.drudyak.google.business;

import com.drudyak.google.objects.GoogleHomePage;

/**
 * Created by Drudyak on 2/18/17.
 */
public class GoogleHomePageBO implements IPageBO {

    private GoogleHomePage googleHomePage;

    public void performGoogleSearch(String query) {
        googleHomePage = new GoogleHomePage();

        googleHomePage.navigateGoogleHomePage();
        googleHomePage.performSearchWithQuery(query);
    }
}
