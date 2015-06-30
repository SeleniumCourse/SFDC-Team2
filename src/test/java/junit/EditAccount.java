package junit;

import framework.Environment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Mario Perez on 6/16/2015.
 */
public class EditAccount {

    private LoginPage loginPage;
    private MainApp mainApp;

    private AppBody appAccount;

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        String email = Environment.getInstance().getPrimaryUser();
        String password = Environment.getInstance().getPrimaryPassword();
        String userName = Environment.getInstance().getDisplayName();
        String [] availableFields = {"Billing City","Shipping City", "Account Number"};
        String [][] filterAdditionalFields = {{"Account Name","equals","Test"},{"Phone","starts with","555"}};

        mainApp = loginPage.loginAs(email,password,userName);

        AppHeader appHeader = mainApp.goToAppHeader();
        appAccount = appHeader.clickAccounts();

        appAccount.clickNewView();
        ViewPage viewPage = new ViewPageBuilder("New Account","NewAccount01")
                .setFilterByOwnerMyViewRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleAllUsersRadioBtn(true)
                .build();
        viewPage.createView();
    }

    @Test
    public void testUntitled() {

        String [] availableFields = {"Fax","Shipping Country"};
        String [][] filterAdditionalFields = {{"Type","contains","Machine"},{"Rating","greater than","100"}};

        appAccount.setViewComboBox("New Account");
        appAccount.clickEditView();

        ViewPage viewPage = new ViewPageBuilder("Account Edited","AccountEdited02")
                .setFilterByOwnerAllViewsRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleOnlyToMeRadioBtn(true)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appAccount.getSelectedValue("Account Edited"));

    }

    @After
    public void tearDown() {
        appAccount.clickDelete();

    }
}
