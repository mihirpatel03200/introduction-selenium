package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Assigniment3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

        driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");

        driver.findElement(By.xpath("//span[text()=' User']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("okayBtn")));

        driver.findElement(By.id("okayBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select.form-control")));

        WebElement staticDropdown = driver.findElement(By.cssSelector("select.form-control"));

        Select dropdown = new Select(staticDropdown);

        dropdown.selectByVisibleText("Consultant");

        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Consultant");

        driver.findElement(By.id("terms")).click();

        driver.findElement(By.cssSelector("input[id='signInBtn']")).click();

//        wait.until(ExpectedConditions.alertIsPresent());
//
//        driver.switchTo().alert().accept();

        Thread.sleep(10000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.nav-link.btn.btn-primary")));

        List<WebElement> product = driver.findElements(By.cssSelector("button.btn.btn-info"));

        for (int i = 0; i < product.size(); i++) {

            product.get(i).click();

        }

        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();


    }
}
