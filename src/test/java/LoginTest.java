import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ForgorPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;

//    String pathYandexDriver = "C:\\Automation\\yandexdriver.exe"; //Yandex Browser

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver",pathYandexDriver); //Yandex Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void testLoginCheckoutButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickCheckoutButton();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", mainPage.getCheckoutButtonText());
    }

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Test
    public void testLoginPersonalArea() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickPersonalArea();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", mainPage.getCheckoutButtonText());
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void testLoginRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickPersonalArea();
        loginPage.clickRegistrationButton();
        registrationPage.clickLoginButton();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", mainPage.getCheckoutButtonText());
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void testLoginForgotPasswordPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgorPasswordPage forgorPasswordPage = new ForgorPasswordPage(driver);
        mainPage.clickPersonalArea();
        loginPage.clickForgotPasswordButton();
        forgorPasswordPage.clickLoginButton();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", mainPage.getCheckoutButtonText());
    }
}
