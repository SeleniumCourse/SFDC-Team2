package pages.opportunity;

import org.openqa.selenium.WebDriver;
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
    private WebElement opportunityName;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    private WebElement accountName;

    @FindBy(id = "opp5_ileinner")
    @CacheLookup
    private WebElement type;

    @FindBy(id = "opp6_ileinner")
    @CacheLookup
    private WebElement leadSource;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement closeDate;

    @FindBy(id = "opp10_ileinner")
    @CacheLookup
    private WebElement nextStep;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement stage;

    @Override
    public Object clickEditBtn() {
        //TODO
        return null;
    }

    public String getOpportunityName() {
        return this.opportunityName.getText();
    }

    public String getAccountName() {
        return this.accountName.getText();
    }

    public String getCloseDateValue() {
        return this.closeDate.getText();
    }

    public String getStageValue() {
        return this.stage.getText();
    }

    public String getType() {
        return this.type.getText();
    }

    public String getLeadSource() {
        return this.leadSource.getText();
    }

    public String getAmount() {
        //TODO
        return null;
    }

    public String getNexStep() {
        return this.nextStep.getText();
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
