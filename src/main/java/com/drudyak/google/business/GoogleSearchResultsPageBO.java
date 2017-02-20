package com.drudyak.google.business;

import com.drudyak.google.objects.GoogleSearchResultsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Drudyak on 2/18/17.
 */
public class GoogleSearchResultsPageBO implements IPageBO {

    GoogleSearchResultsPage searchResultsPage;


    // Verifying if target link has required position
    public void verifyLinkPresenceByIndex(String criteria, int index) {
        searchResultsPage = new GoogleSearchResultsPage();
        List<WebElement> links;

        links = searchResultsPage.findAllResultLinks();
        Assert.assertTrue(searchResultsPage.checkLinkPresenseByIndex(links, criteria, index), "Link index is not " + index);
    }

}
