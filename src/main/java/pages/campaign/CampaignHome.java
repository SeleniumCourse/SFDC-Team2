package pages.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.BaseHome;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class CampaignHome extends BaseHome {

    @Override
    public CampaignForm clickNewBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(super.newBtn));
        super.newBtn.click();
        return new CampaignForm();
    }

    public CampaignDetails selectRecentCpn(String cpnName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(cpnName)));
        WebElement cpnLnk = driver.findElement(By.linkText(cpnName));
        cpnLnk.click();
        return new CampaignDetails();
    }

    public boolean isCampaignPresent(String cpnName) {
        return driver.findElements(By.linkText(cpnName)).size() > 0;
    }
}
