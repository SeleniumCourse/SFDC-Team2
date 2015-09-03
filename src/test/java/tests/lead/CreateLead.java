package tests.lead;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.MainApp;
import pages.NavigationTab;

/**
 * Created by Marcelo Ferrufino on 9/3/2015.
 */
public class CreateLead {
    private MainApp mainApp;

    @BeforeClass
    public void setUp(){
        Login login = new Login();
        mainApp = login.loginAsPrimaryUser();
    }

    @Test
    public void createLead(){
        NavigationTab navigationTab = mainApp.goToNavigationTab();

    }

}
