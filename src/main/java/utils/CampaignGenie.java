package utils;

import components.NavigationTab;
import framework.DriverManager;
import pages.Login;
import pages.MainApp;
import pages.campaign.CampaignDetails;
import pages.campaign.CampaignForm;
import pages.campaign.CampaignHome;

/**
 * Created by Marcelo Ferrufino on 8/31/2015.
 */
public class CampaignGenie {
    private final static boolean ACTIVATE = true;
    private final static String TYPE = "Partners";
    private final static String STATUS = "Completed";
    private final static String START_DATE = "8/25/2015";
    private final static String END_DATE = "8/31/2015";
    private final static String EXPECTED_REVENUE = "300";
    private final static String BUDGETED_COST = "550";
    private final static String ACTUAL_COST = "130";
    private final static String EXPECTED_RESPONSE = "10.00";
    private final static String NUM_SET = "700";
    private final static String DESCRIPTION = "campaign description";

    /**
     * Create a Campaign object
     *
     * @params campaignName: Campaign Name object to be created
     * @return CampaignDetails object
     */
    public static CampaignDetails createCampaignObject(String campaignName){
        Login login = new Login();
        MainApp mainApp = login.loginAsPrimaryUser();

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        CampaignHome campaignHome = navigationTab.goToCampaignTab();
        CampaignForm campaignForm = campaignHome.clickNewBtn();
        CampaignDetails campaignDetails = campaignForm.setCpnName(campaignName)
                .setActive(ACTIVATE)
                .selectType(TYPE)
                .selectStatus(STATUS)
                .setStartDate(START_DATE)
                .setEndDate(END_DATE)
                .setExpectedRevenue(EXPECTED_REVENUE)
                .setBudgetedCost(BUDGETED_COST)
                .setActualCost(ACTUAL_COST)
                .setExpectedResponse(EXPECTED_RESPONSE)
                .setNumSet(NUM_SET)
                .setDescription(DESCRIPTION)
                .clickSaveBtn();
        return campaignDetails;
    }

    public static void deleteCampaignObjectAndQuitBrowserDriver(CampaignDetails campaignDetails){
        campaignDetails.clickDeleteButton(true);
        DriverManager.getInstance().getDriver().quit();
    }

}
