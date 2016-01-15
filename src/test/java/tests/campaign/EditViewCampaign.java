package tests.campaign;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import pages.basepages.BaseViewForm;
import pages.campaign.CampaignViewForm;
import pages.opportunity.OpportunityViewForm;
import utils.AccountGenie;
import utils.CampaignGenie;
import utils.LeadGenie;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class EditViewCampaign {
    private BaseViewDetails baseViewDetails;
    private BaseViewForm campaignViewForm;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";

    private final String updateViewName = "updatedTesViewOppy02";
    private final String updateViewUniqueName = "updatedViewOppy02";


    @BeforeClass
    public void setUp() {
        baseViewDetails = CampaignGenie.createSingleViewCampain(viewName, viewUniqueName);
    }

    @Test
    public void editViewCampain() {
        campaignViewForm = baseViewDetails.clickEditLink();
        baseViewDetails = campaignViewForm.setViewNameTxt(updateViewName)
                .setViewUniqueNameTxt(updateViewUniqueName)

                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), updateViewName, " The opportunity view is not updated");
        campaignViewForm  = baseViewDetails.clickEditLink();
        Assert.assertEquals(campaignViewForm.getViewName(), updateViewName, "The opportunity view name is not updated as expected");
        Assert.assertEquals(campaignViewForm.getViewUniqueName(), updateViewUniqueName, "The opportunity view unique name is not updated as expected");
    }

    @AfterClass
    public void tearDown() {
        baseViewDetails = campaignViewForm.clickSaveBtn();
        baseViewDetails.clickDeleteBtn();
    }
}
