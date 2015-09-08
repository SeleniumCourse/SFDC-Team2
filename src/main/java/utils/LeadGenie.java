package utils;

import components.NavigationTab;
import framework.DriverManager;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.campaign.CampaignDetails;
import pages.campaign.CampaignForm;
import pages.campaign.CampaignHome;
import pages.lead.LeadDetails;
import pages.lead.LeadForm;
import pages.lead.LeadHome;
import pages.opportunity.OpportunitiesHome;
import pages.opportunity.OpportunityViewForm;

/**
 * Created by marcelo on 9/7/15.
 */
public class LeadGenie {
    /**
     * Create a Lead object
     *
     * @params lastName: Last Name of Lead to be created
     * @params Company: Company Name
     * @return LeadDetails object
     */
    public static LeadDetails createLeadObject(String lastName, String company){
        MainApp mainApp;

        if (Helper.isLoginPage()) {
            Login login = new Login();
            mainApp = login.loginAsPrimaryUser();
        }else {
            mainApp = new MainApp();
        }

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
    }

    public static BaseViewDetails createSingleViewLead(String viewName, String viewUniqueName) {
        Login login = new Login();
        MainApp mainApp = login.loginAsPrimaryUser();
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        OpportunitiesHome opportunitiesHome = navigationTab.goToOpportunityTab();
        OpportunityViewForm opportunityViewForm = opportunitiesHome.clickCreateNewViewLnk();
        BaseViewDetails baseViewDetails = opportunityViewForm.setViewNameTxt(viewName)
                .setViewUniqueNameTxt(viewUniqueName)
                .clickSaveBtn();

        return baseViewDetails;
    }
}
