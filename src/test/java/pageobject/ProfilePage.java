package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;
    private final By profileText = By.xpath("//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");
    private final By headerImg = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By exitButton = By.xpath("//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProfileText() {
        return driver.findElement(profileText).getText();
    }

    public void clickImg() {
        driver.findElement(headerImg).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }
}
