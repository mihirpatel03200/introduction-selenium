package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BrokenLinks {

    public static void main(String[] args) throws URISyntaxException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String Url = driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
        HttpURLConnection connection = (HttpsURLConnection) new URI(Url).toURL().openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        Integer statusCode = connection.getResponseCode();
        System.out.println(statusCode   );
    }
}
