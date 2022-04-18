import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\IT\\code\\test\\qa\\TAF\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        return driver;
    }
}
