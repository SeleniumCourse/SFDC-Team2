package tests.product;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.product.ProductDetails;
import pages.product.ProductForm;
import utils.ProductGenie;

/**
 * Created by Virginia Sanabria on 9/5/2015.
 */
public class EditProduct {
    private ProductDetails productDetails;
    private ProductForm productForm;

    private final String productName = "test_product02";
    private final String updateProductName = "update_test_product02";
    private final String productCode = "update_test_code";
    private final String description = "update product";
    private final boolean isActive = false;

    @BeforeClass
    public void setUp() {
        productDetails = ProductGenie.createActiveProductObject(productName);
    }

    @Test
    public void editProduct() {
        productForm = productDetails.clickEditBtn();
        productDetails = productForm.setProductName(updateProductName)
                .setProductCode(productCode)
                .setDescription(description)
                .setActiveStatus(isActive)
                .clickSaveBtn();

        Assert.assertEquals(productDetails.getProductNameContainer(), updateProductName, "The product name is not updated as expected");
        Assert.assertEquals(productDetails.getProductCodeContainer(), productCode, "The product code is not updated as expected");
        Assert.assertEquals(productDetails.getDescriptionContainer(), description, "The product description is not updated as expected");
        Assert.assertEquals(productDetails.getActiveStatus(), isActive, "The product status is not updated as expected");

    }

    @AfterClass
    public void tearDown() {
        ProductGenie.deleteProductAndQuitBrowserDriver(productDetails);
    }
}
