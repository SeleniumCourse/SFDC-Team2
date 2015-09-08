package tests.opportunity;

import components.NavigationTab;
import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.opportunity.OpportunitiesHome;
import pages.opportunity.OpportunityForm;
import pages.opportunity.OpportunityViewDetails;
import pages.opportunity.OpportunityViewForm;

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
    private final String operatorValue = "contains";
    private final String valueTxt = "true";
    private final List<String> displayedFields = new ArrayList<String>(asList("Closed", "Created Date", "Owner First Name"));

    @BeforeClass
    public void setUp() {
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }

    @Test
    public void createViewOpportunity() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        OpportunitiesHome opportunitiesHome = navigationTab.goToOpportunityTab();
        OpportunityViewForm opportunityViewForm = opportunitiesHome.clickCreateNewViewLnk();
        baseViewDetails = opportunityViewForm.setViewNameTxt(viewName)
                .setViewUniqueNameTxt(viewUniqueName)
                .selectFieldComboBox(1, fieldValue)
                //.selectOperatorComboBox(1, operatorValue)
                .setValueTxt(1, valueTxt)
                .selectFieldsTodDisplayed(displayedFields)
                .clickSaveBtn();
        Assert.assertEquals(baseViewDetails.getFirstSelectedView(), viewName, " The opportunity view was not created");
    }

    @AfterClass
    public void tearDown() {
        baseViewDetails.clickDeleteBtn();
        DriverManager.getInstance().getDriver().quit();
    }
}
