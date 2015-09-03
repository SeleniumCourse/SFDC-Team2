package pages.basepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import components.BaseWebUI;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public abstract class DetailsBase extends BaseWebUI {

    @FindBy(name = "edit")
    @CacheLookup
    protected WebElement editBtn;

    public DetailsBase() {

    }

    public abstract Object clickEditBtn();
}
