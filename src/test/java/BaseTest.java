import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Page;
import pages.PhotoPage;
import java.net.MalformedURLException;

/**
 * Created by Billy on 6/29/2016.
 */
public class BaseTest {
    public static final String HOME_PAGE = "https://www.instagram.com";
    public static String USER_NAME = "alechka.vcher";
    protected PhotoPage photoPage;

    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "D:/WorkSpace/chromedriver_win32/chromedriver.exe");
        photoPage = new PhotoPage(new ChromeDriver());
        Page.getDriver().manage().window().maximize();
    }
    @After
    public void tearDown() {
        if (Page.getDriver() != null)
            Page.getDriver().quit();
    }

}
