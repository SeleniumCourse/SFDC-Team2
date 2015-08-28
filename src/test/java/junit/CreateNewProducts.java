package junit;

import framework.DriverManager;
import framework.Environment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Fernando Nakamura on 6/26/2015.
 */
public class CreateNewProducts {

    private Login loginPage;
    private MainApp mainApp;

    private AppBody appProducts;

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

//        String [] availableFields = {"Created Date","Last Modified Date"};
//        String [][] filterAdditionalFields = {{"Product Name","equals","Test"},{"Product Code","equals","Test"}};
//
//        AppHeader appHeader = mainApp.goToAppHeader();
//        appProducts = appHeader.clickProducts();
//
//        appProducts.clickNewProductView();
//        ViewPage viewPage = new ViewPageBuilder("NewViewFNC","NewViewFNCUnique")
//                .setfilterByAdditionalField(filterAdditionalFields)
//                .setAvailableFields(availableFields)
//                .build();
//        viewPage.createView();
//
//        Assert.assertTrue("Test Passed", appProducts.getSelectedValue("NewViewFNC"));

    }

    @After
    public void tearDown() {
//        appProducts.clickDelete();

    }
}
