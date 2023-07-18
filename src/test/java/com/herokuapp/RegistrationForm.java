package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationForm {
    @Test
    public void registrationForm() {
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
        mobile.sendKeys("0752204608");

        //enter  date of birth
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();

        //click on month drop-down
        WebElement monthSelector = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        monthSelector.click();
        Select month = new Select(monthSelector);
        month.selectByVisibleText("July");

        //click on year drop-down
        WebElement anSelector = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        anSelector.click();
        Select an = new Select(anSelector);
        an.selectByVisibleText("1988");

        WebElement daySelector = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[3]"));
        daySelector.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement subjectInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subjectsInput")));
        subjectInput.click();
        subjectInput.sendKeys("Maths");
        subjectInput.sendKeys(Keys.ENTER);

        WebElement addressInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"currentAddress\"]")));
        addressInput.click();
        addressInput.sendKeys("123 Test Street");


        //after adding the address, we move on to other elements using TAB and enter text using a sequence of sendKeys
        addressInput.sendKeys(Keys.TAB, "ncr", Keys.ENTER, Keys.TAB, "delhi", Keys.ENTER, Keys.TAB, Keys.ENTER);

        //verification of the success modal display & content
        WebElement modal = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertTrue(modal.isDisplayed());
        Assert.assertTrue(modal.getText().contains("Thanks for submitting the form"));

        //verification of the close modal button presence
        WebElement closeModal = driver.findElement(By.id("closeLargeModal"));
        Assert.assertTrue(closeModal.isDisplayed());
        driver.close();

    }
}


