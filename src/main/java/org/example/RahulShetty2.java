package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class RahulShetty2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdown = driver.findElement(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "USD");
        dropdown.selectByValue("INR");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "INR");
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "AED");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();

        int i = 1;
        while (i < 5) {
            driver.findElement(By.cssSelector("span[id = 'hrefIncAdt']")).click();
            i++;
        }

        driver.findElement(By.xpath("//input[@id = 'btnclosepaxoption']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText(), "5 Adult");

        driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.cssSelector("a[value='AMD']")).click();

        driver.findElement(By.cssSelector("div[id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='BOM']")).click();

        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");

        List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option : options) {
            if(option.getText().equals("India")){
                option.click();
                break;
            }
        }




    }
}
