package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mario Perez on 6/3/2015.
 */
public class DriverManager {

    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;

    private final String baseUrl = "https://login.salesforce.com";
    private String browser = Environment.getInstance().getBrowser();
    private String mode = Environment.getInstance().getMode();
    private String userName = Environment.getInstance().getUserName();
    private String key = Environment.getInstance().getKey();
    private String remoteBrowser = Environment.getInstance().getRemoteBrowser();
    private String remotePlatform = Environment.getInstance().getRemotePlatform();
    private String remoteVersion = Environment.getInstance().getRemoteVersion();


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
        if (mode.equalsIgnoreCase("Local")) {
            if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (browser.equalsIgnoreCase("Safari")) {
                driver = new SafariDriver();
            }
        }else if (mode.equalsIgnoreCase("Remote")) {
            DesiredCapabilities caps = null;
            if(remoteBrowser.equalsIgnoreCase("Chrome")) {
                caps = DesiredCapabilities.chrome();
            }else if (remoteBrowser.equalsIgnoreCase("Firefox")) {
                caps = DesiredCapabilities.firefox();
            }
            caps.setCapability("platform", remotePlatform);
            caps.setCapability("version", remoteVersion);
            try {
                this.driver = new RemoteWebDriver(
                        new URL("http://" + userName + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
                        caps);
            }catch(MalformedURLException e){
                LogManager.getInstance().addErrorLog(this.getClass().getName(), "Error on Initializer on remote environment :", e);
            }
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);

        driver.get(baseUrl);

        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getBaseUrl() { return baseUrl; }

    public void quit() {
        try{
            driver.quit();
        }
        catch(WebDriverException e){
            LogManager.getInstance().addErrorLog(this.getClass().getName(), e.getMessage(), e);
        }
    }
}
