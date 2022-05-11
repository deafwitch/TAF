package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import services.WaitsService;

import javax.jws.WebService;
import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElement = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));
        actions
                .moveToElement(targetElement.get(0))                            // простой target element
                //.click(wait.waitForVisibilityLocatedBy(By.cssSelector("[href='/users/1']")))
                                                                                // для нахождения (клика) ссылок
                                                                                // под hover`ом
                .pause(2000)
                .moveToElement(targetElement.get(1), 10,10)       // target element с offset`ом
                .pause(2000)
                //.moveToElement(targetElement.get(2), targetElement.get(2).getRect().width-5, 10)
                                                                                // target element с offset`ом
                                                                                // и исходя из размера элемента
                .moveToElement(targetElement.get(2))
                .pause(2000)

                .keyDown(Keys.COMMAND)
                .pause(2000)

                .build()        // "собирает"
                .perform();     // "выполняет"
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        fileUploadPath.sendKeys("E:\\IT\\code\\resources\\calendar_2022.png");
        wait.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(3000);
    }
}
