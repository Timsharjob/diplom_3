import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import java.time.Duration;

public class ConstructorTest {
    private final String expectedClass = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
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

    @DisplayName("Переход к разделу Соусы")
    @Test
    public void sauceClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceButton();
        Assert.assertEquals(expectedClass, mainPage.getSauceButtonClass());
    }

    @DisplayName("Переход к разделу Начинки")
    @Test
    public void fillingClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingButton();
        Assert.assertEquals(expectedClass, mainPage.getFillingButtonClass());
    }

    @DisplayName("Переход к разделу Булки")
    @Test
    public void bunClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        Assert.assertEquals(expectedClass, mainPage.getBunButtonClass());
    }
}
