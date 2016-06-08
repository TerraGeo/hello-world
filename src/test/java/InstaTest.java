import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

/**
 * Created by Billy on 6/4/2016.
 */
public class InstaTest {
    public Validator linkToImageName;
    public WebDriver webDriver;
    public static final String HOME_PAGE = "https://www.instagram.com";
    public static String USER_NAME = "kimkardashian";
    public static ImageSaver imageSaver;
    public static int scrollCount = 300;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/WorkSpace/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        imageSaver = new ImageSaver();
    }

    @Test
    public void userSearchTest() throws InterruptedException {
        webDriver.get(HOME_PAGE + "/" + USER_NAME);
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1500)", "");
        webDriver.findElement(By.xpath("//a[@class='_oidfu']")).click();
        List<WebElement> webElementList1 = webDriver.findElements(By.xpath("//span[@class='_e8fkl']"));
        List<String> linkList2 = new ArrayList<String>();
        for (WebElement web2 : webElementList1) {
            linkList2.add(web2.getText());
        }
        String inner = linkList2.get(0);
        int numbOfPosts = Integer.parseInt(inner.replaceAll(",", ""));
        for (int i = 0; i < (numbOfPosts + 2) / 12; i++) {
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

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}
