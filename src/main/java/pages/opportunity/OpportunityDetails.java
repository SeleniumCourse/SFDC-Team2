package pages.opportunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.basepages.DetailsBase;

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

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement closeDateContainer;

    @FindBy(id = "opp10_ileinner")
    @CacheLookup
    private WebElement nextStepContainer;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement stageContainer;

    @Override
    public Object clickEditBtn() {
        //TODO
        return null;
    }

    public String getOpportunityNameContainer() {
        return this.opportunityNameContainer.getText();
    }

    public String getAccountNameTxtContainer() {
        return this.accountNameTxtContainer.getText();
    }

    public String getCloseDateValue() {
        return this.closeDateContainer.getText();
    }

    public String getStageValue() {
        return this.stageContainer.getText();
    }

    public String getTypeComBoxContainer() {
        return this.typeComBoxContainer.getText();
    }

    public String getLeadSourceContainer() {
        return this.leadSourceContainer.getText();
    }

    public String getAmount() {
        //TODO
        return null;
    }

    public String getNexStep() {
        return this.nextStepContainer.getText();
    }

    public String getProbability() {
        //TODO
        return null;
    }

    public String getOrderNumber() {
        //TODO
        return null;
    }

    public String getCurrentGenerator() {
        //TODO
        return null;
    }

    public String getTrackingNumber() {
        //TODO
        return null;
    }

    public String getMainCompetitor() {
        //TODO
        return null;
    }

    public String getDeliveryInstallStatus() {
        //TODO
        return null;
    }

    public String getDescription() {
        //TODO
        return null;
    }
}
