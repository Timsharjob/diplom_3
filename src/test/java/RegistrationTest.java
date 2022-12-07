import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

public class RegistrationTest extends BaseTest {

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
