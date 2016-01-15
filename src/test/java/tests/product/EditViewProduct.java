package tests.product;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import pages.basepages.BaseViewForm;
import utils.LeadGenie;
import utils.ProductGenie;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class EditViewProduct {
    private BaseViewDetails baseViewDetails;
    private BaseViewForm productViewForm;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";

    private final String updateViewName = "updatedTesViewOppy02";
    private final String updateViewUniqueName = "updatedViewOppy02";


    @BeforeClass
    public void setUp() {
        baseViewDetails = ProductGenie.createSingleViewProduct(viewName, viewUniqueName);
    }

    @Test
    public void editViewProduct() {
        productViewForm = baseViewDetails.clickEditLink();
        baseViewDetails = productViewForm.setViewNameTxt(updateViewName)
                .setViewUniqueNameTxt(updateViewUniqueName)

                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), updateViewName, " The opportunity view is not updated");
        productViewForm  = baseViewDetails.clickEditLink();
        Assert.assertEquals(productViewForm.getViewName(), updateViewName, "The opportunity view name is not updated as expected");
        Assert.assertEquals(productViewForm.getViewUniqueName(), updateViewUniqueName, "The opportunity view unique name is not updated as expected");
    }

    @AfterClass
    public void tearDown() {
        baseViewDetails = productViewForm.clickSaveBtn();
        baseViewDetails.clickDeleteBtn();
    }
}
