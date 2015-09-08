package tests.contact;

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
public class EditViewContact {

    private BaseViewDetails baseViewDetails;
    private BaseViewForm contactViewForm;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";

    private final String updateViewName = "updatedTesViewOppy02";
    private final String updateViewUniqueName = "updatedViewOppy02";


    @BeforeClass
    public void setUp() {
        baseViewDetails = ContactGenie.createSingleViewContact(viewName, viewUniqueName);
    }

    @Test
    public void editViewContact() {
        contactViewForm = baseViewDetails.clickEditLink();
        baseViewDetails = contactViewForm.setViewNameTxt(updateViewName)
                .setViewUniqueNameTxt(updateViewUniqueName)

                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), updateViewName, " The opportunity view is not updated");
        contactViewForm  = baseViewDetails.clickEditLink();
        Assert.assertEquals(contactViewForm.getViewName(), updateViewName, "The opportunity view name is not updated as expected");
        Assert.assertEquals(contactViewForm.getViewUniqueName(), updateViewUniqueName, "The opportunity view unique name is not updated as expected");
    }

    @AfterClass
    public void tearDown() {
        baseViewDetails = contactViewForm.clickSaveBtn();
        baseViewDetails.clickDeleteBtn();
    }
}
