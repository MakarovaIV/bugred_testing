package ru.bugredUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(), 'Пользователи')]")
    private WebElement btnUser;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr[1]/td[1]")
    private WebElement userEmail;

    @FindBy(xpath = "/html/body/div[3]/table/tbody/tr[1]/td[2]")
    private WebElement userName;

    public void clickUserBtn() {
        btnUser.click();
    }

    public String getUserEmail() {
        return userEmail.getText();
    }

    public String getUserName() {
        return userName.getText();
    }
}
