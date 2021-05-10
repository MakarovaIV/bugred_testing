import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestUser {
    public static MainPage mainPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getProperty("mainPage"));
    }

    @Test
    public void mainTest() {
        mainPage.clickUserBtn();
        String email = mainPage.getUserEmail();
        Assert.assertEquals(ConfigProperties.getProperty("namePOST"), email);
        String name = mainPage.getUserName();
        Assert.assertEquals(ConfigProperties.getProperty("emailPOST"), name);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
