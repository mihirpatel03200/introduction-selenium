package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Assigniment7 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement table = driver.findElement(By.id("product"));

        System.out.println("Number of rows: " +table.findElements(By.tagName("tr")).size());
        System.out.println("Number of Columns: " +table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

        List <WebElement> rows = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

        System.out.println(rows.get(0).getText());
        System.out.println(rows.get(1).getText());
        System.out.println(rows.get(2).getText());
    }
}
