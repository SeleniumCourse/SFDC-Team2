package tests.contact;

import components.NavigationTab;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.contact.ContactDetails;
import pages.contact.ContactForm;
import pages.contact.ContactHome;
import pages.Login;
import pages.MainApp;
import utils.ContactGenie;
import utils.Helper;
import utils.DataProviders;
/**
 * Created by noelia on 9/6/2015.
 */
public class CreateContact {
    private MainApp mainApp;
    private ContactDetails contactDetails;

    @BeforeClass
    public void setUp() {
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }
    @Test(groups = {"Acceptance"}, dataProvider = "dataProviderContact", dataProviderClass = DataProviders.class)
    public void contact(String FIRSTNAME_mR, String FIRST_NAME, String TITLE, String DEPARTMENT, String BIRTHDAY, String PHONE,
                        String MOBILE, String FAX, String EMAIL, String ASSISTANT, String LANGUAGES, String LEVEL, String DESCRIPTION, String LEAD) {
        String lAST_NAME = Helper.generateUniqueString("LN");

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        ContactHome contactHome = navigationTab.goToContactTab();
        ContactForm contactForm = (ContactForm) contactHome.clickNewBtn();
        contactDetails = contactForm.setLastName(lAST_NAME)
                .selectFirstName(FIRSTNAME_mR)
                .setFirstName(FIRST_NAME)
                .setTitle(TITLE)
                .setDepartament(DEPARTMENT)
                .setBirthDay(BIRTHDAY)
                .selectLead(LEAD)
                .setPhone(PHONE)
                .setMobile(MOBILE)
                .setFax(FAX)
                .setEmail(EMAIL)
                .setAssisPhone(ASSISTANT)
                .setLanguages(LANGUAGES)
                .selectLevel(LEVEL)
                .setDescription(DESCRIPTION)
                .clickSaveBtn();
        Assert.assertEquals(contactDetails.getTitle(),TITLE);
        Assert.assertEquals(contactDetails.getDepartment(), DEPARTMENT);
        Assert.assertEquals(contactDetails.getBirthDay(), BIRTHDAY);
        Assert.assertEquals(contactDetails.getlead(), LEAD);
        Assert.assertEquals(contactDetails.getEmail(), EMAIL);
        Assert.assertEquals(contactDetails.getPhone(), PHONE);
        Assert.assertEquals(contactDetails.getMobilePhone(), MOBILE);
        Assert.assertEquals(contactDetails.getAssistantPhone(), ASSISTANT);
        Assert.assertEquals(contactDetails.getDescription(), DESCRIPTION);
    }

    @AfterClass
    public void tearDown() {

        ContactGenie.deleteContactObjectAndQuitBrowserDriver(contactDetails);
    }
}
