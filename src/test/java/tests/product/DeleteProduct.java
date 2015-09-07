package tests.product;

import framework.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.product.ProductDetails;
import pages.product.ProductHome;
import utils.ProductGenie;

/**
 * Created by Virginia Sanabria on 9/5/2015.
 */
public class DeleteProduct {
    private ProductDetails productDetails;
    private final String productName = "test_product03";

    @BeforeClass
    public void setUp() {
        productDetails = ProductGenie.createActiveProductObject(productName);
    }

    @Test
    public void deleteProduct() {
        ProductHome productHome = productDetails.clickDeleteBtn(true);
        String errorMessage = String.format("The %s product is displayed yet", productName);
        Assert.assertFalse(productHome.isItemPresentInList(productName), errorMessage);
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().getDriver().quit();
    }
}
