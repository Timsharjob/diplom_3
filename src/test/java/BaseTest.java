import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static pageobject.Page.URL;


public class BaseTest {
    protected WebDriver driver;
    //    String pathYandexDriver = "C:\\Automation\\yandexdriver.exe"; //Yandex Browser

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//       System.setProperty("webdriver.chrome.driver",pathYandexDriver); //Yandex Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
