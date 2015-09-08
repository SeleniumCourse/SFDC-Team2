package utils;

import components.NavigationTab;
import framework.DriverManager;
import pages.Login;
import pages.MainApp;
import pages.campaign.CampaignDetails;
import pages.campaign.CampaignForm;
import pages.campaign.CampaignHome;
import pages.lead.LeadDetails;
import pages.lead.LeadForm;
import pages.lead.LeadHome;

/**
 * Created by marcelo on 9/7/15.
 */
public class LeadGenie {
    /**
     * Create a Lead object
     *
     * @params campaignName: Campaign Name object to be created
     * @return CampaignDetails object
     */
    public static LeadDetails createLeadObject(String lastName, String company){
        Login login = new Login();
        MainApp mainApp = login.loginAsPrimaryUser();

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        LeadHome leadHome = navigationTab.goToLeadTab();
        LeadForm leadForm = leadHome.clickNewBtn();
        LeadDetails leadDetails = leadForm.setLastName(lastName)
                .setCompany(company)
                .clickSaveBtn();
        return leadDetails;
    }

    public static void deleteLeadAndQuitBrowserDriver(LeadDetails leadDetails) {
        leadDetails.clickDeleteButton(true);
        DriverManager.getInstance().getDriver().quit();
    }


}
