package utils;

import baseEntities.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult tr) {
        Object currentClass = tr.getInstance();
        try {
            WebDriver driver = ((BaseTest) currentClass).driver;
            byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(srcFile);

            // (такой себе) способ, который всё же работает
            //Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception ignored) {

        }
    }

    @Attachment(value = "Page screenshot", type = "image/png", fileExtension = "png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
