package com.epam.automation.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSingleton {

    private static WebDriver driver;
    private static final Logger log = LogManager.getRootLogger();


    private DriverSingleton(){}

    public static WebDriver getDriver(){
        try {
            if (null == driver) {
                switch (System.getProperty("browser")) {
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "ie":
                        driver = new InternetExplorerDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    default:
                        driver = new ChromeDriver();

                }
                driver.manage().window().maximize();
            }
        } catch (Exception e) {
            log.error("Failed to initialize the driver: {}", e.getLocalizedMessage());
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null) driver.quit();
        driver = null;
    }
}
