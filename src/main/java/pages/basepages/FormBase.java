package pages.basepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import components.BaseWebUI;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public abstract class FormBase extends BaseWebUI {

    @FindBy(css = "input[name='save']")
    @CacheLookup
    protected WebElement saveBtn;

    public FormBase() {
    }

    protected abstract Object clickSaveBtn();
}
