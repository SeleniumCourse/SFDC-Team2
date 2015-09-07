package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Contact.ContactHome;
import pages.account.AccountHome;
import pages.campaign.CampaignHome;
import pages.lead.LeadHome;
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

    @FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountsTab;

    @FindBy(linkText = "Contacts")
    @CacheLookup
    private WebElement contactsTab;

    @FindBy(linkText = "Products")
    @CacheLookup
    private WebElement productsTab;

    @FindBy(linkText = "Leads")
    @CacheLookup
    private WebElement leadsTab;

    public CampaignHome goToCampaignTab(){
        wait.until(ExpectedConditions.elementToBeClickable(campaignsTab));
        campaignsTab.click();
        return new CampaignHome();
    }
    public AccountHome goToAccountTab(){
        wait.until(ExpectedConditions.elementToBeClickable(accountsTab));
        accountsTab.click();
        return new AccountHome();
    }
    public OpportunitiesHome goToOpportunityTab() {
        wait.until(ExpectedConditions.elementToBeClickable(opportunitiesTab));
        opportunitiesTab.click();
        return new OpportunitiesHome();
    }

    public ContactHome goToContactTab() {
        wait.until(ExpectedConditions.elementToBeClickable(contactsTab));
        contactsTab.click();
        return new ContactHome();
    }

    public ProductHome goToProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productsTab));
        productsTab.click();
        return new ProductHome();
    }

    public LeadHome goToLeadTab() {
        wait.until(ExpectedConditions.elementToBeClickable(leadsTab));
        leadsTab.click();
        return new LeadHome();
    }
}
