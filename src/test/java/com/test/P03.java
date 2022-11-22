package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P03 {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://outlook.live.com/owa/");
        WebElement creat = driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/section[1]/div[1]/div[2]/a[1]/span[1]"));
        creat.click();

        String actualURL = driver.getTitle();
        System.out.println("actualURL = " + actualURL);

        WebElement userInput = driver.findElement(By.xpath("//input[@id='MemberName']"));
        userInput.sendKeys("navid11haydari");
        userInput.sendKeys(Keys.ENTER);

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Sevilla1234");
        Assert.assertTrue(password.isDisplayed());


        WebElement mark = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        mark.click();


      //  WebElement next = driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
      //  next.click();

        WebElement nextOption = driver.findElement(By.xpath("//input[@id='iSignupAction']"));
        nextOption.click();

        Thread.sleep(3);

        //driver.close();
    }
}
