package com.test;

        import java.io.IOException;
        import java.net.*;
        import java.io.*;
        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.Test;
        import java.util.List;
        import java.util.concurrent.TimeUnit;

public class testLinks {

    @Test
    public void test1() {
        String path1 = new File("linksrotos.html").getAbsolutePath( );
//        System.out.println(path1);


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("file:///"+path1);
//        file:///C:/Users/Enrique.Roman/source/repos/degara/seleniumExercises/linksrotos.html

        List<WebElement> links = driver.findElements(By.xpath("//a"));

        for (int i = 0; i < links.size(); i++) {
            String link = links.get(i).getAttribute("href");
            testLink(link);



        }
    }

    public void testLink(String link) {
        URL url = null;
        try {
            System.out.println("Testing link: " + link);
            url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}