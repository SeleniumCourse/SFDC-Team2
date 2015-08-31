package pages;

import framework.DriverManager;
import pages.campaign.CampaignHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.opportunity.OpportunitiesHome;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class NavigationTab {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Campaigns")
    @CacheLookup
    private WebElement campaignsLnk;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunitiesTab;

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

    public OpportunitiesHome goToOpportunityHome() {
        wait.until(ExpectedConditions.elementToBeClickable( opportunitiesTab));
        opportunitiesTab.click();
        return new OpportunitiesHome();
    }
}
