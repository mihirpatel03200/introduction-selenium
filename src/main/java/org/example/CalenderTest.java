package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CalenderTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        String month = "8";
        String day = "3";
        String year = "2030";
        String [] expectedDate = {month, day, year};

        driver.findElement(By.cssSelector(".react-date-picker__wrapper")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text() = '" + year +"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text() = '" +day+"']")).click();

        List < WebElement > actualDate = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i  < actualDate.size(); i++) {
            System.out.println(actualDate.get(i).getAttribute("value"));
            Assert.assertEquals(actualDate.get(i).getAttribute("value"), expectedDate[i]);
        }
    }
}
