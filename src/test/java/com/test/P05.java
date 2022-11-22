package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P05 {
    WebDriver driver;

    @BeforeClass
    public void testSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @BeforeMethod
    public void openBrowser(){
        driver.get("file:///C:/Users/Navid.Ahmad/Downloads/linksrotos.html");

    }


    @Test
    public void test1(){




        WebElement prosser = driver.findElement(By.xpath("//span[@class='inline-character']"));
        prosser.click();
        String actURL = driver.getCurrentUrl();
        String expURL = "https://www.litcharts.com/lit/the-hitchhiker-s-guide-to-the-galaxy/characters/mr-l-prosser";
        Assert.assertEquals(actURL,expURL);

        driver.navigate().back();
        WebElement arthur = driver.findElement(By.xpath("(//span[@class='inline-character'])[2]"));
        arthur.click();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        actURL = driver.getCurrentUrl();
        expURL="file:///C:/lit/the-hitchhiker-s-guide-to-the-galaxy/characters/arthur-dent";
        Assert.assertEquals(actURL,expURL);

        driver.navigate().back();
        WebElement bulldozer = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/a[3]"));
        bulldozer.click();
        actURL = driver.getCurrentUrl();
        expURL="file:///C:/Users/Navid.Ahmad/Downloads/linksrotos.html";
        Assert.assertEquals(actURL,expURL);

//        WebElement HetMasteen = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/a[1]"));
//        bulldozer.click();
//        actURL = driver.getCurrentUrl();
//        expURL="https://hyperioncantos.fandom.com/wiki/Het_Maste";
//        Assert.assertEquals(actURL,expURL);





    }
}
