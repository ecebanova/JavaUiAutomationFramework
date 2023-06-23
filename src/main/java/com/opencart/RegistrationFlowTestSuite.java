package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;

public class RegistrationFlowTestSuite {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    static int counter = 0;

    @BeforeEach
    public void executeTheCodeBeforeEachTestFromThisClass() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        counter++;
        System.out.println("The test number" + counter + "started");
    }

    @Test
    @DisplayName("The URL contains succes keyword after registration with valid data")
    public void registerFlowRedirectsTheUserToTheCorrectUrl() throws InterruptedException {

        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmai();
        String password = DataFakerManager.getRandomPassword(24, 25);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(500);
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheCorrectKeywords = driver.getCurrentUrl().contains("/index.php?route=account/success&language");
        Assertions.assertTrue(urlContainsTheCorrectKeywords, "The URL contains" + driver.getCurrentUrl() + "contains success keyword");
    }

    @Test
    @DisplayName("The URL contains register keyword when privacy policy is not accepted")
    public void registerFlowIsBlockedByPrivacyPolicyToggleWhenDisabled() throws InterruptedException {

        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmai();
        String password = DataFakerManager.getRandomPassword(24, 25);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
//        Do not enable the Privacy Toggle
//        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(500);
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheCorrectKeywords = driver.getCurrentUrl().contains("/index.php?route=account/success&language");
        String errorMessage = "The URL" + driver.getCurrentUrl() + "does not contain succes keyword";
        Assertions.assertFalse(urlContainsTheCorrectKeywords, errorMessage);

        boolean urlContainsRegisterKeyword = driver.getCurrentUrl().contains("register");
        Assertions.assertTrue(urlContainsRegisterKeyword, "The URL belongs to register page");
    }

    @AfterEach
    public void quitTheDriverAfterEachTestCase() {
        DriverManager.getInstance().quitTheDriver();
        System.out.println("The test number " + counter + " finished");
    }
}