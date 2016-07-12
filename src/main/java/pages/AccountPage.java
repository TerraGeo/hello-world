package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CustomDelay;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static utils.CustomDelay.customDelay;

/**
 * Created by Billy on 7/5/2016.
 */
public class AccountPage extends Page {
    public AccountPage(WebDriver webDriver) {super(webDriver);}


    @FindBy(xpath = "//div[@class='dashboard-welcome__welcome-msg']")
    private WebElement greetingsMessage;

    @FindBy(xpath = "//input[@id='global-search__input']")
    private WebElement stuffSearchField;

    @FindBy(xpath = "//input[@class='global-search__submit']")
    private WebElement searchButton;

    public void greetingsMessageAssertEquals() {
        String correctMessage = "Welcome, thesunriseempire@ukr.net";
        assertEquals(customDelay(visibilityOf(greetingsMessage)).getText(), correctMessage);
    }

    public SearchResultPage moveToSearchResults(String string){
        CustomDelay.customDelay(visibilityOf(stuffSearchField)).sendKeys(string);
        customDelay(searchButton).click();
        return new SearchResultPage(Page.getDriver());
    }


}
