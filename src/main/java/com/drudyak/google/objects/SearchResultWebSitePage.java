package com.drudyak.google.objects;

import com.drudyak.google.utils.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Drudyak on 2/18/17.
 */
public class SearchResultWebSitePage implements IPageObject {

    private static final Logger logger = Logger.getLogger(SearchResultWebSitePage.class);

    @FindBy(tagName = "body")
    private WebElement websiteBody;

    private WebDriver driver;

    public SearchResultWebSitePage() {
        logger.info("Search Results page creating");
        this.driver = DriverManager.getChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean checkWebsiteBodyContainsText(String targetText) {
        boolean result;

        driver = DriverManager.getChromeDriver();
        String body = driver.getPageSource();

        result = body.contains(targetText);

        return result;
    }


    public void navigateBack() {
        driver = DriverManager.getChromeDriver();
        driver.navigate().back();
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
