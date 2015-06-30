package junit;

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
public class EditCampaign {

    private LoginPage loginPage;
    private MainApp mainApp;

    private AppBody appCampaign;

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        String email = Environment.getInstance().getPrimaryUser();
        String password = Environment.getInstance().getPrimaryPassword();
        String userName = Environment.getInstance().getDisplayName();
        String [] availableFields = {"Campaign ID","Parent Campaign"};
        String [][] filterAdditionalFields = {{"Campaign Name","equals","Test"},{"Campaign ID","starts with","CP"}};

        mainApp = loginPage.loginAs(email,password,userName);

        AppHeader appHeader = mainApp.goToAppHeader();
        appCampaign = appHeader.clickCampaigns();

        appCampaign.clickNewView();
        ViewPage viewPage = new ViewPageBuilder("New Campaign","NewCampaign01")
                .setFilterByOwnerMyViewRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleAllUsersRadioBtn(true)
                .build();
        viewPage.createView();
    }

    @Test
    public void testUntitled() {

        String [] availableFields = {"Expected Revenue","Total Leads"};
        String [][] filterAdditionalFields = {{"Total Leads","equals","5"},{"Expected Revenue","greater than","100"}};

        appCampaign.setViewComboBox("New Campaign");
        appCampaign.clickEditView();

        ViewPage viewPage = new ViewPageBuilder("Campaign Edited","CampaignEdited02")
                .setFilterByOwnerAllViewsRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleOnlyToMeRadioBtn(true)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appCampaign.getSelectedValue("Campaign Edited"));

    }

    @After
    public void tearDown() {
        appCampaign.clickDelete();

    }
}
