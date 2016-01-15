package components;

import framework.DriverManager;
import framework.WebDriverTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Virginia Sanabria on 9/1/2015.
 */
public abstract class BaseWebUI {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverTools webDriverTools;

    public BaseWebUI() {
        this.driver = DriverManager.getInstance().getDriver();
        this.wait = DriverManager.getInstance().getWait();
        this.webDriverTools = new WebDriverTools(this.driver, this.wait);
        PageFactory.initElements(driver, this);
    }
}
