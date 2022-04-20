package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.BrowsersService;

public class FirstTest {
    private WebDriver driver;

    @Test
    public void simpleTest() {
        services.SimpleDriver simpleDriver = new services.SimpleDriver();
        driver = simpleDriver.getDriver();
    }

    @Test
    public void advancedTest() {
        services.AdvancedDriver advancedDriver = new services.AdvancedDriver();
        driver = advancedDriver.getDriver();
    }

    @Test
    public void browserServiceTest() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }
}
