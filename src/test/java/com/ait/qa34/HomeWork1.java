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


public class HomeWork1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElement1ByTagName(){

       WebElement element2 = driver.findElement(By.tagName("p"));
       System.out.println(element2.getText());

        WebElement element1 = driver.findElement(By.tagName("form"));
        System.out.println(element1.getText());

        // not unique
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        System.out.println(elements.size());


    }

    @AfterMethod()
    public void tearDown(){
        driver.quit();
    }
}
