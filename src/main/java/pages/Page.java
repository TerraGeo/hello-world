package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Billy on 6/29/2016.
 */
public abstract class Page {
    private static ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public Page(WebDriver webDriver) {
        driver.set(webDriver);
        PageFactory.initElements(driver.get(), this);

    }
}
