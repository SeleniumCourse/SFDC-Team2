package tests.contact;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import utils.ContactGenie;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class DeleteViewContact {

    private BaseViewDetails baseViewDetails;
    private final String viewName = "deleteTesViewOppy03";
    private final String viewUniqueName = "deleteTesViewOppy03";

    @BeforeClass
    public void setUp() {
        baseViewDetails = ContactGenie.createSingleViewContact(viewName, viewUniqueName);
    }

    @Test
    public void deleteViewContact() {
        baseViewDetails.clickDeleteBtn();
        String errorMessage = String.format("The %s view contact  is displayed yet", viewName);
        Assert.assertNotEquals(baseViewDetails.getFirstSelectedView(), viewName, errorMessage);
    }
}
