package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import org.openqa.selenium.*;

//public class TestRunner {
//    public static void main(String[] args) throws InterruptedException {
//        // Define a driver object that will be used for future actions.
//        WebDriver driver = DriverManager.getInstance().getDriver();
//
////        // Alta metoda de apelare
////        DriverManager driverManager = DriverManager.getInstance();
////        WebDriver driver2 = driverManager.getDriver();
//
//        driver.get("https://mvnrepository.com/search?q=bonigarcia");
//        String currentWindowName = driver.getWindowHandle();
//        driver.switchTo().newWindow(WindowType.TAB);
//        Thread.sleep(2000);
//        driver.get("https://maven.apache.org/download.cgi");
//        Thread.sleep(2000);
//        driver.close();
//        driver.switchTo().window(currentWindowName);
//        driver.get("https://www.tarom.ro/");
//        Thread.sleep(2000);
//        driver.quit();
//
//        System.out.println("The execution was finished");
//    }
//}

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        // Define a driver object that will be used for future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://google.com");
        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");
        Thread.sleep(1000);
        WebElement accountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIcon.click();

        WebElement registerBtn = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerBtn.click();

        String firtsName = DataFakerManager.getRandomName();
        System.out.println("The generated first name is: " + firtsName);

        String lastName = DataFakerManager.getRandomName();
        System.out.println("The generated last name is: " + lastName);

        String email = DataFakerManager.getRandomEmai();
        System.out.println("The generated email is: " + email);

        String password = DataFakerManager.getRandomPassword(24, 25);
        System.out.println("The generated password is: " + password);

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(firtsName);

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys(password);

        WebElement privacyToggl = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ScrollManager.scrollToElement(driver, privacyToggl);
        privacyToggl.click();

        WebElement continueBtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueBtn.submit();

        Thread.sleep(2000);

        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.get("https://andreisecuqa.host/");
        driver.quit();

        System.out.println("The execution was finished");
    }
}