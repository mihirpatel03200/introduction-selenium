package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Assigniment8 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("Ind");

        List < WebElement> countries = driver.findElements(By.cssSelector(".ui-menu-item"));

        for (WebElement country : countries) {
            if (country.getText().equals("India")) {
                country.click();
                break;
            }
        }
//        driver.findElement(By.id("autocomplete")).sendKeys("ind");
//
//        Thread.sleep(2000);
//
//        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//
//        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//
//        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

    }
}
