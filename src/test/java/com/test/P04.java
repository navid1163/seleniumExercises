package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P04 {
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://accounts.lambdatest.com");

        WebElement signupButton = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
        signupButton.click();

        WebElement fullName = driver.findElement(By.xpath("//input[@id='name']"));
        fullName.sendKeys("navidhaydari");
        fullName.sendKeys(Keys.TAB);

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("eraj.navid@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='userpassword']"));
        password.sendKeys("Sevilla1234");

        WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
        phone.sendKeys("643067001");

        WebElement samp = driver.findElement(By.tagName("samp"));
        samp.click();

        WebElement create = driver.findElement(By.xpath("//button[contains(text(),'FREE SIGN UP')]"));
        create.click();


    }


}
