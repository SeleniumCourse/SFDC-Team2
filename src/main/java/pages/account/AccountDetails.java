package pages.account;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.DetailsBase;
import utils.Helper;


/**
 * Created by noelia on 8/26/2015.
 */


public class AccountDetails extends DetailsBase {
    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    private WebElement accountNameContainer;

    @FindBy(id = "acc5_ilecell")
    @CacheLookup
    private WebElement accountNumberContainer;

    @FindBy(id = "acc6_ileinner")
    @CacheLookup
    private WebElement accountTypeContainer;

    @FindBy(id = "acc8_ileinner")
    @CacheLookup
    private WebElement accountRevenueContainer;

    @FindBy(id = "acc17_ileinner")
    @CacheLookup
    private WebElement accountBillingAddressContainer;
    Actions action ;
    @FindBy(id = "acc17street")
    @CacheLookup
    private WebElement accountBillingStreetContainer;

    @FindBy(id = "acc17city")
    @CacheLookup
    private WebElement accountBillingCityContainer;

    @FindBy(id = "acc17country")
    @CacheLookup
    private WebElement accountBillingCountryContainer;

    @FindBy(id = "InlineEditDialogX")
    @CacheLookup
    private WebElement accountcloseBillingshippingAddress;

    @FindBy(id = "acc7_ileinner")
    @CacheLookup
    private WebElement accountIndustryContainer;

    @FindBy(id = "acc14_ileinner")
    @CacheLookup
    private WebElement accountOwnershipContainer;


    @FindBy(id = "acc10_ileinner")
    @CacheLookup
    private WebElement accountPhoneContainer;


    @FindBy(id = "acc11_ileinner")
    @CacheLookup
    private WebElement accountFaxContainer;


    @FindBy(id = "acc12_ilecell")
    @CacheLookup
    private WebElement accountWebsideContainer;

    @FindBy(linkText = "accountTickerSymbol")
    @CacheLookup
    private WebElement accountTikersimboloContainer;

    @FindBy(id = "acc15_ileinner")
    @CacheLookup
    private WebElement accountEmployeesContainer;


    @FindBy(id = "acc16_ileinner")
    @CacheLookup
    private WebElement accountSICContainer;

    @FindBy(id = "acc18_ilecell")
    @CacheLookup
    private WebElement accountShippingAddressContainer;

    @FindBy(id = "acc18_ilecell")
    @CacheLookup
    private WebElement accountShippingbillingProvinceContainer;

    @FindBy(id = "acc20_ileinner")
    @CacheLookup
    private WebElement accountDescriptionContainer;


    public AccountDetails(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    @Override
    public AccountForm clickEditBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        editBtn.click();
        return new AccountForm(driver);
    }

    @Override
    public Object clickDeleteBtn(boolean confirmDeletion) {
        return null;
    }

    public String getAccountName(){
        String accountName;
        wait.until(ExpectedConditions.visibilityOf(accountNameContainer));
        accountName = accountNameContainer.getText();
        return accountName.replace("[View Hierarchy]", "").trim();
    }
    public String getAccountNumber(){
        wait.until(ExpectedConditions.visibilityOf(accountNumberContainer));
        return accountNumberContainer.getText();
    }

    public AccountDetails getAccountBillingAddress(){
        action= new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(accountBillingAddressContainer));
        action.doubleClick(accountBillingAddressContainer).perform();

        return this;
    }

    public AccountDetails closeAccountBillingAddress(){
        wait.until(ExpectedConditions.visibilityOf(accountcloseBillingshippingAddress));
        accountcloseBillingshippingAddress.click();
        return this;
    }

    public String getAccountBillingStreet(){
        wait.until(ExpectedConditions.visibilityOf(accountBillingStreetContainer));
        return accountBillingStreetContainer.getText();
    }
    public String getAccountBillingCity(){
        wait.until(ExpectedConditions.visibilityOf(accountBillingCityContainer));

        return accountBillingCityContainer.getText();
    }
    public String getAccountBillingCountry(){
        wait.until(ExpectedConditions.visibilityOf(accountBillingCountryContainer));
        return accountBillingCountryContainer.getText();
    }

    public String getAccountType(){
        wait.until(ExpectedConditions.visibilityOf(accountTypeContainer));
        return accountTypeContainer.getText();
    }
    public String getAccountIndustry(){
        wait.until(ExpectedConditions.visibilityOf(accountIndustryContainer));
        return accountIndustryContainer.getText();
    }
    public String getAccountRevenue(){
        wait.until(ExpectedConditions.visibilityOf(accountRevenueContainer));
       // return Helper.removeDollarCharToString(accountRevenueContainer.getText());
        return null;
    }
    public String getAccountOwnership(){
        wait.until(ExpectedConditions.visibilityOf(accountOwnershipContainer));
        return accountOwnershipContainer.getText();
    }
    public String getAccountPhone(){
        wait.until(ExpectedConditions.visibilityOf(accountPhoneContainer));
        return accountPhoneContainer.getText();
    }
    public String getAccountFax(){
        wait.until(ExpectedConditions.visibilityOf(accountFaxContainer));
        return accountFaxContainer.getText();
    }
    public String getAccountWebside(){
        wait.until(ExpectedConditions.visibilityOf(accountWebsideContainer));
        return accountWebsideContainer.getText();
    }
    public AccountDetails getShippingAddress(){
        action= new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(accountShippingAddressContainer));
        action.doubleClick(accountShippingAddressContainer).perform();
        return this;
    }
    public String getAccountTikersimbolo(){
        wait.until(ExpectedConditions.visibilityOf(accountTikersimboloContainer));
        return accountTikersimboloContainer.getText();
    }
    public String getAccountSIC(){
        wait.until(ExpectedConditions.visibilityOf(accountSICContainer));
        return accountSICContainer.getText();
    }
    public String getAccountEmployees(){
        wait.until(ExpectedConditions.visibilityOf(accountEmployeesContainer));
        return accountEmployeesContainer.getText();
    }

    public String getShippingbillingProvince(){
        wait.until(ExpectedConditions.visibilityOf(accountShippingbillingProvinceContainer));
        return accountShippingbillingProvinceContainer.getText();
    }
    public String getAccountDescription(){
        wait.until(ExpectedConditions.visibilityOf(accountDescriptionContainer));
        return accountDescriptionContainer.getText().trim();
    }

}
