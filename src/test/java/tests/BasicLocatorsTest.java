package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class BasicLocatorsTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicLocatorsTest() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        //Find webElement by ID
        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());

        //Find webElement by Name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        //Find webElement by tagName
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
    }

    @Test
    public void basicLocatorsTest1() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        //Find webElement by linkText
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(2000);

        //Find webElement by className
        driver.findElement(By.className("forgot_passwordpage-request-cancel")).click();

        Thread.sleep(2000);

        //Find webElement by partialLinkText
        driver.findElement(By.partialLinkText("Forgot your")).click();

        Thread.sleep(2000);
    }
}
