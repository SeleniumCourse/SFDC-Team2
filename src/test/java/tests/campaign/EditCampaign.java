package tests.campaign;

import framework.DriverManager;
import framework.Helper;
import framework.objectsgenie.CampaignGenie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.campaign.*;

/**
 * Created by Marcelo Ferrufino on 8/31/2015.
 */
public class EditCampaign {
    private CampaignDetails campaignDetails;
    private CampaignForm campaignForm;

    private final String CPN_NAME = Helper.generateUniqueString("CpnName");
    private final boolean ACTIVATE = false;
    private final String NEW_CPN_NAME = Helper.generateUniqueString("NewCpnName");
    private final String TYPE = "Partners";
    private final String STATUS = "Completed";
    private final String START_DATE = "8/22/2015";
    private final String END_DATE = "8/29/2015";
    private final String EXPECTED_REVENUE = "100";
    private final String BUDGETED_REVENUE = "150";
    private final String ACTUAL_COST = "130";
    private final String EXPECTED_RESPONSE = "10.00";
    private final String NUM_SET = "100";
    private final String DESC = "Campaign desc";

    @BeforeClass
    public void setUp() {
        campaignDetails = CampaignGenie.createCampaignObject(CPN_NAME);
    }

    @Test
    public void editCampaign() {
        campaignForm = campaignDetails.clickEditBtn();
        campaignDetails = campaignForm.setCpnName(NEW_CPN_NAME)
                .setActive(ACTIVATE)
                .selectType(TYPE)
                .selectStatus(STATUS)
                .setStartDate(START_DATE)
                .setEndDate(END_DATE)
                .setExpectedRevenue(EXPECTED_REVENUE)
                .setBudgetedCost(BUDGETED_REVENUE)
                .setActualCost(ACTUAL_COST)
                .setExpectedResponse(EXPECTED_RESPONSE)
                .setNumSet(NUM_SET)
                .setDescription(DESC)
                .clickSaveBtn();

        Assert.assertEquals(campaignDetails.getCampaignName(), NEW_CPN_NAME);
        Assert.assertFalse(campaignDetails.getActiveStatus());
        Assert.assertEquals(campaignDetails.getType(), TYPE);
        Assert.assertEquals(campaignDetails.getStatus(), STATUS);
        Assert.assertEquals(campaignDetails.getStartDate(), START_DATE);
        Assert.assertEquals(campaignDetails.getEndDate(), END_DATE);
        Assert.assertEquals(campaignDetails.getExpectedRevenue(), EXPECTED_REVENUE);
        Assert.assertEquals(campaignDetails.getBudgetedCost(), BUDGETED_REVENUE);
        Assert.assertEquals(campaignDetails.getActualCost(), ACTUAL_COST);
        Assert.assertEquals(campaignDetails.getExpectedResponse(), EXPECTED_RESPONSE.concat("%"));
        Assert.assertEquals(campaignDetails.getNumSet(), NUM_SET);
        Assert.assertEquals(campaignDetails.getDescription(), DESC);
    }

    @AfterClass
    public void tearDown() {
        CampaignGenie.deleteCampaignObjectAndQuitBrowserDriver(campaignDetails);
    }

}
