package junit;

import framework.DriverManager;
import framework.Environment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Mario Perez on 6/10/2015.
 */
public class CreateNewLead {

    private LoginPage loginPage;
    private MainApp mainApp;

    private AppBody appLeads;

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

        AppHeader appHeader = mainApp.goToAppHeader();
        appLeads = appHeader.clickLeads();

        String [] availableFields = {"Last Name","First Name"};
        String [][] filterAdditionalFields = {{"Name","equals","Test"},{"Email","contains","mario.cbba@salesforce.com"}};

        appLeads.clickNewView();
        ViewPage viewPage = new ViewPageBuilder("New Lead","NewLead01")
                .setFilterByOwnerMyViewRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleAllUsersRadioBtn(true)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appLeads.getSelectedValue("New Lead"));

    }

    @After
    public void tearDown() {
        appLeads.clickDelete();

    }
}
