package tests.opportunity;

import components.NavigationTab;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.opportunity.OpportunitiesHome;
import pages.opportunity.OpportunityViewForm;
import utils.Helper;

import static java.util.Arrays.asList;

import java.util.*;

/**
 * Created by Virginia Sanabria on 9/7/2015.
 */
public class CreateViewOpportunity {
    private MainApp mainApp;
    private BaseViewDetails baseViewDetails;

    private final String viewName = "newTesViewOppy01";
    private final String viewUniqueName = "newTesViewOppy01";
    private final String fieldValue = "Closed";
    private final String valueTxt = "true";
    private final List<String> displayedFields = new ArrayList<String>(asList("Closed", "Created Date", "Owner First Name"));

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
    public void createViewOpportunity() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        OpportunitiesHome opportunitiesHome = navigationTab.goToOpportunityTab();
        OpportunityViewForm opportunityViewForm = opportunitiesHome.clickCreateNewViewLnk();
        baseViewDetails = opportunityViewForm.setViewNameTxt(viewName)
                .setViewUniqueNameTxt(viewUniqueName)
                .selectFieldComboBox(1, fieldValue)
                .setValueTxt(1, valueTxt)
                .selectFieldsTodDisplayed(displayedFields)
                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), viewName, " The opportunity view was not created");
    }

    @AfterClass
    public void tearDown() {
        baseViewDetails.clickDeleteBtn();
    }
}
