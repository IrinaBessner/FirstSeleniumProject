package com.ait.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWork2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelector() {
        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        driver.findElement(By.cssSelector("#bar-notification"));

        driver.findElement(By.cssSelector(".bar-notification"));
        driver.findElement(By.cssSelector(".master-wrapper-content"));

        driver.findElement(By.cssSelector("[value='Search']"));
        driver.findElement(By.cssSelector("[action='/search']"));

        driver.findElement(By.cssSelector("[title*='Close']"));
        driver.findElement(By.cssSelector("[href*='register']"));

        driver.findElement(By.cssSelector("[onsubmit^='return']"));
        driver.findElement(By.cssSelector("[value$='store']"));
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}


