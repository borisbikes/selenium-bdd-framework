package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private final String PAGE_URL = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
    public static By lnk_hamburger_menu = By.xpath("//div[@id='menuToggle']/input");


    public static By getLnk_menu_option(String option) {
        return By.xpath(String.format("//a/li[contains(text(),'%s')]", option));
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(PAGE_URL);
        log.info("Login page opened");
        return this;
    }

    public SignInPage openMenu(String option) {
        try {
            driver.findElement(lnk_hamburger_menu).click();
            guiUtils.singleClick(driver.findElement(getLnk_menu_option(option)));
        } catch (Exception e) {
            log.error("The was an error while opening in the menu. \n{}", e.getLocalizedMessage());
        }
        return new SignInPage(driver);

    }



}
