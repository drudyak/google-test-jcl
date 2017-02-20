package com.drudyak.google.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Denys_Rudiak on 2/17/2017.
 */
public class DriverManager {

    private static final Logger logger = Logger.getLogger(DriverManager.class);

    private static WebDriver instance;

    // Requires editing for your current chromedriver path
    private static final String WIN_WEBDRIVER_PATH = "C:\\Users\\Denys_Rudiak\\IdeaProjects\\google-test-jcl\\src\\test\\resources\\chromedriver.exe";
    private static final String OSX_WEBDRIVER_PATH = "/Users/Drudyak/IdeaProjects/googletestortnec/src/test/resources/chromedriver";
    private static final String WEBDRIVER_TYPE = "webdriver.chrome.driver";


    private DriverManager() {
    }


    // Chose singleton method for WebDriver
    public static WebDriver getChromeDriver() {

        String webdriverPath;

        if (System.getProperty("os.name").contains("Windows")) {
            webdriverPath = WIN_WEBDRIVER_PATH;
        } else {
            webdriverPath = OSX_WEBDRIVER_PATH;
        }

        if (instance == null) {
            System.setProperty(WEBDRIVER_TYPE, webdriverPath);
            instance = new ChromeDriver();
            logger.info("new instance of ChromeDriver created");
        }
        return instance;

    }

    public static void closeDriver() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }

}
