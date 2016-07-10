package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Billy on 7/5/2016.
 */
public abstract class Page {
    private static ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(){return driver.get();}

    public Page (WebDriver webDriver) {
        driver.set(webDriver);
        PageFactory.initElements(driver.get(), this);
    }

}
