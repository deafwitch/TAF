package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {

    @Test
    public void newTabTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandleList = new ArrayList<>(windowHandlesSet);

        driver.switchTo().window(windowHandleList.get(1));

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");

        driver.close();

        driver.switchTo().window(originalWindow);

        Assert.assertTrue(driver.findElement(By.linkText("Click Here")).isDisplayed());

        //WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        //newWindow.quit();
    }

    @Test
    public void newTabTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandlesSet = driver.getWindowHandles();

        for (String handle : windowHandlesSet) {
            if (!originalWindow.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }


        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");

        driver.close();

        driver.switchTo().window(originalWindow);

        Assert.assertTrue(driver.findElement(By.linkText("Click Here")).isDisplayed());
    }
}
