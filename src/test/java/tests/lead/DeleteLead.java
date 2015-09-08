package tests.lead;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.campaign.CampaignHome;
import pages.lead.LeadDetails;
import pages.lead.LeadHome;
import utils.CampaignGenie;
import utils.LeadGenie;

/**
 * Created by marcelo on 9/7/15.
 */
public class DeleteLead {
    private LeadDetails leadDetails;
    private final String LAST_NAME = "HOGG";
    private final String COMPANY = "LEX";
    private final boolean CONFIRMATION = true;

    @BeforeClass
    public void SetUp() {
        leadDetails = LeadGenie.createLeadObject(LAST_NAME, COMPANY);
    }

    @Test
    public void deleteCampaign() {
        LeadHome leadHome = leadDetails.clickDeleteBtn(CONFIRMATION);
        String errorMessage = String.format("The %s lead is still displayed", LAST_NAME);
        Assert.assertFalse(leadHome.isItemPresentInList(LAST_NAME), errorMessage);
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().getDriver().quit();
    }
}
