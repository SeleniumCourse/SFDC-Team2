package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LookupPage;
import pages.basepages.FormBase;

/**
 * Created by marcelo on 9/5/15.
 */
public class LeadForm extends FormBase {

    @FindBy(id = "name_salutationlea2")
    @CacheLookup
    private WebElement salutationComBox;

    @FindBy(id = "name_firstlea2")
    @CacheLookup
    private WebElement firstNameTxt;

    @FindBy(id = "name_lastlea2")
    @CacheLookup
    private WebElement lastNameTxt;

    @FindBy(id = "lea3")
    @CacheLookup
    private WebElement companyNameTxt;

    @FindBy(id = "lea4")
    @CacheLookup
    private WebElement titleTxt;

    @FindBy(id = "lea5")
    @CacheLookup
    private WebElement leadSourceComBox;

    @FindBy(css = "img[title*='Campaign Lookup']")
    @CacheLookup
    private WebElement campaignLookup;

    @FindBy(id = "lea6")
    @CacheLookup
    private WebElement industryCombox;

    @FindBy(id = "lea7")
    @CacheLookup
    private WebElement annualRevenueTxt;

    @FindBy(id = "lea8")
    @CacheLookup
    private WebElement phoneTxt;

    @FindBy(id = "lea9")
    @CacheLookup
    private WebElement mobileTxt;

    @FindBy(id = "lea10")
    @CacheLookup
    private WebElement faxTxt;

    @FindBy(id = "lea11")
    @CacheLookup
    private WebElement emailTxt;

    @FindBy(id = "lea12")
    @CacheLookup
    private WebElement webSiteTxt;

    @FindBy(id = "lea13")
    @CacheLookup
    private WebElement leadStatusComBox;

    @FindBy(id = "lea14")
    @CacheLookup
    private WebElement ratingComBox;

    @FindBy(id = "lea15")
    @CacheLookup
    private WebElement noOfEmployeesTxt;

    @FindBy(id = "lea16street")
    @CacheLookup
    private WebElement streetTxt;

    @FindBy(id = "lea16city")
    @CacheLookup
    private WebElement cityTxt;

    @FindBy(id = "lea16state")
    @CacheLookup
    private WebElement stateProvinceTxt;

    @FindBy(id = "lea16zip")
    @CacheLookup
    private WebElement postalCodeTxt;

    @FindBy(id = "lea16country")
    @CacheLookup
    private WebElement countryTxt;

    @FindBy(xpath = "//label[contains(.,'Product Interest')]/following::select[1]")
    @CacheLookup
    private WebElement productInterestComBox;

    @FindBy(xpath = "//label[contains(.,'SIC Code')]/following::input[1]")
    @CacheLookup
    private WebElement sicCodeTxt;

    @FindBy(xpath = "//label[contains(.,'Number of Locations')]/following::input[1]")
    @CacheLookup
    private WebElement numberOfLocationsTxt;

    @FindBy(xpath = "//label[contains(.,'Current Generator')]/following::input[1]")
    @CacheLookup
    private WebElement currentGeneratorTxt;

    @FindBy(xpath = "//label[contains(.,'Primary')]/following::select[1]")
    @CacheLookup
    private  WebElement primaryComBox;

    @FindBy(id = "lea17")
    @CacheLookup
    private WebElement descriptionTxtArea;

    public LeadForm selectSalutation(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(salutationComBox, option);
        return this;
    }

    public LeadForm setFirstName(String firstName) {
        super.webDriverTools.clearAndSendKeys(firstNameTxt, firstName);
        return this;
    }

    public LeadForm setLastName(String lastName) {
        super.webDriverTools.clearAndSendKeys(lastNameTxt, lastName);
        return this;
    }

    public LeadForm setCompany(String companyName) {
        super.webDriverTools.clearAndSendKeys(companyNameTxt, companyName);
        return this;
    }

    public LeadForm setTitle(String title) {
        super.webDriverTools.clearAndSendKeys(titleTxt, title);
        return this;
    }

    public LeadForm selectLeadSource(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(leadSourceComBox, option);
        return this;
    }

    public LeadForm setCampaign(String campaignName) {
        campaignLookup.click();
        LookupPage lookupPage = new LookupPage();
        lookupPage.selectObject(campaignName);
        return this;
    }

    public LeadForm selectIndustry(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(industryCombox, option);
        return this;
    }

    public LeadForm setAnnualRevenue(String annualRevenue) {
        super.webDriverTools.clearAndSendKeys(annualRevenueTxt, annualRevenue);
        return this;
    }

    public LeadForm setPhone(String phone) {
        super.webDriverTools.clearAndSendKeys(phoneTxt, phone);
        return this;
    }

    public LeadForm setMobile(String mobile) {
        super.webDriverTools.clearAndSendKeys(mobileTxt, mobile);
        return this;
    }

    public LeadForm setFax(String fax) {
        super.webDriverTools.clearAndSendKeys(faxTxt, fax);
        return this;
    }

    public LeadForm setEmail(String email) {
        super.webDriverTools.clearAndSendKeys(emailTxt, email);
        return this;
    }

    public LeadForm setWebSite(String webSite) {
        super.webDriverTools.clearAndSendKeys(webSiteTxt, webSite);
        return this;
    }

    public LeadForm selectLeadStatus(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(leadStatusComBox, option);
        return this;
    }

    public LeadForm selectRating(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(ratingComBox, option);
        return this;
    }

    public LeadForm setNoOfEmployees(String noOfEmployees) {
        super.webDriverTools.clearAndSendKeys(noOfEmployeesTxt, noOfEmployees);
        return this;
    }

    public LeadForm setStreet(String street) {
        super.webDriverTools.clearAndSendKeys(streetTxt, street);
        return this;
    }

    public LeadForm setCity(String city) {
        super.webDriverTools.clearAndSendKeys(cityTxt, city);
        return this;
    }

    public LeadForm setStateProvince(String stateProvince) {
        super.webDriverTools.clearAndSendKeys(stateProvinceTxt, stateProvince);
        return this;
    }

    public LeadForm setPostalCode(String postalCode) {
        super.webDriverTools.clearAndSendKeys(postalCodeTxt, postalCode);
        return this;
    }

    public LeadForm setCountry(String country) {
        super.webDriverTools.clearAndSendKeys(countryTxt, country);
        return this;
    }

    public LeadForm selectProductInterest(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(productInterestComBox, option);
        return this;
    }

    public LeadForm setSicCode(String sicCode) {
        super.webDriverTools.clearAndSendKeys(sicCodeTxt, sicCode);
        return this;
    }

    public LeadForm setNumberOfLocations(String numberOfLocations) {
        super.webDriverTools.clearAndSendKeys(numberOfLocationsTxt, numberOfLocations);
        return this;
    }

    public LeadForm setCurrentGenerator(String currentGenerator) {
        super.webDriverTools.clearAndSendKeys(currentGeneratorTxt, currentGenerator);
        return this;
    }

    public LeadForm selectPrimary(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(primaryComBox, option);
        return this;
    }

    public LeadForm setDescription(String description) {
        super.webDriverTools.clearAndSendKeys(descriptionTxtArea, description);
        return this;
    }

    @Override
    public LeadDetails clickSaveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return new LeadDetails();
    }
}
