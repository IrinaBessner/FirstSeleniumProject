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

public class HomeWork3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByXpath() {
        driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        driver.findElement(By.xpath("//*[@id='bar-notification']"));

        driver.findElement(By.xpath("//*[@class='bar-notification']"));
        driver.findElement(By.xpath("//*[@class='master-wrapper-content']"));


        driver.findElement(By.xpath("//*[@value='Search']"));
        driver.findElement(By.xpath("//*[@action='/search']"));


        driver.findElement(By.xpath("//*[@title='Close']"));
        driver.findElement(By.xpath("//*[contains(@href,'register')]"));

        //starts with
        driver.findElement(By.xpath("//*[starts-with(@onsubmit,'return')]"));
        //ends with
        driver.findElement(By.xpath("//*[substring(@value, string-length(@value) - string-length('store') +1) = 'store']"));
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
