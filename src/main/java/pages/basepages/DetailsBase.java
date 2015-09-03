package pages.basepages;

import framework.DriverManager;
import framework.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public abstract class DetailsBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "edit")
    @CacheLookup
    protected WebElement editBtn;

    @FindBy(css = "input[value='Delete']")
    @CacheLookup
    protected WebElement deleteBtn;

    public DetailsBase() {
        this.driver = DriverManager.getInstance().getDriver();
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public abstract Object clickEditBtn();

    public abstract Object clickDeleteBtn(boolean confirmDeletion);

    public void clickDeleteButton(boolean confirmDeletion) {
        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
        deleteBtn.click();
        Alert alert;

        try {
            alert = driver.switchTo().alert();

            if (confirmDeletion) {
                alert.accept();
                LogManager.getInstance().addInformationLog(this.getClass().getName(),
                        "Accept button was clicked on Delete dialog");
            } else {
                alert.dismiss();
                LogManager.getInstance().addInformationLog(this.getClass().getName(),
                        "Cancel button was clicked on Delete dialog");
            }
        } catch (WebDriverException e) {
            LogManager.getInstance().addErrorLog(this.getClass().getName(),
                    "Delete button could not be clicked", e.fillInStackTrace());
        }
    }
}
