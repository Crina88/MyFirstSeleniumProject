package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegistrationForm {
    @Test
    public void registrationFormTest() {
        //open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.click();
        firstName.sendKeys("Obancea");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.click();
        lastName.sendKeys("Crina");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.sendKeys("divirician_crina@yahoo.com");

        WebElement gender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
        gender.click();

        WebElement mobile = driver.findElement(By.id("userNumber"));
        mobile.click();
        mobile.sendKeys("0746204608");

       // WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        //dateOfBirth.click();

      /* WebElement subject = driver.findElement(By.id("subjectsContainer"));
       subject.click();
       subject.sendKeys("Contabilitate");*/




    }
}