package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulShetty1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("inputUsername")).sendKeys("Mihir");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test105*");

        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

    }
}
