package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        // Define a driver object that will be used for future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();

//        // Alta metoda de apelare
//        DriverManager driverManager = DriverManager.getInstance();
//        WebDriver driver2 = driverManager.getDriver();

        driver.get("https://mvnrepository.com/search?q=bonigarcia");
        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.get("https://maven.apache.org/download.cgi");
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.get("https://www.tarom.ro/");
        Thread.sleep(2000);
        driver.quit();

        System.out.println("The execution was finished");
    }
}