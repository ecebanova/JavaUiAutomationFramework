package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.AccountCreatedPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmai();
        String password = DataFakerManager.getRandomPassword(24, 25);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.logoutFromTheAccount();
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        driver.quit();
        System.out.println("The execution was finished");
    }
}