package pages.account;
import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.BaseHome;
/**
 * Created by noelia on 8/26/2015.
 */

public class AccountHome extends BaseHome {
    public AccountHome(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    @Override
    public  AccountForm clickNewBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(newBtn));
        newBtn.click();
        return new AccountForm(driver);
    }
}
