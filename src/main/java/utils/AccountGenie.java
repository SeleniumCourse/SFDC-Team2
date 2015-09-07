package utils;

import components.NavigationTab;
import framework.DriverManager;
import pages.Login;
import pages.MainApp;
import pages.account.AccountDetails;
import pages.account.AccountForm;
import pages.account.AccountHome;

/**
 * Created by noelia on 9/6/2015.
 */
public class AccountGenie {


    private static String accountNumber = "1240";
    private static String accountPhone= "accountPhoneL2";
    private static String accountRevenue= "45";
    private static String accountFax= "accountFax";
    private static String accountTickerSymbol= "accountTickerSymbol";
    private static String accountEmployees= "20";
    private static String accountSICode = "accountSICode";
    private static String accountType = "Installation Partner";
    private static String accountIndustry = "Chemicals";
    private static String accountListOwnership = "Private";
    private static String accountSLA = "Silver";
    private static String accountActive = "Yes";
    private static String accountDescription = "This is la description ";


    /**
     * Create a Account object
     *
     * @params AccountName: Account Name object to be created
     * @return AccountDetails object
     */
    public static AccountDetails createAccountObject(String AccountName){
        Login login = new Login();
        MainApp mainApp = login.loginAsPrimaryUser();

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        AccountHome AccountHome = navigationTab.goToAccountTab();
        AccountForm AccountForm = AccountHome.clickNewBtn();
        AccountDetails accountDetails = AccountForm.setAccountName(AccountName)
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
        return accountDetails;
    }

    public static void deleteAccountObjectAndQuitBrowserDriver(AccountDetails accountDetails){
        accountDetails.clickDeleteButton(true);
        DriverManager.getInstance().getDriver().quit();
    }
}
