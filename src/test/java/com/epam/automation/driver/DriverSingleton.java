package com.epam.automation.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;
    private static Logger log = LogManager.getRootLogger();


    private DriverSingleton(){}

    public static WebDriver getDriver(){
        try {
            if (null == driver) {
                switch (System.getProperty("browser")) {
                    case "firefox": {
                        driver = new FirefoxDriver();
                    }
                    default: {
                        driver = new ChromeDriver();
                    }
                }
                driver.manage().window().maximize();
            }
        } catch (Exception e) {
            log.error("Failed to initialize the driver: " + e.getLocalizedMessage());
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null) driver.quit();
        driver = null;
    }
}
