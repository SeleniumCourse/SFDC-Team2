package pages.opportunity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.BaseHome;
import pages.campaign.CampaignForm;

/**
 * Created by Virginia Sanabria on 8/28/2015.
 */
public class OpportunitiesHome extends BaseHome {

    @Override
    public OpportunityForm clickNewBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(super.newBtn));
        super.newBtn.click();
        return new OpportunityForm();
    }
}
