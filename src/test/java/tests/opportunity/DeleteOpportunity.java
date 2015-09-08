package tests.opportunity;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.opportunity.OpportunitiesHome;
import pages.opportunity.OpportunityDetails;
import utils.Helper;
import utils.OpportunityGenie;

/**
 * Created by Virginia Sanabria on 9/5/2015.
 */
public class DeleteOpportunity {
    private final String opptyName = Helper.generateUniqueString("OpptDel");
    private final String accountName = "accountTest3";
    private OpportunityDetails opportunityDetails;

    @BeforeClass
    public void setUp() {
        opportunityDetails = OpportunityGenie.createOpportunityObject(opptyName, accountName);
    }

    @Test
    public void deleteOpportunity() {
        OpportunitiesHome opportunitiesHome = opportunityDetails.clickDeleteBtn(true);
        String errorMessage = String.format("The %s opportunity is displayed yet", opptyName);
        Assert.assertFalse(opportunitiesHome.isItemPresentInList(opptyName), errorMessage);
    }
}
