package tests.contact;

import components.NavigationTab;
import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Contact.ContactHome;
import pages.Contact.ContactViewForm;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Noelia Melgarejo on 9/7/2015.
 */
public class CreateViewContact {

    private MainApp mainApp;
    private BaseViewDetails baseViewDetails;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";
    //private final String fieldValue = "Closed";
    // private final String operatorValue = "contains";
    private final String valueTxt = "true";
    private final List<String> displayedFields = new ArrayList<String>(asList("Webside"));

    @BeforeClass
    public void setUp() {
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }

    @Test
    public void createViewContact() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        ContactHome contactHome = navigationTab.goToContactTab();
        ContactViewForm contactViewForm = contactHome.clickCreateNewViewLnk();
        baseViewDetails = contactViewForm.setViewNameTxt(viewName)
                .setViewUniqueNameTxt(viewUniqueName)
                        // .selectFieldComboBox(1, fieldValue)
                        //.selectOperatorComboBox(1, operatorValue)
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
