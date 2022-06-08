package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeSuite
    public void setupBrowser() {
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1366x768";
        //Configuration.browserBinary - ����������� ������� ������ �� .exe �� ������ (������) ���������
        //Configuration.assertionMode = AssertionMode.SOFT; - hard ��� soft ��������...
        //Configuration.clickViaJs - ����������� ������ ��� ����� ����� JS
        //Configuration.downloadsFolder - ����������� ������� ����� ��� ���������� ������
        //Configuration.driverManagerEnabled - ����������� ���������� ��������� driver manager
        //Configuration.fastSetValue - ����������� �������� �������� ������ ������������
        //Configuration.holdBrowserOpen - ����������� �������� ������� ��������
        //...
        Configuration.reportsFolder = "target/reports";
        //Configuration.pageLoadTimeout = Duration.ofSeconds(30).toMillis();
        //Configuration.timeout = Duration.ofSeconds(20).toMillis();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());     // ������� ������

//        // or for fine-tuning:
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()       // ������, ���� ����� "�������� �����������"
//                .screenshots(false)
//                .savePageSource(true)
//        );
    }

    @BeforeMethod
    public void setupTest() {
        Configuration.baseUrl = ReadProperties.getUrl();
    }

    @AfterMethod
    public void closeTest() {
        $(".navigation-username").click();
        $(By.id("navigation-user-logout")).click();
        sleep(2000);
        //closeWindow();
    }

    @Test
    public void simpleSelenideTest() throws InterruptedException {
        open(ReadProperties.getUrl());

        // Selenide ������ �������� ������ � CSS`��

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        Thread.sleep(1000);

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));   // ������ - ����� ������������ � Selenide

        Thread.sleep(1000);
    }

    @Test
    public void poSelenideTest() {
        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();

        loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password());
        loginPage.button.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
    }

    @Test
    public void selenideTest1() {
        // ������������� ���� ��� login-�������� - ������� ����
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
    }

    @Test
    public void selenideTest2() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
        $$("div.project")
                .filter(visible)
                .shouldHave(size(26))
                .find(text("erg"))
                .click();

        // ����� ����������� �������� �� ������ (1-��, 2-��, ...)
        $$("div.project")
                .first();
        $$("div.project")
                .get(2);

        sleep(1000);   // ��� ������������ ����� ��������� ����
        refresh(); // ���������� ��������
        title(); // ������� ������ � ����� ��������
        executeJavaScript(""); // � executeAsyncJavaScript("") - use JS
    }

    @Test
    public void selenideTest3() {
        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        System.out.println($(byText("asdasdasdfaszc")).innerText());
        System.out.println($(byText("asdasdasdfaszc")).getText());
        System.out.println($(byText("asdasdasdfaszc")).innerHtml());
        System.out.println($(byText("asdasdasdfaszc")).data(""));
        System.out.println($(byText("asdasdasdfaszc")).val());
        System.out.println($(byText("asdasdasdfaszc")).getValue());
        $(byText("asdasdasdfaszc")).scrollTo();
        $(byText("asdasdasdfaszc")).doubleClick();
        $(byText("asdasdasdfaszc")).contextClick();
        $(byText("asdasdasdfaszc")).hover();
        $(byText("asdasdasdfaszc")).find(By.xpath(""));
        $(byText("asdasdasdfaszc")).closest("tr");
        $(byText("asdasdasdfaszc")).ancestor("div");
        $(byText("asdasdasdfaszc")).sibling(1);
        $(byText("asdasdasdfaszc")).parent();

        $(byText("asdasdasdfaszc")).uploadFile(new File(""));
        //$(byText("asdasdasdfaszc")).download();
    }

    @Test
    public void selenideTest4() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        open("/index.php?/admin/projects/overview");

        $$(By.className("hoverSensitive"))
                .shouldHave(size(26))
                .find(text("erg"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));

        $("#announcement")
                .should(exist)
                .should(hidden).should(disappear).shouldNotBe(visible)
                .should(readonly)
                .shouldHave(name("fname"))
                .shouldHave(value("John"))
                .shouldHave(type("checkbox"))   // ������� type � ����� ��������
                .shouldBe(empty)
                .shouldBe(focused);

        WebElement webElement = $("#announcement").toWebElement();

        Condition clickable = and("can be clicked", visible, enabled);
        $$("#announcement")
                .findBy(clickable).click();

        $("#announcement").shouldBe(clickable);

        // �������� �� ������
        $("#announcement")
                .shouldHave(text("Expected text"))                                  // �������� �� ��������� ������; "contains"
                .shouldHave(matchText("Regexed text"))                              // �������� �� ��������� �������� ������; "regex"
                .shouldHave(exactText("Exact text \n\n\n"))                         // �������� �� ��������� ����������� ������; "������ �� ��������"; "equalsIgnoreCase"
                .shouldHave(textCaseSensitive("Exp Result Text"))                   // �������� �� ��������� ������ + �������������������
                .shouldHave(exactTextCaseSensitive("Exp Result Text \n\n\n"));      // �������� �� ��������� ������ + ������������������� + ��� �������; "equals"
    }
}
