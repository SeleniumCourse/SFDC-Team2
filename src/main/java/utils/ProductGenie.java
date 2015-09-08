package utils;

import components.NavigationTab;
import framework.DriverManager;
import pages.Login;
import pages.MainApp;
import pages.product.ProductDetails;
import pages.product.ProductForm;
import pages.product.ProductHome;

/**
 * Created by Virginia Sanabria on 9/6/2015.
 */
public class ProductGenie {

    public static void deleteProductAndQuitBrowserDriver(ProductDetails productDetails) {
        productDetails.clickDeleteButton(true);
        DriverManager.getInstance().getDriver().quit();
    }

    public static ProductDetails createActiveProductObject(String productName) {
        MainApp mainApp;

        if (Helper.isLoginPage()) {
            Login login = new Login();
            mainApp = login.loginAsPrimaryUser();
        }else {
            mainApp = new MainApp();
        }

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        ProductHome productHome = navigationTab.goToProductTab();
        ProductForm productForm = productHome.clickNewBtn();
        ProductDetails productDetails = productForm.setProductName(productName)
                .setActiveStatus(true)
                .clickSaveBtn();
        return productDetails;
    }
}
