package pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.FormBase;

/**
 * Created by noelia on 8/26/2015.
 */
public class AccountForm extends FormBase {

    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameTxt;

    @FindBy(id = "acc5")
    @CacheLookup
    private WebElement accountNumberTxt;

    @FindBy(id = "acc8")
    @CacheLookup
    private WebElement accountRevenueTxt;

    @FindBy(id = "acc10")
    @CacheLookup
    private WebElement accountPhoneTxt;

    @FindBy(id = "acc11")
    @CacheLookup
    private WebElement accountFaxTxt;

    @FindBy(id = "acc12")
    @CacheLookup
    private WebElement accountWebsiteTxt;

    @FindBy(id = "acc13")
    @CacheLookup
    private WebElement accountTickerSymbolText;

    @FindBy(id = "acc15")
    @CacheLookup
    private WebElement accountEmployeesTxt;

    @FindBy(id = "acc16")
    @CacheLookup
    private WebElement accountSICTxt;

    @FindBy(id = "acc17street")
    @CacheLookup
    private WebElement accountBillingStreetTxt;

    @FindBy(id = "acc17city")
    @CacheLookup
    private WebElement accountBillingCityTxt;

    @FindBy(id = "acc17country")
    @CacheLookup
    private WebElement accountBillingCountryTxt;

    @FindBy(id = "acc18street")
    @CacheLookup
    private WebElement accountShippingStreetTxt;

    @FindBy(id = "acc18state")
    @CacheLookup
    private WebElement accountProvinceTxt;

    @FindBy(xpath = "td[contains(., 'Number of Locations')]/following-sibling::td//input")
    @CacheLookup
    private WebElement numberLocationTxt;

    @FindBy(name = "acc6")
    @CacheLookup
    private WebElement listTypeCmbbox;

    @FindBy(name = "acc7")
    @CacheLookup
    private WebElement listIndustryCmbbox;

    @FindBy(name = "acc14")
    @CacheLookup
    private WebElement listOwnershipCmbbox;

    @FindBy(xpath = "//td[contains(., 'Customer')]/following-sibling::td//select")
    @CacheLookup
    private WebElement customerPriorityCmbbox;

    @FindBy(xpath= "//td[contains(., 'SLA')]/following-sibling::td//select")
    @CacheLookup
    private WebElement SLACmbbox;

    @FindBy(xpath = "//td[contains(., 'Active')]/following-sibling::td//select")
    @CacheLookup
    private WebElement activeCmbbox;

    @FindBy(id = "acc20")
    @CacheLookup
    private WebElement accountDescriptionTxt;


    @Override
    public AccountDetails clickSaveBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return new AccountDetails ();
    }

    public AccountForm setAccountName(String accountName){
        super.webDriverTools.clearAndSendKeys(accountNameTxt, accountName);
        return this;
    }

    public AccountForm setAccountNumber(String accountnumber){
        super.webDriverTools.clearAndSendKeys(accountNumberTxt, accountnumber);
        return this;
    }

    public AccountForm setAccountRevenue(String accountrevenue){
        super.webDriverTools.clearAndSendKeys(accountRevenueTxt, accountrevenue);
        return this;
    }

    public AccountForm setAccountPhone(String accountphone){
        super.webDriverTools.clearAndSendKeys(accountPhoneTxt, accountphone);
        return this;
    }

    public AccountForm setAccountFax(String accountfax){
        super.webDriverTools.clearAndSendKeys(accountFaxTxt, accountfax);
        return this;
    }

    public AccountForm setAccountWebsite(String accountwebsite){
        super.webDriverTools.clearAndSendKeys(accountWebsiteTxt, accountwebsite);
        return this;
    }

    public AccountForm setAccountTickersymbol(String accountTickersymbol){
        super.webDriverTools.clearAndSendKeys(accountTickerSymbolText, accountTickersymbol);
        return this;
    }

    public AccountForm setAccountEmployees(String accountemployees){
        super.webDriverTools.clearAndSendKeys(accountEmployeesTxt, accountemployees);
        return this;
    }

    public AccountForm setAccountSIC(String accountsic){
        super.webDriverTools.clearAndSendKeys(accountSICTxt, accountsic);
        return this;
    }

    public AccountForm setAccountBillingStreet(String accountbillingStreet){
        super.webDriverTools.clearAndSendKeys(accountBillingStreetTxt, accountbillingStreet);
        return this;

    }

   public AccountForm setAccountBillingCity(String accountbillingCity){
       super.webDriverTools.clearAndSendKeys(accountBillingCityTxt, accountbillingCity);
       return this;
   }

   public AccountForm setAccountBillingCountry(String accountbillingCountry){
       super.webDriverTools.clearAndSendKeys(accountBillingCityTxt, accountbillingCountry);
       return this;
   }

   public AccountForm setAccountShippingStreet(String accountshippingStreet){
       super.webDriverTools.clearAndSendKeys(accountShippingStreetTxt, accountshippingStreet);
       return this;
   }

   public AccountForm setAccountProvince(String accountprovince){
       super.webDriverTools.clearAndSendKeys(accountProvinceTxt, accountprovince);
       return this;
   }

   public AccountForm setAccountnumberLocation(String numberLocation){
       super.webDriverTools.clearAndSendKeys(numberLocationTxt, numberLocation);
       return this;
   }

    public AccountForm setAccountDescription(String accountdescription){
        super.webDriverTools.clearAndSendKeys(accountDescriptionTxt, accountdescription);
        return this;
    }

    public AccountForm selectAccountType(String type){
        super.webDriverTools.selectOptionInComboBoxByVisibleText(listTypeCmbbox, type);
        return this;
    }

    public AccountForm selectAccountIndustry(String Industry){
        super.webDriverTools.selectOptionInComboBoxByVisibleText(listIndustryCmbbox, Industry);
        return this;
    }

    public AccountForm selectAccountOwnership(String listownership){
        super.webDriverTools.selectOptionInComboBoxByVisibleText(listOwnershipCmbbox, listownership);
        return this;
    }

    public AccountForm selectAccountCustomerPriority(String customerpriority){
        super.webDriverTools.selectOptionInComboBoxByVisibleText(customerPriorityCmbbox, customerpriority);
        return this;
    }

    public AccountForm selectAccountSLA(String sla){
        super.webDriverTools.selectOptionInComboBoxByVisibleText(SLACmbbox, sla);
        return this;
    }

    public AccountForm selectAccountActive(String activeaccount){
        super.webDriverTools.selectOptionInComboBoxByVisibleText(activeCmbbox, activeaccount);
        return this;

    }


}
