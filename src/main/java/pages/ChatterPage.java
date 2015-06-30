package pages;

import framework.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Xenia Sanchez on 6/15/2015.
 */
public class ChatterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String shareMessage = null;
    private String replyMessage = null;

    @FindBy(id = "publishereditablearea")
    @CacheLookup
    WebElement postTextArea;

    @FindBy(id = "publishersharebutton")
    @CacheLookup
    WebElement buttonPostArea;

    @FindBy(linkText = "Comment")
    @CacheLookup
    WebElement commentReplyLink;

    @FindBy(id = "ext-gen1")
    @CacheLookup
    WebElement commentReplyTextArea;

    @FindBy(linkText = "Comment")
    @CacheLookup
    WebElement buttonReplyComment;

    @FindBy(className = "zen-select ")
    @CacheLookup
    WebElement actionMenu;

    @FindBy(linkText = "Delete")
    @CacheLookup
    WebElement deletePost;

    public ChatterPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        try {
            wait.until(ExpectedConditions.visibilityOf(postTextArea));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        }
    }

    public void shareComment(String comment) {
        try {
            wait.until(ExpectedConditions.visibilityOf(postTextArea));
            shareMessage = comment;
            postTextArea.clear();
            postTextArea.sendKeys(comment);
            buttonPostArea.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        }
    }

    public void replyComment(String replyComment) {
        try {
            wait.until(ExpectedConditions.visibilityOf(postTextArea));
            replyMessage = replyComment;
            //commentReplyLink.click();
            List<WebElement> comnent = driver.findElements(By.linkText( "Comment"));
            comnent.get(1).click();

            commentReplyTextArea.clear();
            commentReplyTextArea.sendKeys(replyComment);
            buttonReplyComment.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        }
    }

    public void clickDeletePost() {
        actionMenu.click();
        deletePost.click();
        Alert alert = driver.switchTo().alert();
        // Click the OK button in the Alert
        alert.accept();
     }

    public Boolean getResults() {
        if (replyMessage != null)
            return true;
        else
            return false;
    }
}
