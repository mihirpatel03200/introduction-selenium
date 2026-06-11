package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[text() = 'Click Here']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);

        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        String word = driver.findElement(By.cssSelector("div[class='example'] h3")).getText().split(" ")[1];
        System.out.println(word);

        driver.switchTo().window(parentID);

        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());


    }
}
