package utils;

import components.NavigationTab;
import framework.DriverManager;
import framework.LogManager;
import pages.Login;
import pages.MainApp;
import pages.account.AccountDetails;
import pages.account.AccountForm;
import pages.account.AccountHome;
import pages.basepages.BaseViewDetails;
import pages.opportunity.OpportunitiesHome;
import pages.opportunity.OpportunityViewForm;

/**
 * Created by noelia on 9/6/2015.
 */
public class AccountGenie {


    private static String accountNumber = "1240";
    private static String accountPhone = "accountPhoneL2";
    private static String accountRevenue = "45";
    private static String accountFax = "accountFax";
    private static String accountTickerSymbol = "accountTickerSymbol";
    private static String accountEmployees = "20";
    private static String accountSICode = "accountSICode";
    private static String accountType = "Installation Partner";
    private static String accountIndustry = "Chemicals";
    private static String accountListOwnership = "Private";
    private static String accountSLA = "Silver";
    private static String accountActive = "Yes";
    private static String accountDescription = "This is la description ";


    /**
     * Create a account object
     *
     * @return AccountDetails object
     * @params AccountName: account Name object to be created
     */
    public static AccountDetails createAccountObject(String AccountName) {
        MainApp mainApp;

        if (Helper.isLoginPage()) {
            Login login = new Login();
            mainApp = login.loginAsPrimaryUser();
        }else {
            mainApp = new MainApp();
        }

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

    public static void deleteAccountObjectAndQuitBrowserDriver(AccountDetails accountDetails) {
        accountDetails.clickDeleteButton(true);
    }

    public static BaseViewDetails createSingleViewAccount(String viewName, String viewUniqueName) {
        MainApp mainApp;

        if (Helper.isLoginPage()) {
            Login login = new Login();
            mainApp = login.loginAsPrimaryUser();
        }else {
            mainApp = new MainApp();
        }

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        OpportunitiesHome opportunitiesHome = navigationTab.goToOpportunityTab();
        OpportunityViewForm opportunityViewForm = opportunitiesHome.clickCreateNewViewLnk();
        BaseViewDetails baseViewDetails = opportunityViewForm.setViewNameTxt(viewName)
                .setViewUniqueNameTxt(viewUniqueName)
                .clickSaveBtn();

        return baseViewDetails;
    }
}
