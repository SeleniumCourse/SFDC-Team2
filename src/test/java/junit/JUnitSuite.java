package junit;

import framework.DriverManager;
import framework.Environment;
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
        EditCampaign.class,
		CreateNewOpportunities.class,
        EditOpportunities.class,
		CreateNewProducts.class,
        EditProducts.class,
        CreatePostChatter.class,
        CreateNewAccount.class,
        EditAccount.class,
        CreateNewContact.class,
        EditContact.class
})

public class JUnitSuite {
    @AfterClass
    public static void afterSuite() {
        DriverManager.getInstance().quit();
    }
}
