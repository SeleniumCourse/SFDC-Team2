package tests.contact;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Contact.ContactDetails;
import pages.Contact.ContactForm;
import utils.ContactGenie;
import utils.Helper;

/**
 * Created by noelia on 9/6/2015.
 */
public class EditContact {
    private ContactDetails contactDetails;
    private ContactForm contactForm;

    private final String LAST_NAME = Helper.generateUniqueString("C");
    private final String NEW_LAST_NAME = Helper.generateUniqueString("New");
    private final String FIRSTNAME_mR = "Mr.";
    private final String FIRST_NAME = "JUSTIN";
    private final String TITLE = "title";
    private final String DEPARTMENT = "florida";
    private final String BIRTHDAY = "8/22/2015";
    private final String LEAD = "Web";
    private final String PHONE = "456666";
    private final String MOBILE = "998852456";
    private final String FAX = "faxx";
    private final String EMAIL = "noelia@gmail.com";
    private final String ASSISTANT = "assistant";
    private final String LANGUAGES = "English";
    private final String LEVEL = "Secondary";
    private final String DESCRIPTION = "text description";

    @BeforeClass
    public void setUp() {
        contactDetails = ContactGenie.createContactObject(LAST_NAME);

    }


    @Test
    public void editContact() {
        contactForm =  contactDetails.clickEditBtn();
        contactDetails =  contactForm.setLastName(NEW_LAST_NAME)
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
