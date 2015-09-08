package tests.account;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.account.AccountDetails;
import pages.account.AccountHome;
import utils.AccountGenie;
import utils.Helper;

/**
 * Created by noelia on 9/6/2015.
 */
public class DeleteAccount {
    private AccountDetails accountDetails;
    private final String ACCOUNT_NAME = Helper.generateUniqueString("Apn");

    @BeforeClass
    public void SetUp() {
        accountDetails = AccountGenie.createAccountObject(ACCOUNT_NAME);
    }

    @Test
    public void deleteCampaign() {
        AccountHome accountHome = accountDetails.clickDeleteBtn(true);

        Assert.assertFalse(accountHome.isAccountPresent(ACCOUNT_NAME));
    }
}
