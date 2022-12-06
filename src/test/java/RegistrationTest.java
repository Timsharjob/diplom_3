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
import pageobject.RegistrationPage;

import java.time.Duration;

public class RegistrationTest {
    private WebDriver driver;
//    String pathYandexDriver = "C:\\Automation\\yandexdriver.exe"; //Yandex Browser

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//       System.setProperty("webdriver.chrome.driver",pathYandexDriver); //Yandex Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @DisplayName("Успешная регистрация")
    @Test
    public void registrationTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickPersonalArea();
        loginPage.clickRegistrationButton();
        registrationPage.setNameTextField("Timur");
        registrationPage.setEmailTextField("Timur@test.ru");
        registrationPage.setPasswordTextField("222222");
        registrationPage.clickRegistrationButton();
        registrationPage.waitInvisibleRegistrationButton();
        loginPage.setEmailTextField("Timur@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", mainPage.getCheckoutButtonText());
    }

    @DisplayName("Проверка минимального пароля — шесть символов")
    @Test
    public void incorrectPasswordTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickPersonalArea();
        loginPage.clickRegistrationButton();
        registrationPage.setNameTextField("Timur");
        registrationPage.setEmailTextField("Timur@test.ru");
        registrationPage.setPasswordTextField("2222");
        registrationPage.clickRegistrationButton();
        Assert.assertEquals("Некорректный пароль", registrationPage.getTextIncorrectPassword());
    }
}
