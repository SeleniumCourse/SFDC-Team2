package tests.account;

import components.NavigationTab;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.account.AccountDetails;
import pages.account.AccountForm;
import pages.account.AccountHome;
import utils.AccountGenie;
import utils.DataProviders;


/**
 * Created by noelia on 8/26/2015.
 */
public class CreateAccount {
    private MainApp mainApp;

    private AccountDetails accountDetails;

    @BeforeClass
    public void setUp(){
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }
    @Test(dataProvider = "dataProviderAccount", dataProviderClass = DataProviders.class)
    public void createAccount(String accountName, String accountNumber,String accountPhone,String accountRevenue,String accountFax,
                              String accountTickerSymbol,String accountEmployees, String accountSICode,String accountType ,String accountIndustry,
                              String accountListOwnership,String accountSLA, String accountActive,String accountDescription){

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        AccountHome accountHome = navigationTab.goToAccountTab();
        AccountForm accountForm = accountHome.clickNewBtn();
        accountDetails = accountForm.setAccountName(accountName)
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

        Assert.assertEquals(accountDetails.getAccountName(), accountName);
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
    public void tearDown(){
        AccountGenie.deleteAccountObjectAndQuitBrowserDriver(accountDetails);
    }
}
