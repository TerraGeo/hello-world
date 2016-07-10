package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;

/**
 * Created by Billy on 7/5/2016.
 */
public class CustomDelay {
    public static WebElement customDelay (WebElement webElement) {
        return customDelay(ExpectedConditions.elementToBeClickable(webElement));
    }
    public static WebElement customDelay (ExpectedCondition<WebElement> expectedCondition) {
        WebDriverWait wait = new WebDriverWait(Page.getDriver(), 3);
        return wait.until(expectedCondition);
    }
}
