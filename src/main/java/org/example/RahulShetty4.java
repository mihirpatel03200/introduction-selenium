package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RahulShetty4 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] vigges = {"Brocolli", "Cucumber", "Potato", "Tomato"};

        List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");
            String formatedName = name[0].trim();

            List itemsList = Arrays.asList(vigges);

            if (itemsList.contains(formatedName)) {

                j++;
                driver.findElements(By.xpath("//div[@class = 'product-action']")).get(i).click();

                if (j == vigges.length) {
                    break;
                }
            }
        }
    }
}
