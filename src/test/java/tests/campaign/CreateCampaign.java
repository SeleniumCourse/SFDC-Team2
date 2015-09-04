package tests.campaign;

import framework.Helper;
import framework.objectsgenie.CampaignGenie;
import pages.campaign.CampaignDetails;
import pages.campaign.CampaignForm;
import pages.campaign.CampaignHome;
import pages.Login;
import pages.MainApp;
import pages.NavigationTab;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class CreateCampaign {
    private MainApp mainApp;
    private CampaignDetails campaignDetails;

    private final String CPN_NAME = Helper.generateUniqueString("CpnName");
    private final String TYPE = "Partners";
    private final String STATUS = "Completed";
    private final String START_DATE = "8/22/2015";
    private final String END_DATE = "8/29/2015";
    private final String EXPECTED_REVENUE = "100";
    private final String BUDGETED_COST = "150";
    private final String ACTUAL_COST = "130";
    private final String EXPECTED_RESPONSE = "10.00";
    private final String NUM_SET = "100";
    private final boolean ACTIVATE = true;
    private final String TEXT_DESC = "text description";

    @BeforeClass
    public void setUp() {
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }

    @Test
    public void createCampaign() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        CampaignHome campaignHome = navigationTab.goToCampaignTab();
        CampaignForm campaignForm = campaignHome.clickNewBtn();
        campaignDetails = campaignForm.setCpnName(CPN_NAME)
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
                .setDescription(TEXT_DESC)
                .clickSaveBtn();

        Assert.assertEquals(campaignDetails.getCampaignName(), CPN_NAME);
        Assert.assertTrue(campaignDetails.getActiveStatus());
        Assert.assertEquals(campaignDetails.getType(), TYPE);
        Assert.assertEquals(campaignDetails.getStatus(), STATUS);
        Assert.assertEquals(campaignDetails.getStartDate(), START_DATE);
        Assert.assertEquals(campaignDetails.getEndDate(), END_DATE);
        Assert.assertEquals(campaignDetails.getExpectedRevenue(), EXPECTED_REVENUE);
        Assert.assertEquals(campaignDetails.getBudgetedCost(), BUDGETED_COST);
        Assert.assertEquals(campaignDetails.getActualCost(), ACTUAL_COST);
        Assert.assertEquals(campaignDetails.getExpectedResponse(), EXPECTED_RESPONSE.concat("%"));
        Assert.assertEquals(campaignDetails.getNumSet(), NUM_SET);
        Assert.assertEquals(campaignDetails.getDescription(), TEXT_DESC);
    }

    @AfterClass
    public void tearDown() {
        CampaignGenie.deleteCampaignObjectAndQuitBrowserDriver(campaignDetails);
    }
}
