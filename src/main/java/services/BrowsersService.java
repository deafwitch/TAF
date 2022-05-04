package services;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BrowsersService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;

    public BrowsersService() {
        switch (ReadProperties.browserName().toLowerCase(Locale.ROOT)) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();

                driver = new ChromeDriver(getChromeOptions());
                break;

            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();

                driver = new FirefoxDriver(getFirefoxOptions());
                break;

            default:
                System.out.println("Browser " + ReadProperties.browserName() + " is not support!!!");
        }
    }

    public WebDriver getDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // играемся со неявным временем ожидания
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);      // use для legacy кода
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));


        return this.driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(ReadProperties.isHeadless());
        chromeOptions.addArguments("--disable-gpu");
        //chromeOptions.addArguments("--window-size=1920,1200");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");

        return chromeOptions;
    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(ReadProperties.isHeadless());

        // ... some required options for Firefox

        return firefoxOptions;
    }
}
