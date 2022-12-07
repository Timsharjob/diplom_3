import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;

public class ConstructorTest extends BaseTest {
    private final String expectedClass = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

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
