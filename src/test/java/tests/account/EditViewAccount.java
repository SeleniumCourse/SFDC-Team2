package tests.account;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import pages.basepages.BaseViewForm;
import utils.ContactGenie;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class EditViewAccount {

    private BaseViewDetails baseViewDetails;
    private BaseViewForm accountViewForm;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";

    private final String updateViewName = "updatedTesViewOppy02";
    private final String updateViewUniqueName = "updatedViewOppy02";


    @BeforeClass
    public void setUp() {
        baseViewDetails = ContactGenie.createSingleViewContact(viewName, viewUniqueName);
    }

    @Test
    public void editViewLead() {
        accountViewForm = baseViewDetails.clickEditLink();
        baseViewDetails = accountViewForm.setViewNameTxt(updateViewName)
                .setViewUniqueNameTxt(updateViewUniqueName)

                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), updateViewName, " The opportunity view is not updated");
        accountViewForm  = baseViewDetails.clickEditLink();
        Assert.assertEquals(accountViewForm.getViewName(), updateViewName, "The opportunity view name is not updated as expected");
        Assert.assertEquals(accountViewForm.getViewUniqueName(), updateViewUniqueName, "The opportunity view unique name is not updated as expected");
    }

    @AfterClass
    public void tearDown() {
        baseViewDetails = accountViewForm.clickSaveBtn();
        baseViewDetails.clickDeleteBtn();
        DriverManager.getInstance().getDriver().quit();
    }
}
