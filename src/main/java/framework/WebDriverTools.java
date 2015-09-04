package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Virginia Sanabria on 8/31/2015.
 */
public class WebDriverTools {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriverTools(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clearAndSendKeys(WebElement element, String value) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public void selectOptionInComboBoxByVisibleText(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (WebDriverException e) {
            throw new WebDriverException("The combo box is not displayed:", e.getCause());
        }
    }
}
