package pages.basepages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Virginia Sanabria on 9/7/2015.
 */
public class BaseViewDetails extends BaseHome {
    @FindBy(name = "fcf")
    @CacheLookup
    WebElement viewList;

    @FindBy(linkText = "Delete")
    @CacheLookup
    protected WebElement deleteLnk;

    @Override
    public Object clickNewBtn() {
        return null;
    }

    @Override
    public Object clickCreateNewViewLnk() {
        return null;
    }

    public String getFirstSelectedView() {
        try {
            return new Select(this.viewList).getFirstSelectedOption().getText();
        } catch (WebDriverException e) {
            return "";
        }
    }

    public BaseViewDetails clickDeleteBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(deleteLnk));
        this.deleteLnk.click();
        super.webDriverTools.clickOnConfirmationAlertOption("OK");
        return this;
    }
}
