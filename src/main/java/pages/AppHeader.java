package pages;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mario Perez on 6/3/2015.
 */
public class AppHeader {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "phHeaderLogoImage")
    @CacheLookup
    WebElement salesForceImg;

    @FindBy(id = "userNavLabel")
    @CacheLookup
    WebElement userNameLabel;

    @FindBy(xpath = "//a[@title='Logout']")
    @CacheLookup
    WebElement logOutOption;

    @FindBy(linkText = "Leads")
    @CacheLookup
    private WebElement leadsOptionBar;

    @FindBy(linkText = "Campaigns")
    @CacheLookup
    private WebElement campaignsOptionBar;
	
	@FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opporttunitiesOptionBar;

    @FindBy(linkText = "Products")
    @CacheLookup
    private WebElement productsOptionBar;

    public AppHeader(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(5, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(salesForceImg));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    public boolean isSalesForceImgDisplayed() {
        return isElementPresent(salesForceImg);
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isLoggedAsUserName(String userName){

        boolean isLoggerUser = false;

        String userNameLogged = getUserName();

        if (userNameLogged.equals(userName)){
            isLoggerUser = true;
        }
        return isLoggerUser;
    }

    public String getUserName() {
        String userName = "";
        try {

            userName = userNameLabel.getText();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return userName;
    }

    public void logoutUser(){
        userNameLabel.click();
        logOutOption.click();
    }

    public AppBody clickLeads() {
        leadsOptionBar.click();
        return new AppBody(driver);
    }

    public AppBody clickCampaigns() {
        campaignsOptionBar.click();
        return new AppBody(driver);
    }

    public AppBody clickOpportunities() {
        opportunitiesOptionBar.click();
        return new AppBody(driver);
    }
	
	 public AppBody clickProducts() {
        prosductsOptionBar.click();
        return new AppBody(driver);
    }
}	
