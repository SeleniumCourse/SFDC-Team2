package utils;

import components.NavigationTab;
import pages.contact.ContactDetails;
import pages.contact.ContactForm;
import pages.contact.ContactHome;
import pages.Login;
import pages.MainApp;
import pages.basepages.BaseViewDetails;
import pages.opportunity.OpportunitiesHome;
import pages.opportunity.OpportunityViewForm;

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
     * Create a contact object
     *
     * @return ContactDetails object
     * @params contactName: contact Name object to be created
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

    public static BaseViewDetails createSingleViewContact(String viewName, String viewUniqueName) {
        MainApp mainApp;

        if (Helper.isLoginPage()) {
            Login login = new Login();
            mainApp = login.loginAsPrimaryUser();
        }else {
            mainApp = new MainApp();
        }

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        OpportunitiesHome opportunitiesHome = navigationTab.goToOpportunityTab();
        OpportunityViewForm opportunityViewForm = opportunitiesHome.clickCreateNewViewLnk();
        BaseViewDetails baseViewDetails = opportunityViewForm.setViewNameTxt(viewName)
                .setViewUniqueNameTxt(viewUniqueName)
                .clickSaveBtn();

        return baseViewDetails;
    }

}
