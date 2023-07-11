package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Downloader {
    @Test
    public void downloaderTest() {
        //open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/download";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement descarcarePoza = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]"));
        descarcarePoza.click();
        driver.close();

    }
}
