package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By personalArea = By.xpath("//p[text()='Личный Кабинет']");
    private final By checkoutButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private final By bunButton = By.xpath("//section[1]/div[1]/div[1]");
    private final By sauceButton = By.xpath("//section[1]/div[1]/div[2]");
    private final By fillingButton = By.xpath("//section[1]/div[1]/div[3]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void clickPersonalArea() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(personalArea));
        driver.findElement(personalArea).click();
    }

    @Step
    public void clickCheckoutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }

    @Step
    public String getCheckoutButtonText() {
        return driver.findElement(checkoutButton).getText();
    }

    @Step
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    @Step
    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }

    @Step
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    @Step
    public String getSauceButtonClass() {
        return driver.findElement(sauceButton).getAttribute("class");
    }

    @Step
    public String getFillingButtonClass() {
        return driver.findElement(fillingButton).getAttribute("className");
    }

    @Step
    public String getBunButtonClass() {
        return driver.findElement(bunButton).getAttribute("className");
    }
}
