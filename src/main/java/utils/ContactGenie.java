package utils;

import components.NavigationTab;
import framework.DriverManager;
import pages.Contact.ContactDetails;
import pages.Contact.ContactForm;
import pages.Contact.ContactHome;
import pages.Login;
import pages.MainApp;

/**
 * Created by noelia on 9/6/2015.
 */
public class ContactGenie {


    private static String FIRSTNAME_mR = "Mr.";
    private static String FIRST_NAME = "JUSTIN";
    private static String TITLE = "title";
    private static String DEPARTMENT = "florida";
    private static String BIRTHDAY = "8/22/2015";
    private static String LEAD = "Web";
    private static String PHONE = "456666";
    private static String MOBILE = "998852456";
    private static String FAX = "faxx";
    private static String EMAIL = "noelia@gmail.com";
    private static String ASSISTANT = "assistant";
    private static String LANGUAGES = "English";
    private static String LEVEL = "Secondary";
    private static String DESCRIPTION = "text description";

    /**
     * Create a Contact object
     *
     * @return ContactDetails object
     * @params contactName: Contact Name object to be created
     */
    public static ContactDetails createContactObject(String contactName) {
        MainApp mainApp;

        if (Helper.isLoginPage()) {
            Login login = new Login();
            mainApp = login.loginAsPrimaryUser();
        }else {
            mainApp = new MainApp();
        }

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        ContactHome contactHome = navigationTab.goToContactTab();
        ContactForm contactForm = (ContactForm) contactHome.clickNewBtn();
        ContactDetails contactDetails = contactForm.setLastName(contactName)
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
        return contactDetails;
    }

    public static void deleteContactObjectAndQuitBrowserDriver(ContactDetails campaignDetails) {
        campaignDetails.clickDeleteButton(true);
    }
}
