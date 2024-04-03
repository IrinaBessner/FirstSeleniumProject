package com.ait.qa34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp(){
        driver= new ChromeDriver();
       // driver.get("https://www.google.com"); without history
        driver.navigate().to("https://www.google.com"); // with history
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
    //test - name
    @Test
    public void openGoogleTest(){
        System.out.println("Google is opend!");
    }
    //after - tearDown - postCondition
    @AfterMethod (enabled = false) // enabled = false отключаем этот метод
    public void tearDown(){
        driver.quit();  //close browser(all tabs) все вкладки
      //  driver.close(); // close only one tab( zhe last one -> close browser только последнюю вкладку
    }
}
