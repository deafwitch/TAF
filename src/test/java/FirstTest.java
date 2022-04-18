import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {
    private WebDriver driver;

//    @Test
//    public void simpleTest() {
//        SimpleDriver simpleDriver = new SimpleDriver();
//        driver = simpleDriver.getDriver();
//    }
//
//    @Test
//    public void advancedTest() {
//        AdvancedDriver advancedDriver = new AdvancedDriver();
//        driver = advancedDriver.getDriver();
//    }

    @Test
    public void browserServiceTest() {
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }
}
