package com.epam.automation.pages;

import com.epam.automation.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage{

    private By txt_id_user = By.id("usr");
    private By txt_id_password = By.id("pwd");

    public static By lnk_catalog_name = By.xpath("//div[@id='SmokeTests']//h3");
    public static By btn_submit = By.xpath("//input[@type='submit']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public SignInPage signIn(User user) {
        try {
            guiUtils.fillInput(driver.findElement(txt_id_user), user.getUsername());
            guiUtils.fillInput(driver.findElement(txt_id_password), user.getPassword());
            guiUtils.singleClick(driver.findElement(btn_submit));
        } catch (Exception e) {
            log.error("The was an error while signing in the user. \n{}", e.getLocalizedMessage());
        }
        return new SignInPage(driver);

    }

    public String getCatalogLoggedInUser() {
        guiUtils.waitUntilElementPresent(driver.findElement(lnk_catalog_name));
        return driver.findElement(lnk_catalog_name).getText();
    }
}
