package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the Registration form is completed with valid random data")
    public void theRegistrationFormIsCompletedWithValidRandomData() {
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmai();
        String password = DataFakerManager.getRandomPassword(24, 25);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
    }

    @And("the privacyToggle is enabled")
    public void thePrivacyToggleIsEnabled() {
        try {
            registerPage.switchOnThePrivacyToggle(driver);
        } catch (InterruptedException e) {
            System.out.println("Error!");
        }
    }

    @And("continueButton is clicked")
    public void continueButtonIsClicked() throws InterruptedException {
        registerPage.clickOnContinueBtn();
    }

    @And("the registration form is completed with the following data:")
    public void theRegistrationFormIsCompletedWithTheFollowingData(Map<String, String> userDetailsMap) {
        String firstNameValue = userDetailsMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = DataFakerManager.getRandomName();
        }

        String lastNameValue = userDetailsMap.get("lastName");
        if (lastNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = DataFakerManager.getRandomName();
        }

        String emailValue = userDetailsMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")) {
            emailValue = DataFakerManager.getRandomEmai();
        }

        String passwordValue = userDetailsMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")) {
            passwordValue = DataFakerManager.getRandomPassword(6,12);
        }

        registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue);
    }
}