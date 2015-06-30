package test.java.junit;

import framework.DriverManager;
import framework.Environment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Mario Perez on 6/16/2015.
 */
public class EditLead {

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

    }

    @Test
    public void testUntitled() {

        String [] availableFields = {"Phone","Mobile"};
        String [][] filterAdditionalFields = {{"First Name","equals","Mario"},{"Company","equals","Jalasoft"}};
        appLeads.setViewComboBox("New Lead");
        appLeads.clickEditView();
        ViewPage viewPage = new ViewPageBuilder("Lead Edited","LeadEdited01")
                .setFilterByOwnerAllViewsRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleOnlyToMeRadioBtn(true)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appLeads.getSelectedValue("Lead Edited"));

    }

    @After
    public void tearDown() {
        appLeads.clickDelete();

    }
}
