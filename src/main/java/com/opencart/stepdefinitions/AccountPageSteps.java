package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContainsKeyword(String collectedStrongValue) {
        boolean urlContainsCollectedString = driver.getCurrentUrl().contains(collectedStrongValue);
        Assertions.assertTrue(urlContainsCollectedString, "The " + collectedStrongValue + "is present within the URL");
    }
}
