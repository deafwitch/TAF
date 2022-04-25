package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class XPathSelectorsTest {
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
    public void basicXPathSelectors(){
        driver.get(ReadProperties.getUrl());

        // абсолютный XPath
        Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[4]/div/div[1]/div[1]/div/div[2]")).isDisplayed());

        // все элементы на странице, нанчиная с HTML
        driver.findElement(By.xpath("//*"));

        // поиск по тегу
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // поиск родительского div и сразу (на один уровень ниже) ребёнка h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // поиск родительского div и сразу (на любом уровне ниже) ребёнка h1
        Assert.assertTrue(driver.findElement(By.xpath("//div//h1")).isDisplayed());

        // поиск элемента с тегом div, у которого есть аттрибут ID
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // поиск элемента, у которого есть аттрибут ID со значением 'top-logo'
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        // поиск элемента, у которого есть аттрибут method со значением post и аттрибут target со значением _blank
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method = 'post' and @target = '_blank']")).isDisplayed());

        // поиск элемента, у которого значение аттрибута начинается с ...
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'new')]")).isDisplayed());

        // поиск элемента, который содержит подстроку ...
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@id, 'Template')]")).isDisplayed());

        // поиск элемента, у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'All Projects')]")).isDisplayed());

        // поиск элемента, у которого текстовое значение равно ...
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'All Projects']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Todos']")).isDisplayed());

        // поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());

        // поиск элемента
        Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed());
    }

    @Test
    public void axesXPathTest(){
        driver.get(ReadProperties.getUrl());

        // поиск родителя у элемента с тегом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        // поиск всех предков (с тегом div) у элемента с тегом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // использование child - все дочерние элементы с тегом a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        // использование following - выбирает все узлы в документе после закрытия тега текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        // использование following-sibling - выбирает все узлы одного уровня после текущего элемента
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());

        // использование preceding - выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding::form")).isDisplayed());

        // использование preceding-sibling - выбирает все узлы одного уровня до текущего элемента
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }
}
