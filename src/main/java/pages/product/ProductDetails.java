package pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.DetailsBase;

/**
 * Created by Virginia Sanabria on 9/5/2015.
 */
public class ProductDetails extends DetailsBase {
    @FindBy(id = "Name_ileinner")
    @CacheLookup
    private WebElement productNameContainer;

    @FindBy(id = "ProductCode_ileinner")
    @CacheLookup
    private WebElement productCodeContainer;

    @FindBy(id = "Description_ilecell")
    @CacheLookup
    private WebElement productDesContainer;

    @FindBy(id = "IsActive_chkbox")
    @CacheLookup
    private WebElement activeStatusContainer;

    @Override
    public ProductForm clickEditBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        super.editBtn.click();
        return new ProductForm();
    }

    @Override
    public ProductHome clickDeleteBtn(boolean confirmDeletion) {
        super.clickDeleteButton(confirmDeletion);
        return new ProductHome();
    }

    public String getProductNameContainer() {
        return this.productNameContainer.getText();
    }

    public boolean getActiveStatus() {
        super.wait.until(ExpectedConditions.visibilityOf(this.activeStatusContainer));
        String title = this.activeStatusContainer.getAttribute("title");
        return title.equalsIgnoreCase("Checked");
    }

    public String getProductCodeContainer() {
        return this.productCodeContainer.getText();
    }

    public String getDescriptionContainer() {
        return this.productDesContainer.getText();
    }
}
