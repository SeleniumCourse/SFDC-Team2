package pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.FormBase;

/**
 * Created by Virginia Sanabria on 9/5/2015.
 */
public class ProductForm extends FormBase {
    @FindBy(id = "Name")
    @CacheLookup
    private WebElement productNameTxt;

    @FindBy(id = "ProductCode")
    @CacheLookup
    private WebElement productCodeTxt;

    @FindBy(id = "Description")
    @CacheLookup
    private WebElement productDescriptionTextArea;

    @FindBy(id = "IsActive")
    @CacheLookup
    private WebElement activeChkbox;

    public ProductForm setProductName(String productName) {
        super.webDriverTools.clearAndSendKeys(this.productNameTxt, productName);
        return this;
    }

    public ProductForm setProductCode(String productCode) {
        super.webDriverTools.clearAndSendKeys(this.productCodeTxt, productCode);
        return this;
    }

    public ProductForm setDescription(String description) {
        super.webDriverTools.clearAndSendKeys(this.productDescriptionTextArea, description);
        return this;
    }

    public ProductForm setActiveStatus(boolean isActive) {
        super.webDriverTools.checkOrClearCheckbox(activeChkbox, isActive);
        return this;
    }

    @Override
    public ProductDetails clickSaveBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        super.saveBtn.click();
        return new ProductDetails();
    }
}
