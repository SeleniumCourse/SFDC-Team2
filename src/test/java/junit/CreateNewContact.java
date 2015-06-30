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
public class CreateNewContact {

    private LoginPage loginPage;
    private MainApp mainApp;

    private AppBody appContact;

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

        String [] availableFields = {"Created Date","Facebook", "Level"};
        String [][] filterAdditionalFields = {{"Name","starts with","Juan"},{"Phone","starts with","555"}};

        AppHeader appHeader = mainApp.goToAppHeader();
        appContact = appHeader.clickContacts();

        appContact.clickNewView();
        ViewPage viewPage = new ViewPageBuilder("NewViewJPDS","NewViewJPDSUnique")
                .setFilterByOwnerMyViewRadioBtn(true)
                .setFilterByOwnerAllViewsRadioBtn(true)
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .setVisibleAllUsersRadioBtn(true)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appContact.getSelectedValue("NewViewJPDS"));

    }

    @After
    public void tearDown() {
        appContact.clickDelete();

    }
}
