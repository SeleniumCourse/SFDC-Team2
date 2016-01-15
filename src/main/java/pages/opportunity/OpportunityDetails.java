package pages.opportunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.DetailsBase;
import utils.Helper;

/**
 * Created by Virginia Sanabria on 8/27/2015.
 */
public class OpportunityDetails extends DetailsBase {
    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement opportunityNameContainer;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    private WebElement accountNameTxtContainer;

    @FindBy(id = "opp5_ileinner")
    @CacheLookup
    private WebElement typeComBoxContainer;

    @FindBy(id = "opp6_ileinner")
    @CacheLookup
    private WebElement leadSourceContainer;

    @FindBy(id = "opp7_ileinner")
    @CacheLookup
    private WebElement amountContainer;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement closeDateContainer;

    @FindBy(id = "opp10_ileinner")
    @CacheLookup
    private WebElement nextStepContainer;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement stageContainer;

    @FindBy(id = "opp12_ileinner")
    @CacheLookup
    private WebElement probabilityContainer;

    @FindBy(xpath = "//td[contains(text(), 'Order Number')]/following-sibling::td[1]/div")
    @CacheLookup
    private WebElement orderNumberContainer;

    @FindBy(xpath = "//td[contains(text(), 'Current Generator(s)')]/following-sibling::td[1]/div")
    @CacheLookup
    private WebElement currentGeneContainer;

    @FindBy(xpath = "//td[contains(text(), 'Tracking Number')]/following-sibling::td[1]/div")
    @CacheLookup
    private WebElement trackingNumberContainer;

    @FindBy(xpath = "//td[contains(text(), 'Main Competitor(s)')]/following-sibling::td/div")
    @CacheLookup
    private WebElement mainContainer;

    @FindBy(xpath = "//td[contains(text(), 'Delivery/Installation Status')]/following-sibling::td/div")
    @CacheLookup
    private WebElement deliveryInstContainer;

    @FindBy(id = "opp14_ileinner")
    @CacheLookup
    private WebElement descriptionContainer;

    @Override
    public OpportunityForm clickEditBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        super.editBtn.click();
        return new OpportunityForm();
    }

    @Override
    public OpportunitiesHome clickDeleteBtn(boolean confirmDeletion) {
        super.clickDeleteButton(confirmDeletion);
        return new OpportunitiesHome();
    }

    public String getOpportunityNameContainer() {
        return this.opportunityNameContainer.getText();
    }

    public String getAccountNameTxtContainer() {
        return this.accountNameTxtContainer.getText();
    }

    public String getTypeComBoxContainer() {
        return this.typeComBoxContainer.getText();
    }

    public String getLeadSourceContainer() {
        return this.leadSourceContainer.getText();
    }

    public String getAmount() {
        return Helper.removeSubstringToString("$", this.amountContainer.getText());
    }

    public String getCloseDateValue() {
        return this.closeDateContainer.getText();
    }

    public String getNexStep() {
        return this.nextStepContainer.getText();
    }

    public String getStageValue() {
        return this.stageContainer.getText();
    }

    public String getProbability() {
        return Helper.removeSubstringToString("%", this.probabilityContainer.getText());
    }

    public String getOrderNumber() {
        return this.orderNumberContainer.getText();
    }

    public String getCurrentGenerator() {
        return this.currentGeneContainer.getText();
    }

    public String getTrackingNumber() {
        return this.trackingNumberContainer.getText();
    }

    public String getMainCompetitor() {
        return this.mainContainer.getText();
    }

    public String getDeliveryInstallStatus() {
        return this.deliveryInstContainer.getText();
    }

    public String getDescription() {
        return this.descriptionContainer.getText();
    }
}
