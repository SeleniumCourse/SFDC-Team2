package tests.account;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.basepages.BaseViewDetails;
import utils.AccountGenie;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class DeleteViewAccount {

    private BaseViewDetails baseViewDetails;
    private final String viewName = "deleteTesViewOppy03";
    private final String viewUniqueName = "deleteTesViewOppy03";

    @BeforeClass
    public void setUp() {
        baseViewDetails = AccountGenie.createSingleViewAccount(viewName, viewUniqueName);
    }

    @Test
    public void deleteViewAccount() {
        baseViewDetails.clickDeleteBtn();
        String errorMessage = String.format("The %s view opportunity is displayed yet", viewName);
        Assert.assertNotEquals(baseViewDetails.getFirstSelectedView(), viewName, errorMessage);
    }
}
