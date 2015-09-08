package utils;

import components.NavigationTab;
import framework.DriverManager;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.opportunity.OpportunitiesHome;
import pages.opportunity.OpportunityDetails;
import pages.opportunity.OpportunityForm;
import pages.opportunity.OpportunityViewForm;

/**
 * Created by Virginia Sanabria on 9/5/2015.
 */
public class OpportunityGenie {

    private final static String closeDate  = "8/11/2015";
    private final static String stage = "Prospecting";

    public static OpportunityDetails createOpportunityObject(String opptyName, String accountName) {
        MainApp mainApp;

        if (Helper.isLoginPage()) {
            Login login = new Login();
            mainApp = login.loginAsPrimaryUser();
        }else {
            mainApp = new MainApp();
        }

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        OpportunitiesHome opportunitiesHome = navigationTab.goToOpportunityTab();
        OpportunityForm opportunityForm = opportunitiesHome.clickNewBtn();
        OpportunityDetails opportunityDetails = opportunityForm.setOpyName(opptyName)
                .setAccount(accountName)
                .setCloseDate(closeDate)
                .selectStage(stage)
                .clickSaveBtn();
        return opportunityDetails;
    }

    public static void deleteOpportunityAndQuitBrowserDriver(OpportunityDetails opportunityDetails) {
        opportunityDetails.clickDeleteButton(true);
    }

    public static BaseViewDetails createSingleViewOpportunity(String viewName, String viewUniqueName) {
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
