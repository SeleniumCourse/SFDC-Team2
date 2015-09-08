package tests.lead;

import components.NavigationTab;
import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainApp;
import pages.campaign.CampaignDetails;
import pages.lead.LeadDetails;
import pages.lead.LeadForm;
import pages.lead.LeadHome;
import utils.CampaignGenie;

/**
 * Created by marcelo on 9/5/15.
 */
public class CreateLead {
    private MainApp mainApp;
    private CampaignDetails campaignDetails;

    private final String SALUTATION = "Mrs.";
    private final String FIRST_NAME = "Micaela";
    private final String LAST_NAME = "Ferrufino";
    private final String COMPANY = "COMPANY";
    private final String NAME = SALUTATION + " " + FIRST_NAME + " " + LAST_NAME;
    private final String TITLE = "title 01";
    private final String LEAD_SOURCE = "Phone Inquiry";
    private final String CAMPAIGN_NAME = "Micaelita";
    private final String INDUSTRY = "Consulting";
    private final String ANNUAL_REVENUE = "15000";
    private final String PHONE = "2456466";
    private final String MOBILE = "122456466";
    private final String FAX = "82456466";
    private final String EMAIL = "example@selenium.com";
    private final String WEB_SITE = "www.example-selenium.com";
    private final String LEAD_STATUS = "Working - Contacted";
    private final String RATING = "Warm";
    private final String NO_OF_EMPLOYEES = "10";
    private final String STREET = "Av. Testing 312";
    private final String CITY = "Cochabamba";
    private final String STATE_PROVINCE = "Cochabamba";
    private final String POSTAL_CODE = "0000";
    private final String COUNTRY = "Bolivia";
    private final String ADDRESS = STREET + "\n" + CITY + ", " +
                                   STATE_PROVINCE + " " + POSTAL_CODE + "\n" +
                                    COUNTRY;
    private final String PRODUCT_INTEREST = "GC5000 series";
    private final String SIC_CODE = "123123";
    private final String NUMBER_OF_LOCATIONS = "10";
    private final String CURRENT_GENERATOR = "1";
    private final String PRIMARY = "No";
    private final String DESCRIPTION = "description 01";

    @BeforeClass
    public void setUp(){
        //Login login = new Login();
        //mainApp = login.loginAsPrimaryUser();
        mainApp = CampaignGenie.createCampaign(CAMPAIGN_NAME);
    }

    @Test(groups = {"Acceptance"})
    public void createLead(){
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        LeadHome leadHome = navigationTab.goToLeadTab();
        LeadForm leadForm = leadHome.clickNewBtn();
        LeadDetails leadDetails = leadForm.selectSalutation(SALUTATION)
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setCompany(COMPANY)
                .setTitle(TITLE)
                .selectLeadSource(LEAD_SOURCE)
                .setCampaign(CAMPAIGN_NAME)
                .selectIndustry(INDUSTRY)
                .setAnnualRevenue(ANNUAL_REVENUE)
                .setPhone(PHONE)
                .setMobile(MOBILE)
                .setFax(FAX)
                .setEmail(EMAIL)
                .setWebSite(WEB_SITE)
                .selectLeadStatus(LEAD_STATUS)
                .selectRating(RATING)
                .setNoOfEmployees(NO_OF_EMPLOYEES)
                .setStreet(STREET)
                .setCity(CITY)
                .setStateProvince(STATE_PROVINCE)
                .setPostalCode(POSTAL_CODE)
                .setCountry(COUNTRY)
                .selectProductInterest(PRODUCT_INTEREST)
                .setSicCode(SIC_CODE)
                .setNumberOfLocations(NUMBER_OF_LOCATIONS)
                .setCurrentGenerator(CURRENT_GENERATOR)
                .selectPrimary(PRIMARY)
                .selectProductInterest(PRODUCT_INTEREST)
                .setSicCode(SIC_CODE)
                .setNumberOfLocations(NUMBER_OF_LOCATIONS)
                .setCurrentGenerator(CURRENT_GENERATOR)
                .selectPrimary(PRIMARY)
                .setDescription(DESCRIPTION)
                .clickSaveBtn();
        Assert.assertEquals(NAME, leadDetails.getLeadName());
        Assert.assertEquals(COMPANY, leadDetails.getCompanyName());
        Assert.assertEquals(TITLE, leadDetails.getTitle());
        Assert.assertEquals(LEAD_SOURCE, leadDetails.getLeadSource());
        Assert.assertEquals(INDUSTRY, leadDetails.getIndustry());
        Assert.assertEquals(ANNUAL_REVENUE, leadDetails.getAnnualRevenue());
        Assert.assertEquals(PHONE, leadDetails.getPhone());
        Assert.assertEquals(MOBILE, leadDetails.getMobile());
        Assert.assertEquals(FAX, leadDetails.getFax());
        Assert.assertEquals(EMAIL, leadDetails.getEmail());
        Assert.assertEquals(WEB_SITE, leadDetails.getWebSite());
        Assert.assertEquals(LEAD_STATUS, leadDetails.getLeadStatus());
        Assert.assertEquals(RATING, leadDetails.getRating());
        Assert.assertEquals(NO_OF_EMPLOYEES, leadDetails.getNoOfEmployees());
        Assert.assertEquals(ADDRESS, leadDetails.getAddress());
        Assert.assertEquals(PRODUCT_INTEREST, leadDetails.getProductInterest());
        Assert.assertEquals(SIC_CODE, leadDetails.getSicCode());
        Assert.assertEquals(NUMBER_OF_LOCATIONS, leadDetails.getNumberOfLocations());
        Assert.assertEquals(CURRENT_GENERATOR, leadDetails.getCurrentGenerator());
        Assert.assertEquals(PRIMARY, leadDetails.getPrimary());
        Assert.assertEquals(DESCRIPTION, leadDetails.getDescription());
    }
}
