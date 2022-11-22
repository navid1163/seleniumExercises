package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class P06 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/add_remove_elements/");
    }
    @Test
    public void test1(){
        WebElement add = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        add.click();

        WebElement delete = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertTrue(delete.isDisplayed());


    }

}
