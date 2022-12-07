package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    private final By nameTextField = By.xpath("//fieldset[1]//input");
    private final By emailTextField = By.xpath("//fieldset[2]//input");
    private final By passwordTextField = By.xpath("//fieldset[3]//input");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By incorrectPasswordText = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By loginButton = By.xpath("//a[@class='Auth_link__1fOlj']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void setNameTextField(String nameText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(nameTextField));
        driver.findElement(nameTextField).sendKeys(nameText);
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
    public void waitInvisibleRegistrationButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(registrationButton));
    }

    @Step
    public String getTextIncorrectPassword() {
        return driver.findElement(incorrectPasswordText).getText();
    }

    @Step
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
