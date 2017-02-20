package com.drudyak.google;

import com.drudyak.google.business.GoogleHomePageBO;
import com.drudyak.google.business.GoogleSearchResultsPageBO;
import com.drudyak.google.business.SearchResultWebSitePageBO;
import com.drudyak.google.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Drudyak on 2/19/17.
 */
public class GoogleSearchJCLClassTest {

    private static final String SEARCH_QUERY = "Juniors Club Lviv";
    private static final String WEBSITE_SEARCH_WORD = "Juniors Club Lviv";
    private static final String VERIFICATION_CRITERIA = "https://www.facebook.com/";


    private GoogleHomePageBO googleHomePageBO;
    private GoogleSearchResultsPageBO googleSearchResultsPageBO;
    private SearchResultWebSitePageBO searchResultWebSitePageBO;

    WebDriver driver;

    @BeforeClass
    public void initDriver() {
        driver = DriverManager.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterMethod() {
        DriverManager.closeDriver();
    }


    @Test
    public void tsearchGoogleTest() {
        googleHomePageBO = new GoogleHomePageBO();
        googleHomePageBO.performGoogleSearch(SEARCH_QUERY);

        googleSearchResultsPageBO = new GoogleSearchResultsPageBO();
        googleSearchResultsPageBO.verifyLinkPresenceByIndex(VERIFICATION_CRITERIA, 0);

        searchResultWebSitePageBO = new SearchResultWebSitePageBO();
        searchResultWebSitePageBO.checkEveryLink(driver, WEBSITE_SEARCH_WORD);
    }

}
