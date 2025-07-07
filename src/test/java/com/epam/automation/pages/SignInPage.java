package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPage{

    public static By lnk_catalog_name = By.xpath("//div[@id='SmokeTests']//h3");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public String getCatalogLoggedInUser() {
        guiUtils.waitUntilElementPresent(driver.findElement(lnk_catalog_name));
        return driver.findElement(lnk_catalog_name).getText();
    }
}
