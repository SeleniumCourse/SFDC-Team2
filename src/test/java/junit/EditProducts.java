package junit;

import framework.DriverManager;
import framework.Environment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Fernando Nakamura on 6/26/2015..
 */
public class EditProducts {

    private Login loginPage;
    private MainApp mainApp;

    private AppBody appProducts;

    @Before
    public void setUp() {
//        loginPage = new LoginPage();
//        String email = Environment.getInstance().getPrimaryUser();
//        String password = Environment.getInstance().getPrimaryPassword();
//        String userName = Environment.getInstance().getDisplayName();
//        String [] availableFields = {"Created Date","Last Modified Date"};
//        String [][] filterAdditionalFields = {{"Product Name","equals","Test"},{"Product Code","equals","Test"}};
//
//        mainApp = loginPage.loginAs(email,password,userName);
//
//        AppHeader appHeader = mainApp.goToAppHeader();
//        appProducts = appHeader.clickProducts();
//
//        appProducts.clickNewProductView();
//        ViewPage viewPage = new ViewPageBuilder("New Products","NewProducts01")
//                .setfilterByAdditionalField(filterAdditionalFields)
//                .setAvailableFields(availableFields)
//                .build();
//        viewPage.createView();
    }

    @Test
    public void testUntitled() {

//        String [] availableFields = {"Created By Alias","Last Update By Alias"};
//        String [][] filterAdditionalFields = {{"Product Name","equals","Test"},{"Product Code","equals","Test"}};
//
//        appProducts.setViewComboBox("New Products");
//        appProducts.clickEditView();
//
//        ViewPage viewPage = new ViewPageBuilder("Products Edited","ProductsEdited02")
//                .setfilterByAdditionalField(filterAdditionalFields)
//                .setAvailableFields(availableFields)
//                .build();
//        viewPage.createView();
//
//        Assert.assertTrue("Test Passed", appProducts.getSelectedValue("Products Edited"));

    }

    @After
    public void tearDown() {
//        appProducts.clickDelete();

    }
}
