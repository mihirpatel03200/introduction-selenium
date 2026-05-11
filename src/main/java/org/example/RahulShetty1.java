package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RahulShetty1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("inputUsername")).sendKeys("Mihir");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test105*");

        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

//        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());


        //ForgetPassowrd

        driver.findElement(By.linkText("Forgot your password?")).click();


    }
}
