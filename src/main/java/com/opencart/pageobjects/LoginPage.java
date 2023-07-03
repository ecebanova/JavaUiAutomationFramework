package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public void fillInTheRegisterLoginForm (String email, String password) {
        emailInput.sendKeys(email);
        System.out.println("The entered email: " + email);
        passwordInput.sendKeys(password);
        System.out.println("The entered password: " + password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
        System.out.println("The login btn was clicked");
    }
}