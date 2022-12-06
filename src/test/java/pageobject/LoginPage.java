package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By registrationButton = By.xpath("//a[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By emailTextField = By.xpath("//fieldset[1]/div/div/input");
    private final By passwordTextField = By.xpath("//fieldset[2]/div/div/input");
    private final By forgotPasswordButton = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void setEmailTextField(String emailText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(emailTextField));
        driver.findElement(emailTextField).sendKeys(emailText);
    }

    @Step
    public void setPasswordTextField(String passwordText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordTextField));
        driver.findElement(passwordTextField).sendKeys(passwordText);
    }

    @Step
    public void clickRegistrationButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationButton));
        driver.findElement(registrationButton).click();
    }

    @Step
    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step
    public String getTextLoginButton() {
        return driver.findElement(loginButton).getText();
    }

    @Step
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }
}
