package org.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void firstTest(){
        System.out.println("This is coming from first test");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("Gradle");
        driver.quit();
    }
}
