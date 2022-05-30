package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {
    // Блок описания селекторов для элементов
    private By emailInputLocator = By.id("name");
    private By pswInputLocator = By.id("password");
    private By logInButtonLocator = By.id("button_primary");
    private By errorTextLocator = By.className("error-text");

    // Блок инициализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    // Блок атомарных методов
    public UIElement getEmailInput() {
        return new UIElement(driver, emailInputLocator);
    }

    public WebElement getPswInput() {
        return waitsService.waitForExists(pswInputLocator);
    }

    public Button getLogInButton() {
        return new Button(driver, logInButtonLocator);
    }

    public WebElement getErrorTextElement() {
        return waitsService.waitForExists(errorTextLocator);
    }
}
