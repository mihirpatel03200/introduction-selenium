package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;

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

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());


        //ForgetPassowrd
//        RahulShetty1 pass = new RahulShetty1();
//        pass.getPassword(driver);

        String password = getPassword(driver);

        driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();


        Thread.sleep(3000);

        //LoginPage
        String name = "Mihir Patel";
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);

        driver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
        driver.findElement(By.cssSelector("input[id='chkboxTwo']")).click();

        driver.findElement(By.cssSelector("button[class='submit signInBtn']")).click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
         Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " +name+ ",");

        Thread.sleep(1000);

        //Logout
        driver.findElement(By.cssSelector("button[class='logout-btn']")).click();

        driver.quit();




    }

    public static String getPassword(WebDriver driver) {
        driver.findElement(By.linkText("Forgot your password?")).click();

        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Mihir Patel");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("mihirpatel@yopmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9365981239");

        driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();

        String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        String[] passwordArray = passwordText.split("'");


        String[] passwordArray2 = passwordArray[1].split("'");
        return passwordArray2[0];


    }
}
