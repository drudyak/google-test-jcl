package com.drudyak.google.business;

import com.drudyak.google.objects.GoogleSearchResultsPage;
import com.drudyak.google.objects.SearchResultWebSitePage;
import com.drudyak.google.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Drudyak on 2/18/17.
 */
public class SearchResultWebSitePageBO implements IPageBO {

    private SearchResultWebSitePage searchResultWebSitePage;
    private GoogleSearchResultsPage googleSearchResultsPage;



    private void verifyWebsiteBodyContainsText(WebDriver driver, String targetText) {
        searchResultWebSitePage = new SearchResultWebSitePage();

        searchResultWebSitePage.waitForLoad(driver);
        Assert.assertTrue(searchResultWebSitePage.checkWebsiteBodyContainsText(targetText), "Text is not present on the page");
    }


    public void checkEveryLink(WebDriver driver, String targetText) {
        googleSearchResultsPage = new GoogleSearchResultsPage();
        List<WebElement> links = googleSearchResultsPage.findAllResultLinks();

        // Tried to use foreach to iterate through "links" but test failed (suggestion - changes in DOM). Found a solution in the internet to use strict position indexes
        for (int pos = 0; pos < googleSearchResultsPage.getNumberOfElementsFound(links); pos++) {

            googleSearchResultsPage.navigateToLinkByPosition(links, pos);
            verifyWebsiteBodyContainsText(driver, targetText);
            searchResultWebSitePage.navigateBack();
        }
    }

}
