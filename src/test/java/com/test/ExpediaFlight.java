package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExpediaFlight {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/Flights");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'One-way')]")).click();
        WebElement leaving = driver.findElement(By.xpath("//button[@aria-label='Leaving from']"));
        leaving.click();
        WebElement region = driver.findElement(By.xpath("//input[@id='location-field-leg1-origin']"));
        region.sendKeys("Malaga" + Keys.ENTER);


        WebElement going = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
        going.click();
        Thread.sleep(5000);
        WebElement destiny = driver.findElement(By.xpath("//input[@id='location-field-leg1-destination']"));
        destiny.sendKeys("Berlin" + Keys.ENTER);
        Thread.sleep(5000);

        WebElement date = driver.findElement(By.xpath("//button[@id='d1-btn']"));
        date.click();

        WebElement selectDay = driver.findElement(By.xpath("(//button[@aria-label='Dec 2, 2022'])"));
        selectDay.click();

        WebElement done = driver.findElement(By.xpath("(//button[@data-stid='apply-date-picker'])"));
        done.click();

        WebElement search = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        search.click();



    }



}
