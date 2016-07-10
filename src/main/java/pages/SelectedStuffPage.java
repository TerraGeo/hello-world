package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CustomDelay;

import static utils.CustomDelay.customDelay;

/**
 * Created by Billy on 7/10/2016.
 */
public class SelectedStuffPage extends Page {
    public SelectedStuffPage(WebDriver webDriver) {super(webDriver);}

    @FindBy(xpath = "//span[@class='add-to-cart__button-text global-form-button__inner']")
    private WebElement addToCartButton;

    private WebElement continueToCartButton;

    public CartPage clickOnAddCartButton() {
        addToCartButton.click();
        customDelay(continueToCartButton).click();
        return new CartPage(Page.getDriver());
    }
}
