package tests.lead;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import utils.ContactGenie;
import utils.LeadGenie;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class DeleteViewLead {
    private BaseViewDetails baseViewDetails;
    private final String viewName = "deleteTesViewOppy03";
    private final String viewUniqueName = "deleteTesViewOppy03";

    @BeforeClass
    public void setUp() {
        baseViewDetails = LeadGenie.createSingleViewLead(viewName, viewUniqueName);
    }

    @Test
    public void deleteViewLead() {
        baseViewDetails.clickDeleteBtn();
        String errorMessage = String.format("The %s view contact  is displayed yet", viewName);
        Assert.assertNotEquals(baseViewDetails.getFirstSelectedView(), viewName, errorMessage);
    }
}
