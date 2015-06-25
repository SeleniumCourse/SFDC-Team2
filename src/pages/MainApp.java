package pages;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Mario Perez on 6/3/2015.
 */
public class MainApp {

        private WebDriver driver;
        private WebDriverWait wait;

        private AppHeader appHeader;


        public MainApp(WebDriver driver) {
            this.driver = driver;
            wait = DriverManager.getInstance().getWait();
            appHeader = new AppHeader(driver);

        }

        public AppHeader goToAppHeader() {
            return appHeader;
        }


}
