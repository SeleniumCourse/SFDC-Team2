package tests.product;

import components.NavigationTab;
import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.lead.LeadHome;
import pages.lead.LeadViewForm;
import pages.product.ProductHome;
import pages.product.ProductViewForm;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class CreateViewProduct {
    private MainApp mainApp;
    private BaseViewDetails baseViewDetails;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";
    private final String valueTxt = "true";
    private final List<String> displayedFields = new ArrayList<String>(asList("Webside"));

    @BeforeClass
    public void setUp() {
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }

    @Test
    public void createViewProduct() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        ProductHome productHome = navigationTab.goToProductTab();
        ProductViewForm productViewForm = productHome.clickCreateNewViewLnk();
        baseViewDetails = productViewForm.setViewNameTxt(viewName)
                .setViewUniqueNameTxt(viewUniqueName)
                .setValueTxt(1, valueTxt)
                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), viewName, " The account view was not created");
    }
    @AfterClass
    public void tearDown() {
        baseViewDetails.clickDeleteBtn();
        DriverManager.getInstance().getDriver().quit();
    }
}
