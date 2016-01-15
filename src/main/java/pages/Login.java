package pages;

import components.BaseWebUI;
import framework.DriverManager;
import framework.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class Login extends BaseWebUI {

    @FindBy(id = "username")
    @CacheLookup
    private WebElement userNameTxt;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginBtn;

    public Login(){
    }

    public void setUserName(String userName){
        wait.until(ExpectedConditions.visibilityOf(userNameTxt));
        userNameTxt.clear();
        userNameTxt.sendKeys(userName);
    }

    public void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordTxt));
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
    }

    public MainApp loginAsPrimaryUser(){
        String userName = Environment.getInstance().getPrimaryUser();
        String password = Environment.getInstance().getPrimaryPassword();

        setUserName(userName);
        setPassword(password);
        return clickLoginBtn();
    }

    public MainApp clickLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        return new MainApp();
    }

}
