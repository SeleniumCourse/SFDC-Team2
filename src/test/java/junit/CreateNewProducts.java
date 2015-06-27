package test.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Fernando Nakamura on 6/26/2015.
 */
public class CreateNewProducts {

    private LoginPage loginPage;
    private MainApp mainApp;

    private AppBody appProducts;

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

        String [] availableFields = {"Create Date","Last Modified Date"};
        String [][] filterAdditionalFields = {{"Product Name","equals","Test"},{"Product Code","equals","Test"}};

        AppHeader appHeader = mainApp.goToAppHeader();
        appProducts = appHeader.clickProducts();

        appProducts.clickNewView();
        ViewPage viewPage = new ViewPageBuilder("NewViewFNC","NewViewFNCUnique")
                .setfilterByAdditionalField(filterAdditionalFields)
                .setAvailableFields(availableFields)
                .build();
        viewPage.createView();

        Assert.assertTrue("Test Passed", appProducts.getSelectedValue("NewViewFNC"));

    }

    @After
    public void tearDown() {
        appProducts.clickDelete();

    }
}
