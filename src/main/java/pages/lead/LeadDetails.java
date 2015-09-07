package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.basepages.DetailsBase;
import utils.Helper;

/**
 * Created by marcelo on 9/5/15.
 */
public class LeadDetails extends DetailsBase {
    @FindBy(id = "lea2_ileinner")
    @CacheLookup
    private WebElement nameContainer;

    @FindBy(id = "lea3_ileinner")
    @CacheLookup
    private WebElement companyContainer;

    @FindBy(id = "lea4_ileinner")
    @CacheLookup
    private WebElement titleContainer;

    @FindBy(id = "lea5_ileinner")
    @CacheLookup
    private WebElement leadSourceContainer;

    @FindBy(id = "lea6_ileinner")
    @CacheLookup
    private WebElement industryContainer;

    @FindBy(id = "lea7_ileinner")
    @CacheLookup
    private WebElement annualRevenueContainer;

    @FindBy(id = "lea8_ileinner")
    @CacheLookup
    private WebElement phoneContainer;

    @FindBy(id = "lea9_ileinner")
    @CacheLookup
    private WebElement mobileContainer;

    @FindBy(id = "lea10_ileinner")
    @CacheLookup
    private WebElement faxContainer;

    @FindBy(id = "lea11_ileinner")
    @CacheLookup
    private WebElement emailContainer;

    @FindBy(id = "lea12_ileinner")
    @CacheLookup
    private WebElement webSiteContainer;

    @FindBy(id = "lea13_ileinner")
    @CacheLookup
    private WebElement leadStatusContainer;

    @FindBy(id = "lea14_ileinner")
    @CacheLookup
    private WebElement ratingContainer;

    @FindBy(id = "lea15_ileinner")
    @CacheLookup
    private WebElement noOfEmployeesContainer;

    @FindBy(id = "lea16_ileinner")
    @CacheLookup
    private WebElement addressContainer;

    @FindBy(xpath = "//td[contains(., 'Product Interest')]/following-sibling::td[1]")
    @CacheLookup
    private WebElement productInterestContainer;

    @FindBy(xpath = "//td[contains(., 'SIC Code')]/following-sibling::td[1]")
    @CacheLookup
    private WebElement sicCodeContainer;

    @FindBy(xpath = "//td[contains(., 'Number of Locations')]/following-sibling::td[1]")
    @CacheLookup
    private WebElement numberOfLocationsContainer;

    @FindBy(xpath = "//td[contains(., 'Current Generator')]/following-sibling::td[1]")
    @CacheLookup
    private WebElement currentGeneratorContainer;

    @FindBy(xpath = "//td[contains(., 'Primary')]/following-sibling::td[1]")
    @CacheLookup
    private WebElement primaryContainer;

    @FindBy(id = "lea17_ileinner")
    @CacheLookup
    private WebElement descriptionContainer;

    public String getLeadName() { return getValue(nameContainer); }

    public String getCompanyName() { return getValue(companyContainer); }

    public String getTitle() { return getValue(titleContainer); }

    public String getLeadSource() { return getValue(leadSourceContainer); }

    public String getIndustry() { return getValue(industryContainer); }

    public String getAnnualRevenue() {
        return Helper.removeSubstringToString(",",
                Helper.removeSubstringToString("$", getValue(annualRevenueContainer)));
    }

    public String getPhone() { return getValue(phoneContainer); }

    public String getMobile() { return getValue(mobileContainer); }

    public String getFax() { return getValue(faxContainer); }

    public String getEmail() { return getValue(emailContainer); }

    public String getWebSite() {
        return Helper.removeSubstringToString("http://", getValue(webSiteContainer));
    }

    public String getLeadStatus() { return  getValue(leadStatusContainer); }

    public String getRating() { return getValue(ratingContainer); }

    public String getNoOfEmployees() { return getValue(noOfEmployeesContainer); }

    public String getAddress() { return getValue(addressContainer); }

    public String getProductInterest() { return getValue(productInterestContainer); }

    public String getSicCode() { return getValue(sicCodeContainer); }

    public String getNumberOfLocations() { return getValue(numberOfLocationsContainer); }

    public String getCurrentGenerator() { return getValue(currentGeneratorContainer); }

    public String getPrimary() { return getValue(primaryContainer); }

    public String getDescription() { return getValue(descriptionContainer); }

    @Override
    public Object clickEditBtn() {
        return null;
    }

    @Override
    public Object clickDeleteBtn(boolean confirmDeletion) {
        return null;
    }
}
