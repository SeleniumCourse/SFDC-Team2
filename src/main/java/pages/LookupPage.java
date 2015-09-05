package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.basepages.BaseHome;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Virginia Sanabria on 8/27/2015.
 */
public class LookupPage extends BaseHome {
    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement searchTxt;

    @FindBy(css = "input[title='Go!']")
    @CacheLookup
    private WebElement goBtn;

    @FindBy(id = "searchFrame")
    private WebElement searchFrame;

    @FindBy(id = "resultsFrame")
    private WebElement resultsFrame;

    @Override
    public Object clickNewBtn() {
        return null;
    }

    public void searchByAccountName(String accountName) {
        super.driver.switchTo().frame(this.searchFrame);
        searchTxt.clear();
        searchTxt.sendKeys(accountName);
        goBtn.click();
        super.driver.switchTo().defaultContent();
    }

    public void clickAccountName(String accountName) {
        super.driver.switchTo().frame(this.resultsFrame);
        super.driver.findElement(By.linkText(accountName)).click();
    }

    public void selectAccount(String accountName) {
        String windowID = super.driver.getWindowHandle();
        Set<String> setWindows = super.driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<String>(setWindows);
        super.driver.switchTo().window(listWindows.getLast());

        LookupPage lookupPage = new LookupPage();
        lookupPage.searchByAccountName(accountName);
        lookupPage.clickAccountName(accountName);

        super.driver.switchTo().window(windowID);
    }
}
