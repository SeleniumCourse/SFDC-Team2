package tests;

import pages.campaign.CampaignDetails;
import pages.campaign.CampaignForm;
import pages.campaign.CampaignHome;
import pages.Login;
import pages.MainApp;
import components.NavigationTab;
import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class CreateCampaign {
    private MainApp mainApp;

    private final String cpnName = "CampaignName01";
    private final String type = "Partners";
    private final String status = "Completed";
    private final String startDate = "8/22/2015";
    private final String endDate = "8/29/2015";
    private final String expectedRevenue = "100";
    private final String budgetedCost = "150";
    private final String actualCost = "130";
    private final String expectedResponse = "10.00";
    private final String numSet = "100";
    private final String description = "description of new " + cpnName;

    @BeforeClass
    public void setUp(){
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }

    @Test
    public void createCampaign(){
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        CampaignHome campaignHome = navigationTab.goToCampaignTab();
        CampaignForm campaignForm = campaignHome.clickNewBtn();
        CampaignDetails campaignDetails = campaignForm.setCpnName(cpnName)
                .checkActive()
                .selectType(type)
                .selectStatus(status)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setExpectedRevenue(expectedRevenue)
                .setBudgetedCost(budgetedCost)
                .setActualCost(actualCost)
                .setExpectedResponse(expectedResponse)
                .setNumSet(numSet)
                .setDescription(description)
                .clickSaveBtn();

        Assert.assertEquals(campaignDetails.getCampaignName(), cpnName);
        Assert.assertTrue(campaignDetails.getActiveStatus());
        Assert.assertEquals(campaignDetails.getType(), type);
        Assert.assertEquals(campaignDetails.getStatus(), status);
        Assert.assertEquals(campaignDetails.getStartDate(), startDate);
        Assert.assertEquals(campaignDetails.getEndDate(), endDate);
        Assert.assertEquals(campaignDetails.getExpectedRevenue(), expectedRevenue);
        Assert.assertEquals(campaignDetails.getBudgetedCost(), budgetedCost);
        Assert.assertEquals(campaignDetails.getActualCost(), actualCost);
        Assert.assertEquals(campaignDetails.getExpectedResponse(), expectedResponse.concat("%"));
        Assert.assertEquals(campaignDetails.getNumSet(), numSet);
        Assert.assertEquals(campaignDetails.getDescription(), description);
    }

    @AfterClass
    public void tearDown(){
        DriverManager.getInstance().getDriver().close();
    }
}
