package tests;

import components.NavigationTab;
import framework.DriverManager;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.account.AccountDetails;
import pages.account.AccountForm;
import pages.account.AccountHome;


/**
 * Created by noelia on 8/26/2015.
 */
public class CreateAccount {
    private MainApp mainApp;

    private final String accountName = "AccountName01L2";
    private final String accountNumber = "1240";
    private final String accountPhone= "accountPhoneL2";
    private final String accountRevenue= "45";
    private final String accountFax= "accountFax";
    private final String accountTickerSymbol= "accountTickerSymbol";
    private final String accountEmployees= "20";
    private final String accountSICode = "accountSICode";
    private final String accountBillingStreet = "accountBillingStreetL";
    private final String accountBillingCity = "accountBillingCity";
    private final String accountBillingCountry = "accountBillingCountry";
    private final String accountShippingStreet = "accountShippingStreet";
    private final String accountBillingProvince = "accountBillingProvince";
    private final String accountShippingCountry = "accountShippingCountry";
    private final String accountType = "Installation Partner";
    private final String accountIndustry = "Chemicals";
    private final String accountListOwnership = "Private";
    private final String accountCustomerPriority = "Low";
    private final String accountSLA = "Sylver";
    private final String accountActive = "Yes";
    private final String accountDescription = "This is la description ";

    @BeforeClass
    public void setUp(){
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }

    @Test
    public void createAccount(){

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        AccountHome accountHome = navigationTab.goToAccountHome();
        AccountForm accountForm = accountHome.clickNewBtn();
        AccountDetails accountDetails = accountForm.setAccountName(accountName)
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
                .setAccountBillingStreet(accountBillingStreet)
                .setAccountDescription(accountDescription)
                .clickSaveBtn();
        Assert.assertEquals(accountDetails.getAccountName(), accountName);
        Assert.assertEquals(accountDetails.getAccountNumber(), accountNumber);
        Assert.assertEquals(accountDetails.getAccountType(), accountType);
        Assert.assertEquals(accountDetails.getAccountIndustry(), accountIndustry);
        Assert.assertEquals(accountDetails.getAccountOwnership(), accountListOwnership);
        Assert.assertEquals(accountDetails.getAccountPhone(), accountPhone);
        Assert.assertEquals(accountDetails.getAccountFax(), accountFax);
        Assert.assertEquals(accountDetails.getAccountTikersimbolo(), accountTickerSymbol);
        Assert.assertEquals(accountDetails.getAccountEmployees(), accountEmployees);
        Assert.assertEquals(accountDetails.getAccountSIC(), accountSICode);
        accountDetails.getAccountBillingAddress();
        Assert.assertEquals(accountDetails.getAccountBillingStreet(), accountBillingStreet);
        accountDetails.closeAccountBillingAddress();
        Assert.assertEquals(accountDetails.getAccountDescription(), accountDescription.trim());
    }

    @AfterClass
    public void tearDown(){

     DriverManager.getInstance().getDriver().close();
    }
}
