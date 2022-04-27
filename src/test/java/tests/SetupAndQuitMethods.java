package tests;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;

public class SetupAndQuitMethods {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
