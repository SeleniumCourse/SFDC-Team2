package pages;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.account.AccountHome;
import pages.campaign.CampaignHome;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class NavigationTab {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Campaigns")
    @CacheLookup
    private WebElement campaignsLnk;

    @FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountsLnk;

    public NavigationTab(WebDriver driver){
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public CampaignHome goToCampaignHome(){
        wait.until(ExpectedConditions.elementToBeClickable(campaignsLnk));
        campaignsLnk.click();
        return new CampaignHome(driver);
    }
    public AccountHome goToAccountHome(){
        wait.until(ExpectedConditions.elementToBeClickable(accountsLnk));
        accountsLnk.click();
        return new AccountHome(driver);
    }

}
