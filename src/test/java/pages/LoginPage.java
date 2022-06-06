package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement username = $(By.id("name"));
    public SelenideElement password = $("#password");
    public SelenideElement button = $("#button_primary");
}
