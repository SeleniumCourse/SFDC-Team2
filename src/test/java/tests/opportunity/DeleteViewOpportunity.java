package tests.opportunity;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import utils.OpportunityGenie;

/**
 * Created by Virginia Sanabria on 9/7/2015.
 */
public class DeleteViewOpportunity {
    private BaseViewDetails baseViewDetails;
    private final String viewName = "deleteTesViewOppy03";
    private final String viewUniqueName = "deleteTesViewOppy03";

    @BeforeClass
    public void setUp() {
        baseViewDetails = OpportunityGenie.createSingleViewOpportunity(viewName, viewUniqueName);
    }

    @Test
    public void deleteViewOpportunity() {
        baseViewDetails.clickDeleteBtn();
        String errorMessage = String.format("The %s view opportunity is displayed yet", viewName);
        Assert.assertNotEquals(baseViewDetails.getFirstSelectedView(), viewName, errorMessage);
    }
}