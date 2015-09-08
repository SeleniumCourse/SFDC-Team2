package tests.lead;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import pages.basepages.BaseViewForm;
import pages.lead.LeadViewForm;
import pages.opportunity.OpportunityViewForm;
import utils.LeadGenie;
import utils.OpportunityGenie;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class EditViewLead {
    private BaseViewDetails baseViewDetails;
    private BaseViewForm leadViewForm;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";

    private final String updateViewName = "updatedTesViewOppy02";
    private final String updateViewUniqueName = "updatedViewOppy02";


    @BeforeClass
    public void setUp() {
        baseViewDetails = LeadGenie.createSingleViewLead(viewName, viewUniqueName);
    }

    @Test
    public void editViewLead() {
        leadViewForm = baseViewDetails.clickEditLink();
        baseViewDetails = leadViewForm.setViewNameTxt(updateViewName)
                .setViewUniqueNameTxt(updateViewUniqueName)

                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), updateViewName, " The opportunity view is not updated");
        leadViewForm  = baseViewDetails.clickEditLink();
        Assert.assertEquals(leadViewForm.getViewName(), updateViewName, "The opportunity view name is not updated as expected");
        Assert.assertEquals(leadViewForm.getViewUniqueName(), updateViewUniqueName, "The opportunity view unique name is not updated as expected");
    }

    @AfterClass
    public void tearDown() {
        baseViewDetails = leadViewForm.clickSaveBtn();
        baseViewDetails.clickDeleteBtn();
        DriverManager.getInstance().getDriver().quit();
    }
}
