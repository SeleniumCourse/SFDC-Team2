package junit;

import framework.DriverManager;
import framework.Environment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

/**
 * Created by Fernando Nakamura on 6/26/2015.
 */
public class CreatePostChatter {

    private Login loginPage;
    private MainApp mainApp;

    private ChatterPage appChatter;

    @Before
    public void setUp() {
//        loginPage = new LoginPage();
//        String email = Environment.getInstance().getPrimaryUser();
//        String password = Environment.getInstance().getPrimaryPassword();
//        String userName = Environment.getInstance().getDisplayName();
//
//        mainApp = loginPage.loginAs(email,password,userName);
    }

    @Test
    public void testUntitled() {

//        AppHeader appHeader = mainApp.goToAppHeader();
//        appChatter = appHeader.clickChatter();
//
//        appChatter.shareComment("POST1");
//        appChatter.replyComment("POST1.1");
//        Assert.assertTrue("Test Passed", true);

    }

    @After
    public void tearDown() {
//        appChatter.clickDeletePost();

    }
}
