package pages.lead;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.BaseHome;

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

}
