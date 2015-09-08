package pages.Contact;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.BaseHome;
import pages.opportunity.OpportunityViewForm;

/**
 * Created by noelia on 9/6/2015.
 */
public class ContactHome extends BaseHome {
    @Override
    public Object clickNewBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(super.newBtn));
        super.newBtn.click();
        return new ContactForm();
    }

    @Override
    public ContactViewForm clickCreateNewViewLnk() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.createNewViewLnk));
        createNewViewLnk.click();
        return new ContactViewForm();
    }

    public boolean isContactHomePresent(String cpnName) {
        return driver.findElements(By.linkText(cpnName)).size() > 0;
    }
}
