package tests.opportunity;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import pages.opportunity.OpportunityViewForm;
import utils.OpportunityGenie;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Virginia Sanabria on 9/7/2015.
 */
public class EditViewOpportunity {
    private BaseViewDetails baseViewDetails;
    private OpportunityViewForm opportunityViewForm;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";

    private final String updateViewName = "updatedTesViewOppy02";
    private final String updateViewUniqueName = "updatedViewOppy02";
    private final String fieldValue = "Closed";
    private final String operatorValue = "contains";
    private final String valueTxt = "true";
    private final List<String> displayedFields = new ArrayList<String>(asList("Closed", "Created Date", "Owner First Name"));


    @BeforeClass
    public void setUp() {
        baseViewDetails = OpportunityGenie.createSingleViewOpportunity(viewName, viewUniqueName);
    }

    @Test
    public void editViewOpportunity() {
        opportunityViewForm = baseViewDetails.clickEditLink();
        baseViewDetails = opportunityViewForm.setViewNameTxt(updateViewName)
                .setViewUniqueNameTxt(updateViewUniqueName)
                .selectFieldComboBox(1, fieldValue)
                .setValueTxt(1, valueTxt)
                .selectFieldsTodDisplayed(displayedFields)
                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), updateViewName, " The opportunity view is not updated");
        opportunityViewForm = baseViewDetails.clickEditLink();
        Assert.assertEquals(opportunityViewForm.getViewName(), updateViewName, "The opportunity view name is not updated as expected");
        Assert.assertEquals(opportunityViewForm.getViewUniqueName(), updateViewUniqueName, "The opportunity view unique name is not updated as expected");
    }

    @AfterClass
    public void tearDown() {
        baseViewDetails = opportunityViewForm.clickSaveBtn();
        baseViewDetails.clickDeleteBtn();
        DriverManager.getInstance().getDriver().quit();
    }
}