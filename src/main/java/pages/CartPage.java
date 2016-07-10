package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CustomDelay;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by Billy on 7/10/2016.
 */
public class CartPage extends Page {
    public CartPage(WebDriver webDriver) {super(webDriver);}

    @FindBy(xpath = "//div[@class='shopping-cart-sub-header__total-count']")
    public WebElement totalAmount;

    public void customAssertEquals2() {
        String correctAmount = "TOTAL: $103.49";
        Assert.assertEquals(CustomDelay.customDelay(visibilityOf(totalAmount)).getText(), correctAmount);
    }
}
