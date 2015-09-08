package pages.basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import components.BaseWebUI;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public abstract class BaseHome extends BaseWebUI {

    @FindBy(css = "input[name='new']")
    @CacheLookup
    protected WebElement newBtn;

    @FindBy(linkText = "Create New View")
    @CacheLookup
    protected WebElement createNewViewLnk;

   public BaseHome() {
   }

    public abstract Object clickNewBtn();
    public abstract Object clickCreateNewViewLnk();

    public boolean isItemPresentInList(String itemName) {
        return driver.findElements(By.linkText(itemName)).size() > 0;
    }
}
