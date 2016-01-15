package pages.lead;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.BaseHome;
import pages.opportunity.OpportunityViewForm;

/**
 * Created by marcelo on 9/5/15.
 */
public class LeadHome extends BaseHome {

    @Override
    public LeadForm clickNewBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(super.newBtn));
        super.newBtn.click();
        return new LeadForm();
    }

    @Override
    public LeadViewForm clickCreateNewViewLnk() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.createNewViewLnk));
        createNewViewLnk.click();
        return new LeadViewForm();
    }
}
