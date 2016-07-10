import org.junit.Test;
import pages.Page;

/**
 * Created by Billy on 7/5/2016.
 */

public class EntanceTest extends OriginTest {
    @Test
    public void entranceTest() {
        Page.getDriver().get(OriginTest.HOME_PAGE);
        signInPage = homePage.clickOnSignInButton();
        accountPage = signInPage.accountSignIn(USER_E_MAIL, PASSWORD);
        accountPage.customAssertEquals();
    }

    @Test
    public void waresTest() {
        Page.getDriver().get(OriginTest.HOME_PAGE);
        signInPage = homePage.clickOnSignInButton();
        accountPage = signInPage.accountSignIn(USER_E_MAIL, PASSWORD);
        accountPage.customAssertEquals();
        searchResultPage = accountPage.moveToSearchResults(stuffName);
        selectedStuffPage = searchResultPage.moveToStuff();
        cartPage = selectedStuffPage.clickOnAddCartButton();
        cartPage.customAssertEquals2();
    }
}
