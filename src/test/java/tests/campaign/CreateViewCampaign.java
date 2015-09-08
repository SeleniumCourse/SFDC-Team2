package tests.campaign;

import components.NavigationTab;
import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.campaign.CampaignHome;
import pages.campaign.CampaignViewForm;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Noelia Melgarejo on 9/8/2015.
 */
public class CreateViewCampaign {
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
    public void createViewCampain() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        CampaignHome campaignHome=navigationTab.goToCampaignTab();
        CampaignViewForm campainViewForm = campaignHome.clickCreateNewViewLnk();
        baseViewDetails = campainViewForm.setViewNameTxt(viewName)
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


