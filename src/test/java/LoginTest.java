import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

public class LoginTest extends BaseTest {

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
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        mainPage.clickPersonalArea();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickLoginButton();
        loginPage.setEmailTextField("Timur2@test.ru");
        loginPage.setPasswordTextField("222222");
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", mainPage.getCheckoutButtonText());
    }
}
