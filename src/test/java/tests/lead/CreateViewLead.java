package tests.lead;

import components.NavigationTab;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.lead.LeadHome;
import pages.lead.LeadViewForm;
import utils.Helper;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class CreateViewLead {

    private MainApp mainApp;
    private BaseViewDetails baseViewDetails;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";
    private final String valueTxt = "true";

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
    public void createViewLead() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        LeadHome leadHome = navigationTab.goToLeadTab();
        LeadViewForm leadViewForm = leadHome.clickCreateNewViewLnk();
        baseViewDetails = leadViewForm.setViewNameTxt(viewName)
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
