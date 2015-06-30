package pages;

import framework.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mario Perez on 6/3/2015.
 */
public class AppBody {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Create New View")
    @CacheLookup
    private WebElement newViewLink;

    @FindBy(linkText = "Edit")
    //@CacheLookup
    private WebElement editLink;

    @FindBy(linkText = "Delete")
    @CacheLookup
    private WebElement deleteLink;

    @FindBy(name = "fcf")
    @CacheLookup
    WebElement viewList;
	
    public AppBody(WebDriver driver) {

        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(10, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(newViewLink));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }

    }

    public void setViewComboBox(String leadName) {
        Select leadNameBox =
                new Select(driver.findElement(By.name("fcf")));

        leadNameBox.selectByVisibleText(leadName);
    }

    public ViewPage clickNewView() {
        newViewLink.click();
        return new ViewPage(driver);
    }

    public ViewPage clickNewProductView() {
        List<WebElement> productViewLink = driver.findElements(By.linkText( "Create New View"));
        productViewLink.get(1).click();
        return new ViewPage(driver);
    }

    public ViewPage clickEditView() {
        editLink.click();
        return new ViewPage(driver);
    }

    public void clickDelete() {
        deleteLink.click();
        Alert alert = driver.switchTo().alert();
        // Click the OK button in the Alert
        alert.accept();
    }
	

    public Boolean getSelectedValue(String to_verify) {
        int band = 0;
        String text = " ";
        Select option = new Select(viewList);
        List<WebElement> NewList = option.getOptions();

        for ( WebElement we: NewList) {
            text = we.getText();
            if (to_verify.equals(text)) {
                return true;
            }
        }
        return false;
    }
}
