package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Billy on 7/5/2016.
 */
public class SignInPage extends Page {

    public SignInPage(WebDriver webDriver) {super(webDriver);}
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='sign-in-form__form-button']")
    private WebElement secondSignInButton;

    public AccountPage accountSignIn(String userName, String password){
        emailField.sendKeys(userName);
        passwordField.sendKeys(password);
        secondSignInButton.click();
        return new AccountPage(Page.getDriver());
    }
}
