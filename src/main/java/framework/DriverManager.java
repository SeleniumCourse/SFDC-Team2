package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mario Perez on 6/3/2015.
 */
public class DriverManager {

    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;
    String browser;

    private DriverManager() {
        browser = Environment.getInstance().getBrowser();
        this.initializeDriver();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void initializeDriver(){
        String baseUrl = "https://login.salesforce.com";

        if(browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if(browser.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,15);

        driver.get(baseUrl);

        driver.manage().window().maximize();

    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void quit() {
        driver.quit();
    }
}
