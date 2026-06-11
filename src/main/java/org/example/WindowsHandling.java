package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsHandling {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); //parrent id and child id
        Iterator<String> it = windows.iterator(); // creating the windows id parent and child ID'S
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId); //Switching the drive to the child page.

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText()); // extracted the text form the child page
        String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(emailID);

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailID);





    }
}
