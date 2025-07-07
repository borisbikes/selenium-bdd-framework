package com.epam.automation.step_definition;

import com.epam.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.lang.annotation.Annotation;

public class BasePage {
    private HomePage homePage;
    private static WebDriver driver = Hooks.driver;

    @Given("User navigates to the login page")
    public void userNavigatesToTheLoginPage() {
        homePage = new HomePage(driver);
        var cathalogName = homePage
                .openPage()
                .signIn()
                .getCatalogLoggedInUser();
        Assert.assertEquals("There was an issue signing in the home page",
                cathalogName, "Formal Shoes");
    }

    @When("User successfully enter the log in details")
    public void userSuccessfullyEnterTheLogInDetails() {
    }

    @Then("User should be able to view the product category page")
    public void userShouldBeAbleToViewTheProductCategoryPage() {
    }
}
