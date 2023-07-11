package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Input{
    @Test
    public void InputTest() {
        //open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/inputs";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement input = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input"));
        input.click();
        input.sendKeys("55555555555");
        input.clear();
        driver.close();
    }
}
