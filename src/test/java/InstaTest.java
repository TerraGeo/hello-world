import database.DBConnector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static java.lang.System.out;

/**
 * Created by Billy on 6/4/2016.
 */
public class InstaTest {
    public WebDriver webDriver;
    public static final String HOME_PAGE = "https://www.instagram.com";
    public static String USER_NAME = "alechka.vcher";
    public static ImageSaver imageSaver;
    public static int scrollCount = 300;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/WorkSpace/chromedriver_win32/chromedriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        imageSaver = new ImageSaver();
    }

    @Test
    public void userSearchTest() throws InterruptedException {
        webDriver.get(HOME_PAGE + "/" + USER_NAME);
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1500)", "");
        webDriver.findElement(By.xpath("//a[@class='_oidfu']")).click();
        List<WebElement> webElementList1 = webDriver.findElements(By.xpath("//span[@class='_bkw5z']"));
        List<String> linkList2 = new ArrayList<String>();
       // String postAmount = webDriver.findElement(By.xpath("//span[@class='_bkw5z']"));
        for (WebElement web2 : webElementList1) {
            linkList2.add(web2.getText());
        }
        String inner = linkList2.get(0);
        int numbOfPosts = Integer.parseInt(inner.replaceAll(",", ""));
        for (int i = 0; i < (numbOfPosts / 12) + 1; i++) {
            jse.executeScript(String.format("scrollBy(0, %d)", scrollCount += 250));
            Thread.sleep(1000);
        }
        List<WebElement> webElementList = webDriver.findElements(By.xpath("//div[@class='_jjzlb']//img"));
        Set<String> linkSet = new HashSet<String>();
        for (WebElement web : webElementList) {
            linkSet.add(Validator.validator(web.getAttribute("src")));
        }
        linkSet.stream().forEach(out::println);
        System.out.println(linkSet.size());
        for (String str : linkSet) {
            try {
                imageSaver.saveImage("D:/Java/Images/", str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void photosToDB() throws SQLException, ClassNotFoundException, InterruptedException {
        webDriver.get(HOME_PAGE + "/" + USER_NAME);
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1500)", "");
        webDriver.findElement(By.xpath("//a[@class='_oidfu']")).click();
        List<WebElement> webElementList1 = webDriver.findElements(By.xpath("//span[@class='_bkw5z']"));
        List<String> linkList2 = new ArrayList<String>();
        for (WebElement web2 : webElementList1) {
            linkList2.add(web2.getText());
        }
        String inner = linkList2.get(0);
        int numbOfPosts = Integer.parseInt(inner.replaceAll(",", ""));
        for (int i = 0; i < (numbOfPosts / 12) + 1; i++) {
            jse.executeScript(String.format("scrollBy(0, %d)", scrollCount += 250));
            Thread.sleep(1000);
        }
        List<WebElement> webElementList = webDriver.findElements(By.xpath("//div[@class='_jjzlb']//img"));
        Set<String> linkSet = new HashSet<String>();
        for (WebElement web : webElementList) {
            linkSet.add(Validator.validator(web.getAttribute("src")));
        }
        linkSet.stream().forEach(out::println);
        System.out.println(linkSet.size());
        linkSet.stream().forEach(url -> DBConnector.getInstance().dbFileWriter(url));
        /*for (String str : linkSet) {
            DBConnector.getInstance().dbFileWriter(str);
        }*/
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}
