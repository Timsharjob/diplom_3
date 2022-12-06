import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

import java.time.Duration;

public class ProfileTest {
    private WebDriver driver;

    //   String pathYandexDriver = "C:\\Automation\\yandexdriver.exe"; //Yandex Browser

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

    @DisplayName("Переход по клику на «Личный кабинет»")
    @Test
    public void goToPersonalAreaTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickCheckoutButton();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        mainPage.clickPersonalArea();
        Assert.assertEquals("Профиль", profilePage.getProfileText());
    }

    @DisplayName("Переход по клику на логотип Stellar Burgers")
    @Test
    public void goToMainPageForImgTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickCheckoutButton();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        mainPage.clickPersonalArea();
        profilePage.clickImg();
        Assert.assertEquals("Оформить заказ", mainPage.getCheckoutButtonText());
    }

    @DisplayName("Переход по клику на Конструктор")
    @Test
    public void goToMainPageForConstructorTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickCheckoutButton();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        mainPage.clickPersonalArea();
        profilePage.clickConstructorButton();
        Assert.assertEquals("Оформить заказ", mainPage.getCheckoutButtonText());
    }

    @DisplayName("Выход из профиля")
    @Test
    public void exitProfileTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickCheckoutButton();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        mainPage.clickPersonalArea();
        profilePage.clickExitButton();
        Assert.assertEquals("Войти", loginPage.getTextLoginButton());
    }
}
