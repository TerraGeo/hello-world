package pages;

import database.DBConnector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ImageSaver;
import utils.Validator;
import utils.WaitUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static utils.ImageSaver.saveImage;
import static utils.Validator.validator;

/**
 * Created by Billy on 6/29/2016.
 */
public class PhotoPage extends Page {
    @FindBy(xpath = "//span[@class='_bkw5z']")
    private WebElement photoAmount;

    @FindBy(xpath = "//a[@class='_oidfu']")
    private WebElement moreButton;

    @FindBy(xpath = "//div[@class='_jjzlb']//img")
    private List<WebElement> photos;

    public PhotoPage(WebDriver webDriver) {
        super(webDriver);
    }
    public PhotoPage clickOnMoreButton() {
        moreButton.click();
        return this;
    }
    public PhotoPage savePhotosToLocalDrive(){
        int scrollCount = 300;
        int numbOfPosts = Integer.parseInt(photoAmount.getText().replaceAll(",", ""));
        for (int i = 0; i < (numbOfPosts / 12) + 1; i++) {
            ((JavascriptExecutor)getDriver()).executeScript(String.format("scrollBy(0, %d)", scrollCount += 250));
            WaitUtils.delay();
        }
        photos.stream()
                .map((webElement -> validator(webElement.getAttribute("src"))))
                .collect(Collectors.toSet())
                .forEach(str -> saveImage("D:/Java/Images/", str));
        return this;
    }
    public PhotoPage savePhotosToDataBase() {
        int scrollCount = 300;
        int numbOfPosts = Integer.parseInt(photoAmount.getText().replaceAll(",", ""));
        for (int i = 0; i < (numbOfPosts / 12) + 1; i++) {
            ((JavascriptExecutor)getDriver()).executeScript(String.format("scrollBy(0, %d)", scrollCount += 250));
            WaitUtils.delay();
        }
        photos.stream()
                .map((webElement -> validator(webElement.getAttribute("src"))))
                .collect(Collectors.toSet())
                .forEach(str -> DBConnector.getInstance().dbFileWriter(str));
        return this;
    }
}
