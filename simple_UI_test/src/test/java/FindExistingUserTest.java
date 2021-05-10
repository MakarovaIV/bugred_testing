import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindExistingUserTest {
    public static UserListPage userListPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        userListPage = new UserListPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getProperty("URL"));
    }

    @Test
    public void checkUserInTable() {
        userListPage.clickBtnUser();
        userListPage.findNecessaryUser(ConfigProperties.getProperty("userKey"));
        userListPage.clickBtnFindUser();

        Assert.assertTrue(
                userListPage.findUserByNameAndMail(
                        ConfigProperties.getProperty("emailPOST"),
                        ConfigProperties.getProperty("namePOST")
                )
        );

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
