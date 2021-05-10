import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserListPage {
    public WebDriver driver;
    public UserListPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(), 'Пользователи')]")
    private WebElement btnUser;

    @FindBy(xpath = "/html/body/div[3]/form/table/tbody/tr[4]/td/input")
    private WebElement fieldFind;

    @FindBy(xpath = "/html/body/div[3]/form/table/tbody/tr[5]/td[1]/button")
    private WebElement btnFind;

    @FindBy(xpath = "/html/body/div[3]/table/tbody")
    private WebElement resultsTable;

    public void clickBtnUser() {
        btnUser.click();
    }

    public void findNecessaryUser(String userKey) {
        fieldFind.sendKeys(userKey);
    }

    public void clickBtnFindUser() {
        btnFind.click();
    }

    public Boolean findUserByNameAndMail(String email, String name) {
        WebElement emailTd = null;
        try {
            emailTd = resultsTable.findElement(By.xpath("//*[contains(text(), '" + email + "')]"));
        } catch (NoSuchElementException ignored) {
        }

        WebElement nameTd = null;
        try {
            nameTd = resultsTable.findElement(By.xpath("//*[contains(text(), '" + name + "')]"));
        } catch (NoSuchElementException ignored) {
        }
        return emailTd != null && nameTd != null;
    }

}
