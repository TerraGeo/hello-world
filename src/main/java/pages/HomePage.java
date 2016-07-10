package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.CustomDelay.customDelay;

/**
 * Created by Billy on 7/5/2016.
 */
public class HomePage extends Page {

    @FindBy(xpath = "//button[@aria-controls='global-sign-in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(@href,'/signin-registration.html#signin')]")
    private WebElement innerSignIn;


    public HomePage(WebDriver webDriver) {super(webDriver);}

    public SignInPage clickOnSignInButton(){
        signInButton.click();
        customDelay(innerSignIn).click();
        return new SignInPage(Page.getDriver());
    }

}
