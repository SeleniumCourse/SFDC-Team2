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
public class CreateNewAccount {

    private LoginPage loginPage;
    private MainApp mainApp;

    private AppBody appAccount;

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        String email = Environment.getInstance().getPrimaryUser();
        String password = Environment.getInstance().getPrimaryPassword();
        String userName = Environment.getInstance().getDisplayName();

        mainApp = loginPage.loginAs(email,password,userName);
    }

    @Test
    public void testUntitled() {

        String [] availableFields = {"Billing City","Shipping City", "Account Number"};
        String [][] filterAdditionalFields = {{"Account Name","equals","Test"},{"Phone","starts with","555"}};

        AppHeader appHeader = mainApp.goToAppHeader();
        appAccount = appHeader.clickAccounts();

        appAccount.clickNewView();
        ViewPage viewPage = new ViewPageBuilder("NewViewJPDS","NewViewJPDSUnique")
                .setFilterByOwnerMyViewRadioBtn(true)
                .setFilterByOwnerAllViewsRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleAllUsersRadioBtn(true)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appAccount.getSelectedValue("NewViewJPDS"));

    }

    @After
    public void tearDown() {
        appAccount.clickDelete();

    }
}
