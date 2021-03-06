package tests.campaign;

import framework.DriverManager;
import utils.CampaignGenie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.campaign.CampaignDetails;
import pages.campaign.CampaignHome;
import utils.Helper;

/**
 * Created by Marcelo Ferrufino on 9/2/2015.
 */
public class DeleteCampaign {
    private CampaignDetails campaignDetails;
    private final String CAMPAIGN_NAME = Helper.generateUniqueString("Cpn");

    @BeforeClass
    public void SetUp() {
        campaignDetails = CampaignGenie.createCampaignObject(CAMPAIGN_NAME);
    }

    @Test
    public void deleteCampaign() {
        CampaignHome campaignHome = campaignDetails.clickDeleteBtn(true);

        Assert.assertFalse(campaignHome.isCampaignPresent(CAMPAIGN_NAME));
    }
}
