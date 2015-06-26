package test.junit;

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
        String email = "mario.cbba@salesforce.com";
        String password = "mario123";
        String userName = "Mario Perez";

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
