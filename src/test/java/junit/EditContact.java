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
public class EditContact {

    private Login loginPage;
    private MainApp mainApp;

    private AppBody appAccount;

    @Before
    public void setUp() {
//        loginPage = new LoginPage();
//        String email = Environment.getInstance().getPrimaryUser();
//        String password = Environment.getInstance().getPrimaryPassword();
//        String userName = Environment.getInstance().getDisplayName();
//        String [] availableFields = {"Created Date","Facebook", "Level"};
//        String [][] filterAdditionalFields = {{"Name","starts with","Juan"},{"Phone","starts with","555"}};
//
//        mainApp = loginPage.loginAs(email,password,userName);
//
//        AppHeader appHeader = mainApp.goToAppHeader();
//        appAccount = appHeader.clickContacts();
//
//        appAccount.clickNewView();
//        ViewPage viewPage = new ViewPageBuilder("New Contact","NewContact01")
//                .setFilterByOwnerMyViewRadioBtn(true)
//                .setfilterByAdditionalField(filterAdditionalFields)
//                .setAvailableFields(availableFields)
//                .setVisibleAllUsersRadioBtn(true)
//                .build();
//        viewPage.createView();
    }

    @Test
    public void testUntitled() {

//        String [] availableFields = {"First Name","Last Name", "Account ID"};
//        String [][] filterAdditionalFields = {{"Name","starts with","Pablo"},{"Phone","starts with","774"}};
//
//        appAccount.setViewComboBox("New Contact");
//        appAccount.clickEditView();
//
//        ViewPage viewPage = new ViewPageBuilder("Contact Edited","ContactEdited02")
//                .setFilterByOwnerAllViewsRadioBtn(true)
//                .setfilterByAdditionalField(filterAdditionalFields)
//                .setAvailableFields(availableFields)
//                .setVisibleOnlyToMeRadioBtn(true)
//                .build();
//        viewPage.createView();
//
//        Assert.assertTrue("Test Passed", appAccount.getSelectedValue("Contact Edited"));

    }

    @After
    public void tearDown() {
//        appAccount.clickDelete();

    }
}
