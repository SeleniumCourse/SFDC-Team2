package test.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Fernando Nakamura on 6/26/2015..
 */
public class EditOpportunities {

    private LoginPage loginPage;
    private MainApp mainApp;

    private AppBody appOpportunities;

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        String email = "f_nak@hotmail.com";
        String password = "abc123456";
        String userName = "Fernando Nakamura";
        String [] availableFields = {"Private","Closed"};
        String [][] filterAdditionalFields = {{"Opportunity Name","equals","Test"},{"Account Site","equals","Test"}};

        mainApp = loginPage.loginAs(email,password,userName);

        AppHeader appHeader = mainApp.goToAppHeader();
        appOpportunities = appHeader.clickOpportunities();

        appOpportunities.clickNewView();
        ViewPage viewPage = new ViewPageBuilder("New Opportunities","NewOpportunities01")
                .setFilterByOwnerMyViewRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleAllUsersRadioBtn(true)
                .build();
        viewPage.createView();
    }

    @Test
    public void testUntitled() {

        String [] availableFields = {"Won","Account Site"};
        String [][] filterAdditionalFields = {{"Amount","equals","5"},{"Quantity","greater than","5"}};

        appOpportunities.setViewComboBox("New Opportunities");
        appOpportunities.clickEditView();

        ViewPage viewPage = new ViewPageBuilder("Opportunities Edited","OpportunitiesEdited02")
                .setFilterByOwnerAllViewsRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleOnlyToMeRadioBtn(true)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appOpportunities.getSelectedValue("Opportunities Edited"));

    }

    @After
    public void tearDown() {
        appOpportunities.clickDelete();

    }
}
