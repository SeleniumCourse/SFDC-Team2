package pages.product;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.BaseHome;

/**
 * Created by Virginia Sanabria on 9/5/2015.
 */
public class ProductHome extends BaseHome {
    @Override
    public ProductForm clickNewBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(super.newBtn));
        super.newBtn.click();
        return new ProductForm();
    }
}
