package pages;

import components.BaseWebUI;
import components.NavigationTab;
import org.openqa.selenium.WebDriver;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class MainApp extends BaseWebUI {

    public MainApp(){
    }

    public NavigationTab goToNavigationTab(){
        return new NavigationTab();
    }
}
