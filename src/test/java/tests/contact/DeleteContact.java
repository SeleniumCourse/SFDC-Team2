package tests.contact;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.contact.ContactDetails;
import pages.contact.ContactHome;
import utils.ContactGenie;
import utils.Helper;

/**
 * Created by noelia on 9/6/2015.
 */
public class DeleteContact {


        private ContactDetails contactDetails;
        private final String CONTACT_NAME = Helper.generateUniqueString("C");

        @BeforeClass
        public void SetUp() {
            contactDetails = ContactGenie.createContactObject(CONTACT_NAME);
        }

        @Test
        public void deleteContact() {
            ContactHome contactHome = contactDetails.clickDeleteBtn(true);

            Assert.assertFalse(contactHome. isContactHomePresent(CONTACT_NAME));
        }
}
