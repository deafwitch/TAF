package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest1() {
        driver.get("https://the-internet.herokuapp.com/iframe");


        // Переключились в дочерний фрейм:

        // 1. если они идут по порядку (и вы знаете порядок), либо он единственный; нумерация - с нуля
        driver.switchTo().frame(0);

        // 2. по имени или ID`шнику
        //driver.switchTo().frame("mce_0_ifr");

        // 3. по WebElement`y (тег iFrame)
        //driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe")));


        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());


        // переключились обратно в родительский фрейм; переключение - лишь на один уровень выше
        driver.switchTo().parentFrame();

        // переключение в САМУЮ ВЕРХНЮЮ страницу
        //driver.switchTo().defaultContent();


        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());
    }
}
