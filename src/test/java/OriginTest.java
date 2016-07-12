import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

/**
 * Created by Billy on 7/5/2016.
 */
public class OriginTest {
    public static final String USER_E_MAIL = "thesunriseempire@ukr.net";
    public static final String PASSWORD = "Valentyn'sTask4";
    protected static String stuffName = "wrenches";

    public static final String HOME_PAGE = "http://www.canadiantire.ca/en.html";
    protected HomePage homePage;
    protected SignInPage signInPage;
    protected AccountPage accountPage;
    protected SearchResultPage searchResultPage;
    protected SelectedStuffPage selectedStuffPage;
    protected CartPage cartPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/WorkSpace/chromedriver_win32/chromedriver.exe");
        homePage = new HomePage(new ChromeDriver());
        Page.getDriver().manage().window().maximize();
    }
    @After
    public void quitFromThePage() {
        if (Page.getDriver() != null)
            Page.getDriver().quit();
    }
}
