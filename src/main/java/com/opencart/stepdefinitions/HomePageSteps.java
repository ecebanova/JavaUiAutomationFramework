package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("Home Page is accessed")
    public void homePageIsAccessed() {
        System.out.println("Cucumber is working");
        DriverManager.getInstance().getDriver().get("https://andreisecuqa.host/");
    }

    @And("Register Page is accessed from Home Page Menu")
    public void registerPageIsAccessedFromHomePageMenu() {
        homePage.navigateToRegisterPageFromHeaderMenu();
    }
}