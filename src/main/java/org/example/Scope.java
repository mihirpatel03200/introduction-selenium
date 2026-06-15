package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        WebElement columnFooterDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnFooterDriver.findElements(By.tagName("a")).size());

        for (int i = 1; i < columnFooterDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
            Thread.sleep(5000L);

        }
        Set<String> abc = driver.getWindowHandles();
        Iterator <String> it = abc.iterator();

        while(it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
