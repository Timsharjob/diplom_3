package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgorPasswordPage {
    private final WebDriver driver;
    private final By loginButton = By.xpath("//a[@class='Auth_link__1fOlj']");

    public ForgorPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
