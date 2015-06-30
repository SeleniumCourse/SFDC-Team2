package pages;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Mario Perez on 6/3/2015.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    @CacheLookup
    WebElement userNameTxt;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    WebElement loginSalesForceBtn;

    public LoginPage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public void setUserNameTxt(String userName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameTxt));
            userNameTxt.clear();
            userNameTxt.sendKeys(userName);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void setPasswordTxt(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordTxt));
            passwordTxt.clear();
            passwordTxt.sendKeys(password);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public MainApp clickLoginBtn() {
        try {
            loginSalesForceBtn.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new MainApp(driver);
    }

    public MainApp loginAs(String user, String password, String userName) {
        MainApp mainApp;
        try {
            mainApp = new MainApp(driver);
            AppHeader appHeader = mainApp.goToAppHeader();
            if (appHeader.isSalesForceImgDisplayed()) {
                if (!appHeader.isLoggedAsUserName(userName)){
                    appHeader.logoutUser();
                    //LoginForm loginForm = clickLoginBtn();
                    setUserNameTxt(user);
                    setPasswordTxt(password);
                    return clickLoginBtn();
                    //loginForm.loginAs(email, password);
                }
            }

        } catch (WebDriverException e) {
            setUserNameTxt(user);
            setPasswordTxt(password);
            return clickLoginBtn();
        }
        return mainApp;
    }


}
