package pages.opportunity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.LookupPage;
import pages.basepages.FormBase;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Virginia Sanabria on 8/30/2015.
 */
public class OpportunityForm extends FormBase{
    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement opyNameTxt;

    @FindBy(id = "opp5")
    @CacheLookup
    private WebElement typeComBox;

    @FindBy(id = "opp6")
    @CacheLookup
    private WebElement leadSourceComBox;

    @FindBy(id = "opp7")
    @CacheLookup
    private WebElement amountTxt;

    @FindBy(css = "img[title *= 'Account Name Lookup']")
    @CacheLookup
    private WebElement lookupIcon;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement closeDateTxt;

    @FindBy(id = "opp10")
    @CacheLookup
    private WebElement nextStepTxt;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement stageComBox;

    @FindBy(id = "opp12")
    @CacheLookup
    private WebElement probabilityTxt;

    @FindBy(xpath= "//td[contains(., 'Order Number')]/following-sibling::td/input")
    @CacheLookup
    private WebElement orderNumberTxt;

    @FindBy(xpath= "//td[contains(., 'Main Competitor')]/following-sibling::td/input")
    @CacheLookup
    private WebElement mainCompetitorTxt;

    @FindBy(xpath= "//td[contains(., 'Current Generator')]/following-sibling::td/input")
    @CacheLookup
    private WebElement currentGeneratorTxt;

    @FindBy(xpath= "//td[contains(., 'Tracking Number')]/following-sibling::td/input")
    @CacheLookup
    private WebElement trackingNumberTxt;

    @FindBy(xpath= "//td[contains(., 'Delivery/Installation Status')]/following-sibling::td//select")
    @CacheLookup
    private WebElement deliveryInstallComBox;

    @FindBy(xpath= "//td[contains(., 'Description')]/following-sibling::td/textarea")
    @CacheLookup
    private WebElement descriptionTextArea;

    @Override
    public OpportunityDetails clickSaveBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(super.saveBtn));
        super.saveBtn.click();
        return new OpportunityDetails();
    }

    public OpportunityForm setOpyName(String opportunityName) {
        super.wait.until(ExpectedConditions.visibilityOf(opyNameTxt));
        opyNameTxt.clear();
        opyNameTxt.sendKeys(opportunityName);
        return this;
    }

    public OpportunityForm selectAccount(String accountName) {
        String windowID = super.driver.getWindowHandle();
        lookupIcon.click();

        Set<String> setWindows = super.driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<String>(setWindows);
        super.driver.switchTo().window(listWindows.getLast());

        LookupPage lookupPage = new LookupPage();
        lookupPage.searchByAccountName(accountName);
        lookupPage.clickAccountName(accountName);

        super.driver.switchTo().window(windowID);
        return this;
    }

    public OpportunityForm selectType(String type) {
        Select select = new Select(this.typeComBox);
        select.selectByVisibleText(type);
        return this;
    }

    public OpportunityForm selectLeadSource(String lead) {
        Select select = new Select(this.leadSourceComBox);
        select.selectByVisibleText(lead);
        return this;
    }

    public OpportunityForm setAmount(String amount) {
        super.wait.until(ExpectedConditions.visibilityOf(this.amountTxt));
        this.amountTxt.clear();
        this.amountTxt.sendKeys(amount);
        return this;
    }

    public OpportunityForm setCloseDate(String closeDate) {
        super.wait.until(ExpectedConditions.visibilityOf(this.closeDateTxt));
        this.closeDateTxt.clear();
        this.closeDateTxt.sendKeys(closeDate);
        return this;
    }

    public OpportunityForm setNextStep(String nextStep) {
        super.wait.until(ExpectedConditions.visibilityOf(this.nextStepTxt));
        this.nextStepTxt.clear();
        this.nextStepTxt.sendKeys(nextStep);
        return this;
    }

    public OpportunityForm selectStage(String stage) {
        Select select = new Select(this.stageComBox);
        select.selectByVisibleText(stage);
        return this;
    }

    public OpportunityForm setProbability(String probability) {
        super.wait.until(ExpectedConditions.visibilityOf(this.probabilityTxt));
        this.probabilityTxt.clear();
        this.probabilityTxt.sendKeys(probability);
        return this;
    }

    public OpportunityForm setOrderNumber(String orderNumber) {
        super.wait.until(ExpectedConditions.visibilityOf(this.orderNumberTxt));
        this.orderNumberTxt.clear();
        this.orderNumberTxt.sendKeys(orderNumber);
        return this;
    }

    public OpportunityForm setCurrentGenerator(String currentGenerator) {
        super.wait.until(ExpectedConditions.visibilityOf(this.currentGeneratorTxt));
        this.currentGeneratorTxt.clear();
        this.currentGeneratorTxt.sendKeys(currentGenerator);
        return this;
    }

    public OpportunityForm setTrackingNumber(String trackingNumber) {
        super.wait.until(ExpectedConditions.visibilityOf(this.trackingNumberTxt));
        this.trackingNumberTxt.clear();
        this.trackingNumberTxt.sendKeys(trackingNumber);
        return this;
    }

    public OpportunityForm setMainCompetitor(String mainCompetitor) {
        super.wait.until(ExpectedConditions.visibilityOf(this.mainCompetitorTxt));
        this.mainCompetitorTxt.clear();
        this.mainCompetitorTxt.sendKeys(mainCompetitor);
        return this;
    }

    public OpportunityForm selectDeliveryInstallStatus(String deliveryInstall) {
        Select select = new Select(this.deliveryInstallComBox);
        select.selectByVisibleText(deliveryInstall);
        return this;
    }

    public OpportunityForm setDescription(String description) {
        super.wait.until(ExpectedConditions.visibilityOf(this.descriptionTextArea));
        this.descriptionTextArea.clear();
        this.descriptionTextArea.sendKeys(description);
        return this;
    }

}
