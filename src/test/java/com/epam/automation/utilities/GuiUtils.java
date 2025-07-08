package com.epam.automation.utilities;

import com.epam.automation.pages.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.automation.pages.AbstractPage.WAIT_TIMEOUT_SECONDS;

public class GuiUtils {
    private final WebDriver driver;
    private final static Logger log = LogManager.getRootLogger();

    public GuiUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void singleClick(WebElement element) {
        try {
            if (waitUntilElementPresent(element)) {
                highlightElement(element);
                element.click();
            }
        } catch (Exception e) {
            log.error("There was an error while clicking the element.\n{}", e.getLocalizedMessage());
        }
    }

    public void fillInput(WebElement element, String text) {
        try {
            if (waitUntilElementPresent(element)) {
                highlightElement(element);
                element.sendKeys(text);
            }
        } catch (Exception e) {
            log.error("There was an error while filling the element.\n{}", e.getMessage());
        }
    }

    public boolean waitUntilElementPresent(WebElement element) {
        try {
            var wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            log.error("There was an error while waiting for the element.\n{}", e.getMessage());
            return false;
        }
    }

    public void highlightElement(WebElement element) {
        try {
            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            }
        } catch (Exception e) {
            log.error("There was an error while highlighting the element.\n{}", e.getMessage());
        }
    }
}
