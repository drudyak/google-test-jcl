package com.drudyak.google.objects;

import com.drudyak.google.utils.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Drudyak on 2/18/17.
 */
public class GoogleHomePage implements IPageObject {
    private static final Logger logger = Logger.getLogger(GoogleHomePage.class);

    private static final String GOOGLE_HOME_PAGE_URL = "http://google.com";
    private static final String SEARCH_FIELD = ".//*[@name=\"q\"]";
    private static final String SEARCH_BUTTON = ".sbico-c";


    @FindBy(xpath = SEARCH_FIELD)
    private WebElement seachField;
    @FindBy(css = SEARCH_BUTTON)
    private WebElement searchButton;

    private WebDriver driver;

    public GoogleHomePage() {
        logger.info("Google Home page creating");
        this.driver = DriverManager.getChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void performSearchWithQuery(String searchQuery) {
        seachField.sendKeys(searchQuery);
        seachField.submit();

    }

    public void navigateGoogleHomePage(){
        this.driver = DriverManager.getChromeDriver();
        driver.get(GOOGLE_HOME_PAGE_URL);
    }

}


