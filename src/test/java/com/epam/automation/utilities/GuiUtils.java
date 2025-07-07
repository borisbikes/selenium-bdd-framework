package com.epam.automation.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuiUtils {
    private final WebDriver driver;
    private static Logger log = LogManager.getRootLogger();

    public GuiUtils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean singleClick(WebElement element) {
        try {
            if (!waitUntilElementPresent(element))
                return false;
            else
                highlightElement(element);
            element.click();
            return true;
        } catch (Exception e) {
            log.error("There was an error while clicking the element");
            return false;
        }


    }

    public boolean waitUntilElementPresent(WebElement element) {
        try {
            var wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
            wait.until((WebDriver driver) -> (WebElement) ExpectedConditions.visibilityOf(element).apply(driver));
            wait.until((WebDriver driver) -> (WebElement) ExpectedConditions.elementToBeClickable(element).apply(driver));
            return true;
        } catch (Exception e) {
            log.error("There was an error while waiting for the element");
            return false;
        }
    }

    public void highlightElement(WebElement element) {
        try {
            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            }
        } catch (Exception e) {
            log.error("There was an error while highlighting the element.");
        }
    }
}
