package tests;

import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends SetupAndQuitMethods {

    @Test
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();
    }

    @Test
    public void incorrectEmailLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();
    }

    @Test
    public void incorrectPswLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();
    }
}
