package tests.opportunity;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.opportunity.OpportunityDetails;
import pages.opportunity.OpportunityForm;
import utils.AccountGenie;
import utils.Helper;
import utils.OpportunityGenie;

/**
 * Created by Virginia Sanabria on 9/5/2015.
 */
public class EditOpportunity {
    private final String opptyName = Helper.generateUniqueString("OpptyName");
    private final String accountName = "accountTest33";
    private final String updateOpptyName = "updateOppty";
    private final String updateAccountName = "accountTest4";
    private final String typeName = "Existing Customer - Replacement";
    private final String leadSource = "Phone Inquiry";
    private final String amount = "15.03";
    private final String closeDate = "9/15/2015";
    private final String nextStep = "nextSTep1";
    private final String stage = "Qualification";
    private final String probability = "13";
    private final String orderNumber = "15";
    private final String currentGenerator = "updateGenerator16";
    private final String trackingNumber = "17";
    private final String mainCompetitor = "updateCompetitor1";
    private final String deliveryInstallStatus = "Yet to begin";
    private final String description = "this is updated opportunity";
    private OpportunityDetails opportunityDetails;
    private OpportunityForm opportunityForm;

    @BeforeClass
    public void setUp() {
        AccountGenie.createAccountObject(updateAccountName);
        opportunityDetails = OpportunityGenie.createOpportunityObject(opptyName, accountName);
    }

    @Test
    public void editOpportunity() {
        opportunityForm = opportunityDetails.clickEditBtn();
        opportunityDetails =  opportunityForm.setOpyName(updateOpptyName)
                .setAccount(updateAccountName)
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

        Assert.assertEquals(opportunityDetails.getOpportunityNameContainer(), updateOpptyName, "The opportunity name is not updated as expected");
        Assert.assertEquals(opportunityDetails.getAccountNameTxtContainer(), updateAccountName, "The account name is not updated as expected");
        Assert.assertEquals(opportunityDetails.getTypeComBoxContainer(), typeName, "The type is not updated as expected");
        Assert.assertEquals(opportunityDetails.getLeadSourceContainer(), leadSource, "The lead source is not updated as expected");
        Assert.assertEquals(opportunityDetails.getAmount(), amount, "The amount is not updated as expected");
        Assert.assertEquals(opportunityDetails.getCloseDateValue(), closeDate, "The close date is not updated as expected");
        Assert.assertEquals(opportunityDetails.getNexStep(), nextStep, "The next step is not updated as expected");
        Assert.assertEquals(opportunityDetails.getStageValue(), stage, "The stage value is not updated as expected");
        Assert.assertEquals(opportunityDetails.getProbability(), probability, "The probability is not updated as  expected");
        Assert.assertEquals(opportunityDetails.getOrderNumber(), orderNumber, "The order number is not updated as expected");
        Assert.assertEquals(opportunityDetails.getCurrentGenerator(), currentGenerator, "The current generator is not updated as expected");
        Assert.assertEquals(opportunityDetails.getTrackingNumber(), trackingNumber, "The tracking number is not updated as expected");
        Assert.assertEquals(opportunityDetails.getMainCompetitor(), mainCompetitor, "The main competitor is not updated as expected");
        Assert.assertEquals(opportunityDetails.getDeliveryInstallStatus(), deliveryInstallStatus, "The delivery install status is not updated as expected");
        Assert.assertEquals(opportunityDetails.getDescription(), description, "The description is not updated as  expected");
    }

    @AfterClass
    public void tearDown() {
        OpportunityGenie.deleteOpportunityAndQuitBrowserDriver(opportunityDetails);
    }
}
