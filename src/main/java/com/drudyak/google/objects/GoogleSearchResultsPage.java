package com.drudyak.google.objects;

import com.drudyak.google.utils.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Drudyak on 2/18/17.
 */
public class GoogleSearchResultsPage implements IPageObject {

    private static final Logger logger = Logger.getLogger(GoogleHomePage.class);

    private static final String SEARCH_LINKS = "h3.r a";


    @FindBy(css = SEARCH_LINKS)
    private List<WebElement> seachResultLinks;

    private WebDriver driver;

    public GoogleSearchResultsPage() {
        logger.info("Google Search Results page creating");
        this.driver = DriverManager.getChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean checkLinkPresenseByIndex(List<WebElement> elements, String criteria, int index) {
        boolean result = false;

        WebElement targetElement = elements.get(index);

        String elementLink = targetElement.getAttribute("href");

        if (elementLink.contains(criteria)) {
            result = true;

            return result;
        }
        return result;
    }



    public List<WebElement> findAllResultLinks() {
        return seachResultLinks;
    }


    public int getNumberOfElementsFound(List<WebElement> seachResultLinks) {
        return seachResultLinks.size();
    }

    private WebElement getElementWithIndex(List<WebElement> seachResultLinks, int pos) {
        return seachResultLinks.get(pos);
    }

    public void navigateToLinkByPosition(List<WebElement> seachResultLinks, int pos) {
        getElementWithIndex(seachResultLinks, pos).click();
    }

}
