package tests.contact;

import components.NavigationTab;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.contact.ContactHome;
import pages.contact.ContactViewForm;
import utils.Helper;

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
    private final String valueTxt = "true";
    private final List<String> displayedFields = new ArrayList<String>(asList("Webside"));

    @BeforeClass(groups = {"Acceptance"})
    public void setUp() {
        if (Helper.isLoginPage()) {
            Login login = new Login();
            mainApp = login.loginAsPrimaryUser();
        }else {
            mainApp = new MainApp();
        }
    }

    @Test(groups = {"Acceptance"})
    public void createViewContact() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        ContactHome contactHome = navigationTab.goToContactTab();
        ContactViewForm contactViewForm = contactHome.clickCreateNewViewLnk();
        baseViewDetails = contactViewForm.setViewNameTxt(viewName)
                .setViewUniqueNameTxt(viewUniqueName)
                .setValueTxt(1, valueTxt)
                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), viewName, " The account view was not created");
    }
    @AfterClass
    public void tearDown() {
        baseViewDetails.clickDeleteBtn();
    }
}
