package pages.account;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    private WebElement accountNumber;

    @FindBy(id = "acc8")
    @CacheLookup
    private WebElement accountRevenue;

    @FindBy(id = "acc10")
    @CacheLookup
    private WebElement accountPhone;

    @FindBy(id = "acc11")
    @CacheLookup
    private WebElement accountFax;

    @FindBy(id = "acc12")
    @CacheLookup
    private WebElement accountWebsite;

    @FindBy(id = "acc13")
    @CacheLookup
    private WebElement accountTickerSymbol;

    @FindBy(id = "acc15")
    @CacheLookup
    private WebElement accountEmployees;

    @FindBy(id = "acc16")
    @CacheLookup
    private WebElement accountSIC;

    @FindBy(id = "acc17street")
    @CacheLookup
    private WebElement accountBillingStreet;

    @FindBy(id = "acc17city")
    @CacheLookup
    private WebElement accountBillingCity;

    @FindBy(id = "acc17country")
    @CacheLookup
    private WebElement accountBillingCountry;

    @FindBy(id = "acc18street")
    @CacheLookup
    private WebElement accountShippingStreet;

    @FindBy(id = "acc18state")
    @CacheLookup
    private WebElement accountProvince;

    @FindBy(id = "acc18country")
    @CacheLookup
    private WebElement accountShippingCountry;

    @FindBy(name = "acc6")
    @CacheLookup
    private WebElement listType;

    @FindBy(name = "acc7")
    @CacheLookup
    private WebElement listIndustry;

    @FindBy(name = "acc14")
    @CacheLookup
    private WebElement listOwnership;

    @FindBy(id = "00N61000000tWPH")
    @CacheLookup
    private WebElement customerPriority;

    @FindBy(id = "00N61000000tWPJ")
    @CacheLookup
    private WebElement SLA;

    @FindBy(id = "00N61000000tWPG")
    @CacheLookup
    private WebElement active;

    @FindBy(id = "acc20")
    @CacheLookup
    private WebElement accountDescription;



    public AccountForm(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    @Override
    public AccountDetails clickSaveBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return new AccountDetails (driver);
    }
    public AccountForm setAccountName(String accountName){
        wait.until(ExpectedConditions.visibilityOf(accountNameTxt));
        accountNameTxt.clear();
        accountNameTxt.sendKeys(accountName);
        return this;
    }

    public AccountForm setAccountNumber(String accountnumber){
        wait.until(ExpectedConditions.visibilityOf(accountNumber));
        accountNumber.clear();
        accountNumber.sendKeys(accountnumber);
        return this;
    }
    public AccountForm setAccountRevenue(String accountrevenue){
        wait.until(ExpectedConditions.visibilityOf(accountRevenue));
        accountRevenue.clear();
        accountRevenue.sendKeys(accountrevenue);
        return this;
    }
    public AccountForm setAccountPhone(String accountphone){
        wait.until(ExpectedConditions.visibilityOf(accountPhone));
        accountPhone.clear();
        accountPhone.sendKeys(accountphone);
        return this;
    }

    public AccountForm setAccountFax(String accountfax){
        wait.until(ExpectedConditions.visibilityOf(accountFax));
        accountFax.clear();
        accountFax.sendKeys(accountfax);
        return this;
    }

    public AccountForm setAccountWebsite(String accountwebsite){
        wait.until(ExpectedConditions.visibilityOf(accountWebsite));
        accountWebsite.clear();
        accountWebsite.sendKeys(accountwebsite);
        return this;
    }

    public AccountForm setAccountTickersymbol(String accountTickersymbol){
        wait.until(ExpectedConditions.visibilityOf(accountTickerSymbol));
        accountTickerSymbol.clear();
        accountTickerSymbol.sendKeys(accountTickersymbol);
        return this;
    }

    public AccountForm setAccountEmployees(String accountemployees){
        wait.until(ExpectedConditions.visibilityOf(accountEmployees));
        accountEmployees.clear();
        accountEmployees.sendKeys(accountemployees);
        return this;
    }

    public AccountForm setAccountSIC(String accountsic){
        wait.until(ExpectedConditions.visibilityOf(accountSIC));
        accountSIC.clear();
        accountSIC.sendKeys(accountsic);
        return this;
    }

    public AccountForm setAccountBillingStreet(String accountbillingStreet){
        wait.until(ExpectedConditions.visibilityOf(accountBillingStreet));
        accountBillingStreet.clear();
        accountBillingStreet.sendKeys(accountbillingStreet);
        return this;
    }

   public AccountForm setAccountBillingCity(String accountbillingCity){
       wait.until(ExpectedConditions.visibilityOf(accountBillingCity));
       accountBillingCity.clear();
       accountBillingCity.sendKeys(accountbillingCity);
       return this;
   }
   public AccountForm setAccountBillingCountry(String accountbillingCountry){
       wait.until(ExpectedConditions.visibilityOf(accountBillingCountry));
       accountBillingCountry.clear();
       accountBillingCountry.sendKeys(accountbillingCountry);
       return this;
   }
   public AccountForm setAccountShippingStreet(String accountshippingStreet){
       wait.until(ExpectedConditions.visibilityOf(accountShippingStreet));
       accountShippingStreet.clear();
       accountShippingStreet.sendKeys(accountshippingStreet);
       return this;
   }
   public AccountForm setAccountProvince(String accountprovince){
       wait.until(ExpectedConditions.visibilityOf(accountProvince));
       accountProvince.clear();
       accountProvince.sendKeys(accountprovince);
       return this;
   }

   public AccountForm setAccountShippingCountry(String accountbillingCountry){
       wait.until(ExpectedConditions.visibilityOf(accountShippingCountry));
       accountShippingCountry.clear();
       accountShippingCountry.sendKeys(accountbillingCountry);
       return this;
   }

    public AccountForm setAccountDescription(String accountdescription){
        wait.until(ExpectedConditions.visibilityOf(accountDescription));
        accountDescription.clear();
        accountDescription.sendKeys(accountdescription);
        return this;
    }

    public AccountForm selectAccountType(String type){
        Select selectBox = new Select(listType);
        selectBox.selectByVisibleText(type);
        return this;
    }
    public AccountForm selectAccountIndustry(String Industry){
        Select selectBox = new Select(listIndustry);
        selectBox.selectByVisibleText(Industry);
        return this;
    }

    public AccountForm selectAccountOwnership(String listownership){
        Select selectBox = new Select(listOwnership);
        selectBox.selectByVisibleText(listownership);
        return this;
    }

    public AccountForm selectAccountCustomerPriority(String customerpriority){
        Select selectBox = new Select(customerPriority);
        selectBox.selectByVisibleText(customerpriority);
        return this;
    }

    public AccountForm selectAccountSLA(String sla){
        Select selectBox = new Select(SLA);
        selectBox.selectByVisibleText(sla);
        return this;
    }

    public AccountForm selectAccountActive(String activeaccount){
        Select selectBox = new Select(active);
        selectBox.selectByVisibleText(activeaccount);
        return this;
    }


}
