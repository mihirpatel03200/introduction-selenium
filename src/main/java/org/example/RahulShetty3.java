package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RahulShetty3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Mihir Patel");

        driver.findElement(By.id("alertbtn")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Mihir Patel");

        driver.findElement(By.id("confirmbtn")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();

    }
}
