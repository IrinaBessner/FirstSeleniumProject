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


public class FindElemensTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();    //maximite browser to window
        //wait for ALL elements on the site to load before starting the test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // неявное ожидание-время ожидание в сек
    }

    @Test
    public void findElementByName(){
        //find element by tag name
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1=driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find List of elementS by tag name
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementByLocators(){
        //id
        driver.findElement(By.id(("city")));
        //className
        driver.findElement(By.className("input-container"));
        //name By.name("user");
        //link text - старая стратегия и медленная
        driver.findElement(By.linkText("Let the car work"));
        //partial link text самая старая стратегия, возможна частичное совпадение
        driver.findElement(By.partialLinkText("work"));

    }
    // css selector
    @Test
    public void findElementByCssSelector(){
        //tag name = tag name
        driver.findElement(By.cssSelector("h1"));

        //id -> #id
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        //class name -> .className
        // driver.findElement(By.className("input-container"));
        driver.findElement(By.cssSelector(".input-container"));
        //[name='user']
        driver.findElement(By.cssSelector("[for='city']"));
        driver.findElement(By.cssSelector("[href='/seach']"));
        // contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));
        //end on-> $
        driver.findElement(By.cssSelector("[href$='work']"));
    }

    //xPath  //*tag[@attr='value']
    @Test
    public void findElementByXpath(){
        //tag name = //tag name
        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        //id -> //[@id='idName] #id
        //driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//*[@id='city']"));

        //class name -> //tag[@class='className']
        // driver.findElement(By.className("input-container"));
        driver.findElement(By.xpath("//*[@class='input-container']"));

        //contains -> //*[contains(@attr, '...')]
        // driver.findElement(By.cssSelector("[href*='car']"));
        driver.findElement(By.xpath("//*[contains(@href,'car')]"));

        //start -> //*[starts-with(@attr, '...')]
        driver.findElement(By.xpath("//*[starts-with(@href,'/let')]"));

        //text
        driver.findElement(By.xpath("//span[text()=' Never mistaken for anything else ']"));
        driver.findElement(By.xpath("//span[.=' Never mistaken for anything else ']"));
        driver.findElement(By.xpath("//span[contains(text(), 'mistake')]"));
        driver.findElement(By.xpath("//span[contains(., 'mistake')]"));

        // search of parent element - //input[@id='username']/..
        // //div/a - child - css = div>a
        // //div//a - any level child - css = div a

        //tag1[.tag2[@attr='value']] поиск выполняется относительно текущего элемента
        //*[@id='firstName' or @ @name='lastName']
        //*[@id='firstName' and @ @name='lastName']
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
