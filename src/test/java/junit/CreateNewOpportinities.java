package test.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Fernando Nakamura on 6/26/2015.
 */
public class CreateNewOpportunities {

    private LoginPage loginPage;
    private MainApp mainApp;

    private AppBody appOpportunities;

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        String email = "f_nak@hotmail.com";
        String password = "abc123456";
        String userName = "Fernando Nakamura";

        mainApp = loginPage.loginAs(email,password,userName);
    }

    @Test
    public void testUntitled() {

        String [] availableFields = {"Private","Closed"};
        String [][] filterAdditionalFields = {{"Opportunity Name","equals","Test"},{"Account Name","equals","Test"}};

        AppHeader appHeader = mainApp.goToAppHeader();
        appOportunities = appHeader.clickOportunities();

        appOpportunities.clickNewView();
        ViewPage viewPage = new ViewPageBuilder("NewViewFNC","NewViewFNCUnique")
                .setFilterByOwnerMyViewRadioBtn(true)
                .setFilterByOwnerAllViewsRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleAllUsersRadioBtn(true)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appOpportunities.getSelectedValue("NewViewFNC"));

    }

    @After
    public void tearDown() {
        appOpportinities.clickDelete();

    }
}
