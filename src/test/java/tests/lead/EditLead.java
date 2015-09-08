package tests.lead;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.lead.LeadDetails;
import pages.lead.LeadForm;
import utils.LeadGenie;

/**
 * Created by marcelo on 9/7/15.
 */
public class EditLead {
    private final String LAST_NAME = "Stephen";
    private final String COMPANY = "OLEX";

    private final String SALUTATION = "Mrs.";
    private final String FIRST_NAME = "Sussan";
    private final String NAME = SALUTATION + " " + FIRST_NAME + " " + LAST_NAME;
    private final String TITLE = "title 0123";
    private final String LEAD_SOURCE = "Phone Inquiry";
    private final String INDUSTRY = "Consulting";
    private final String ANNUAL_REVENUE = "150000";
    private final String PHONE = "200000";
    private final String MOBILE = "330000";
    private final String FAX = "4400000";
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
    private final String DESCRIPTION = "description on edit action";

    private LeadDetails leadDetails;

    @BeforeClass
    public void setUp() {
        leadDetails = LeadGenie.createLeadObject(LAST_NAME, COMPANY);
    }

    @Test
    public void editLead() {
        LeadForm leadForm = leadDetails.clickEditBtn();
        leadDetails = leadForm.selectSalutation(SALUTATION)
                .setFirstName(FIRST_NAME)
                .setTitle(TITLE)
                .selectLeadSource(LEAD_SOURCE)
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

    @AfterClass
    public void tearDown() {
        LeadGenie.deleteLeadAndQuitBrowserDriver(leadDetails);
    }
}
