package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P02 {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://qatechhub.com");
        String actualTitle = driver.getTitle();
        String expTitle = "QA Automation Tools Trainings and Tutorials | QA Tech Hub";
        Assert.assertEquals(actualTitle,expTitle);

        driver.navigate().to("https://www.hotmail.com");
        Thread.sleep(3000);
        driver.navigate().back();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        driver.navigate().refresh();
        driver.close();
    }
}
