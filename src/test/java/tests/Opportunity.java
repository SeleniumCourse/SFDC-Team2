package tests;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import components.NavigationTab;
import pages.opportunity.OpportunitiesHome;
import pages.opportunity.OpportunityDetails;
import pages.opportunity.OpportunityForm;

/**
 * Created by Virginia Sanabria on 8/27/2015.
 */
public class Opportunity {
    private MainApp mainApp;

    private final String opportunityName = "virginiaOp777";
    private final String accountName = "accountTest3";
    private final String typeName = "Existing Customer - Replacement";
    private final String leadSource = "Phone Inquiry";
    private final String amount = "12";
    private final String closeDate = "8/11/2015";
    private final String nextStep = "nextSTep1";
    private final String stage = "Prospecting";
    private final String probability = "13";
    private final String orderNumber = "14";
    private final String currentGenerator = "generator15";
    private final String trackingNumber = "16";
    private final String mainCompetitor = "competitor1";
    private final String deliveryInstallStatus = "Yet to begin";
    private final String description = "this is new opportunity";

    @BeforeClass
    public void setUp(){
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
        //TOD create an account
    }

    @Test
    public void createOpportunity(){
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        OpportunitiesHome opportunitiesHome = navigationTab.goToOpportunityTab();
        OpportunityForm opportunityForm = opportunitiesHome.clickNewBtn();
        OpportunityDetails opportunityDetails = opportunityForm.setOpyName(opportunityName)
                .setAccount(accountName)
                .selectType(typeName)
                .selectLeadSource(leadSource)
                .setAmount(amount)
                .setCloseDate(closeDate)
                .setNextStep(nextStep)
                .selectStage(stage)
                .setProbability(probability)
                .setOrderNumber(orderNumber)
                .setCurrentGenerator(currentGenerator)
                .setTrackingNumber(trackingNumber)
                .setMainCompetitor(mainCompetitor)
                .selectDeliveryInstallStatus(deliveryInstallStatus)
                .setDescription(description)
                .clickSaveBtn();

        Assert.assertEquals(opportunityDetails.getOpportunityNameContainer(), opportunityName, "The opportunity name is not the expected");
        Assert.assertEquals(opportunityDetails.getAccountNameTxtContainer(), accountName, "The account name is not the expected");
        Assert.assertEquals(opportunityDetails.getTypeComBoxContainer(), typeName, "The type is not the expected");
        Assert.assertEquals(opportunityDetails.getLeadSourceContainer(), leadSource, "The lead source is not the expected");
        Assert.assertEquals(opportunityDetails.getAmount(), amount, "The amount is not the expected");
        Assert.assertEquals(opportunityDetails.getCloseDateValue(), closeDate, "The close date is not the expected");
        Assert.assertEquals(opportunityDetails.getNexStep(), nextStep, "The next step is not the expected");
        Assert.assertEquals(opportunityDetails.getStageValue(), stage, "The stage value is not the expected");
        Assert.assertEquals(opportunityDetails.getProbability(), probability, "The probability is not the expected");
        Assert.assertEquals(opportunityDetails.getOrderNumber(), orderNumber, "The order number is not the expected");
        Assert.assertEquals(opportunityDetails.getCurrentGenerator(), currentGenerator, "The current generator is not the expected");
        Assert.assertEquals(opportunityDetails.getTrackingNumber(), trackingNumber, "The tracking number is not the expected");
        Assert.assertEquals(opportunityDetails.getMainCompetitor(), mainCompetitor, "The main competitor is not the expected");
        Assert.assertEquals(opportunityDetails.getDeliveryInstallStatus(), deliveryInstallStatus, "The delivery install status is not the expected");
        Assert.assertEquals(opportunityDetails.getDescription(), description, "The description is not the expected");
    }

    @AfterClass
    public void tearDown(){
        DriverManager.getInstance().getDriver().close();
    }
}
