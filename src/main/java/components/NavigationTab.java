package components;

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
import pages.product.ProductHome;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class NavigationTab extends BaseWebUI {

    @FindBy(linkText = "Campaigns")
    @CacheLookup
    private WebElement campaignsTab;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunitiesTab;

    @FindBy(linkText = "Products")
    @CacheLookup
    private WebElement productsTab;

    public NavigationTab() {
    }

    public CampaignHome goToCampaignTab(){
        wait.until(ExpectedConditions.elementToBeClickable(campaignsTab));
        campaignsTab.click();
        return new CampaignHome();
    }

    public OpportunitiesHome goToOpportunityTab() {
        wait.until(ExpectedConditions.elementToBeClickable(opportunitiesTab));
        opportunitiesTab.click();
        return new OpportunitiesHome();
    }

    public ProductHome goToProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productsTab));
        productsTab.click();
        return new ProductHome();
    }
}
