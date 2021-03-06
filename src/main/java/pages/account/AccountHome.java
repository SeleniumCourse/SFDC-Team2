package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.BaseHome;
import pages.opportunity.OpportunityForm;
import pages.opportunity.OpportunityViewForm;

/**
 * Created by noelia on 8/26/2015.
 */

public class AccountHome extends BaseHome {



    public AccountDetails selectRecentCpn(String cpnName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(cpnName)));
        WebElement cpnLnk = driver.findElement(By.linkText(cpnName));
        cpnLnk.click();
        return new AccountDetails();
    }

    public boolean isAccountPresent(String cpnName) {
        return driver.findElements(By.linkText(cpnName)).size() > 0;
    }

    @Override
    public AccountForm clickNewBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(super.newBtn));
        super.newBtn.click();
        return new AccountForm();
    }

    @Override
    public AccountViewForm clickCreateNewViewLnk() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.createNewViewLnk));
        createNewViewLnk.click();
        return new AccountViewForm();
    }

}

