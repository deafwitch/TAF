package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.AdvancedDriver;
import services.BrowsersService;
import services.SimpleDriver;

public class FirstTest {

    @Test
    public void simpleDriverTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
        driver.quit();
    }

    @Test
    public void advancedDriverTest() {
        AdvancedDriver simpleDriver = new AdvancedDriver();
        WebDriver driver = simpleDriver.getDriver();
        driver.quit();
    }

    @Test
    public void browsersServiceTest() {
        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();
        driver.quit();
    }
}
