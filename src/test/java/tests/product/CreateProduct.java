package tests.product;

import components.NavigationTab;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.product.ProductDetails;
import pages.product.ProductForm;
import pages.product.ProductHome;
import utils.ProductGenie;

/**
 * Created by Virginia Sanabria on 9/6/2015.
 */
public class CreateProduct {
    private MainApp mainApp;
    private ProductDetails productDetails;

    private final String productName = "test_product";
    private final String productCode = "test_code";
    private final String description = "new product";
    private final boolean isActive = true;

    @BeforeClass
    public void setUp() {
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }

    @Test
    public void createProduct() {
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        ProductHome productHome = navigationTab.goToProductTab();
        ProductForm productForm = productHome.clickNewBtn();
        productDetails = productForm.setProductName(productName)
                .setProductCode(productCode)
                .setDescription(description)
                .setActiveStatus(isActive)
                .clickSaveBtn();

        Assert.assertEquals(productDetails.getProductNameContainer(), productName, "The product name is not the expected");
        Assert.assertEquals(productDetails.getProductCodeContainer(), productCode, "The product code is not the expected");
        Assert.assertEquals(productDetails.getDescriptionContainer(), description, "The product description is not the expected");
        Assert.assertEquals(productDetails.getActiveStatus(), isActive, "The product status is not the expected");
    }

    @AfterClass
    public void tearDown() {
        ProductGenie.deleteProductAndQuitBrowserDriver(productDetails);
    }
}
