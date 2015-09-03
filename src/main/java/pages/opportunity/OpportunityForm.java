package pages.opportunity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.LookupPage;
import pages.basepages.FormBase;


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

    @FindBy(xpath= "//td[contains(., 'Order Number')]/following-sibling::td[1]/input")
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
        super.webDriverTools.clearAndSendKeys(opyNameTxt, opportunityName);
        return this;
    }

    public OpportunityForm setAccount(String accountName) {
        lookupIcon.click();
        LookupPage lookupPage = new LookupPage();
        lookupPage.selectAccount(accountName);
        return this;
    }

    public OpportunityForm selectType(String type) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(this.typeComBox, type);
        return this;
    }

    public OpportunityForm selectLeadSource(String lead) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(this.leadSourceComBox, lead);
        return this;
    }

    public OpportunityForm setAmount(String amount) {
        super.webDriverTools.clearAndSendKeys(this.amountTxt, amount);
        return this;
    }

    public OpportunityForm setCloseDate(String closeDate) {
        super.webDriverTools.clearAndSendKeys(this.closeDateTxt, closeDate);
        return this;
    }

    public OpportunityForm setNextStep(String nextStep) {
        super.webDriverTools.clearAndSendKeys(this.nextStepTxt, nextStep);
        return this;
    }

    public OpportunityForm selectStage(String stage) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(this.stageComBox, stage);
        return this;
    }

    public OpportunityForm setProbability(String probability) {
        super.webDriverTools.clearAndSendKeys(this.probabilityTxt, probability);
        return this;
    }

    public OpportunityForm setOrderNumber(String orderNumber) {
        super.webDriverTools.clearAndSendKeys(this.orderNumberTxt, orderNumber);
        return this;
    }

    public OpportunityForm setCurrentGenerator(String currentGenerator) {
        super.webDriverTools.clearAndSendKeys(this.currentGeneratorTxt, currentGenerator);
        return this;
    }

    public OpportunityForm setTrackingNumber(String trackingNumber) {
        super.webDriverTools.clearAndSendKeys(this.trackingNumberTxt, trackingNumber);
        return this;
    }

    public OpportunityForm setMainCompetitor(String mainCompetitor) {
        super.webDriverTools.clearAndSendKeys(this.mainCompetitorTxt, mainCompetitor);
        return this;
    }

    public OpportunityForm selectDeliveryInstallStatus(String deliveryInstall) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(this.deliveryInstallComBox, deliveryInstall);
        return this;
    }

    public OpportunityForm setDescription(String description) {
        super.webDriverTools.clearAndSendKeys(this.descriptionTextArea, description);
        return this;
    }
}
