package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Practice1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".text-reset")).click();
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("firstName")).sendKeys("Mihir");
        driver.findElement(By.id("lastName")).sendKeys("Patel");
        String email = "mihirpatel" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddmmyyyy")) + "yopmail.com";
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userMobile")).sendKeys("9876540321");
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='custom-select ng-pristine ng-valid ng-touched']"));
        Select option = new Select(dropdown);
        option.selectByValue("Engineer");
        driver.findElement(By.cssSelector("input[value = 'Male']")).click();
        driver.findElement(By.id("userPassword")).sendKeys("Test105*");
        driver.findElement(By.id("confirmPassword")).sendKeys("Test105*");

        driver.findElement(By.xpath("//input[@class='ng-pristine ng-invalid ng-touched']")).click();
        driver.findElement(By.cssSelector("input[value='Register']")).click();

    }
}
