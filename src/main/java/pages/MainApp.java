package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class MainApp {
    private WebDriver driver;

    public MainApp(WebDriver driver){
        this.driver = driver;
    }

    public NavigationTab goToNavigationTab(){
        return new NavigationTab(driver);
    }
}
