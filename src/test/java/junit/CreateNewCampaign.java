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
public class CreateNewCampaign {

    private Login loginPage;
    private MainApp mainApp;

    private AppBody appCampaign;

    @Before
    public void setUp() {
//        loginPage = new LoginPage();
//        String email = Environment.getInstance().getPrimaryUser();
//        String password = Environment.getInstance().getPrimaryPassword();
//        String userName = Environment.getInstance().getDisplayName();
//
//        mainApp = loginPage.loginAs(email,password,userName);
    }

    @Test
    public void testUntitled() {

//        String [] availableFields = {"Campaign ID","Parent Campaign"};
//        String [][] filterAdditionalFields = {{"Campaign Name","equals","Test"},{"Campaign ID","starts with","CP"}};
//
//        AppHeader appHeader = mainApp.goToAppHeader();
//        appCampaign = appHeader.clickCampaigns();
//
//        appCampaign.clickNewView();
//        ViewPage viewPage = new ViewPageBuilder("NewViewMPZ","NewViewMPZUnique")
//                .setFilterByOwnerMyViewRadioBtn(true)
//                .setFilterByOwnerAllViewsRadioBtn(true)
//                .setfilterByAdditionalField(filterAdditionalFields)
//                .setAvailableFields(availableFields)
//                .setVisibleAllUsersRadioBtn(true)
//                .build();
//        viewPage.createView();
//
//        Assert.assertTrue("Test Passed", appCampaign.getSelectedValue("NewViewMPZ"));

    }

    @After
    public void tearDown() {
//        appCampaign.clickDelete();

    }
}
