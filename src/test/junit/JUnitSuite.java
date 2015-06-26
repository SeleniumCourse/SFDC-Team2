package test.junit;

import framework.DriverManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Mario Perez on 6/4/2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreateNewLead.class,
        EditLead.class,
        CreateNewCampaign.class,
        EditCampaign.class
})


public class JUnitSuite {
    @AfterClass
    public static void afterSuite() {
        DriverManager.getInstance().quit();
    }
}
