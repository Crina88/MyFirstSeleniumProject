package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Upload {
    @Test
    public void uploadTest() {
        //open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/upload";
        driver.get(url);
        driver.manage().window().maximize();

        //click upload file
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //chooseFileButton.click();
        chooseFileButton.sendKeys("C:\\Users\\obanc_\\IdeaProjects\\MyFirstSeleniumProject\\src\\test\\resources\\upload.txt");

        WebElement fileSubmitButton = driver.findElement(By.id("file-submit"));
        fileSubmitButton.click();

        WebElement headerMassage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String text = "File Uploaded!";
        Assert.assertTrue(headerMassage.getText().contains("File Uploaded!"));

        WebElement uploadedFilesList = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploadedFilesList.getText().contains("upload.txt"));
        driver.close();

    }
}