package tests.account;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.account.AccountDetails;
import pages.account.AccountForm;
import utils.AccountGenie;
import utils.Helper;

/**
 * Created by noelia on 9/6/2015.
 */
public class EditAccount {

    private AccountDetails accountDetails;
    private AccountForm accountForm;

    private final String APN_NAME = Helper.generateUniqueString("Name");
    private final String NEW_APN_NAME = Helper.generateUniqueString("NewCpnName");
    private final String accountNumber = "1240";
    private final String accountPhone= "accountPhoneL2";
    private final String accountRevenue= "45";
    private final String accountFax= "accountFax";
    private final String accountTickerSymbol= "accountTickerSymbol";
    private final String accountEmployees= "20";
    private final String accountSICode = "accountSICode";
    private final String accountType = "Installation Partner";
    private final String accountIndustry = "Chemicals";
    private final String accountListOwnership = "Private";
    private final String accountSLA = "Silver";
    private final String accountActive = "Yes";
    private final String accountDescription = "This is la description ";

    @BeforeClass
    public void setUp(){

        accountDetails = AccountGenie.createAccountObject(APN_NAME);
    }

    @Test
    public void editAccount() {
        accountForm = accountDetails.clickEditBtn();
        accountDetails = accountForm.setAccountName(NEW_APN_NAME)
                .setAccountNumber(accountNumber)
                .selectAccountType(accountType)
                .selectAccountIndustry(accountIndustry)
                .selectAccountOwnership(accountListOwnership)
                .setAccountRevenue(accountRevenue)
                .setAccountPhone(accountPhone)
                .setAccountFax(accountFax)
                .setAccountTickersymbol(accountTickerSymbol)
                .setAccountEmployees(accountEmployees)
                .setAccountSIC(accountSICode)
                .selectAccountActive(accountActive)
                .selectAccountSLA(accountSLA)
                .setAccountDescription(accountDescription)
                .clickSaveBtn();

        Assert.assertEquals(accountDetails.getAccountName(), NEW_APN_NAME);
        Assert.assertEquals(accountDetails.getAccountNumber(), accountNumber);
        Assert.assertEquals(accountDetails.getAccountType(), accountType);
        Assert.assertEquals(accountDetails.getAccountIndustry(), accountIndustry);
        Assert.assertEquals(accountDetails.getAccountOwnership(), accountListOwnership);
        Assert.assertEquals(accountDetails.getAccountRevenue() , accountRevenue);
        Assert.assertEquals(accountDetails.getAccountPhone(), accountPhone);
        Assert.assertEquals(accountDetails.getAccountFax(), accountFax);
        Assert.assertEquals(accountDetails.getAccountTikersimbolo(), accountTickerSymbol);
        Assert.assertEquals(accountDetails.getAccountEmployees(), accountEmployees);
        Assert.assertEquals(accountDetails.getAccountDescription(), accountDescription.trim());
    }

    @AfterClass
    public void tearDown() {
      AccountGenie.deleteAccountObjectAndQuitBrowserDriver(accountDetails);
    }
}
