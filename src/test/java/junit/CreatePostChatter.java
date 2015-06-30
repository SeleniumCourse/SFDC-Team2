package test.java.junit;

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

    private LoginPage loginPage;
    private MainApp mainApp;

    private ChatterPage appChatter;

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        String email = "f_nak@hotmail.com";
        String password = "abc123456";
        String userName = "Fernando Nakamura";

        mainApp = loginPage.loginAs(email,password,userName);
    }

    @Test
    public void testUntitled() {

        AppHeader appHeader = mainApp.goToAppHeader();
        appChatter = appHeader.clickChatter();

        appChatter.shareComment("POST1");
        appChatter.replyComment("POST1.1");
        Assert.assertTrue("Test Passed", true);

    }

    @After
    public void tearDown() {
        appChatter.clickDeletePost();

    }
}
