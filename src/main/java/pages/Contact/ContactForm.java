package pages.Contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.FormBase;

/**
 * Created by noelia on 9/6/2015.
 */
public class ContactForm extends FormBase {

    @FindBy(id = "name_firstcon2")
    @CacheLookup
    private WebElement firstNameTxt;

    @FindBy(id = "name_salutationcon2")
    @CacheLookup
    private WebElement firstCmbbox;

    @FindBy(id = "name_lastcon2")
    @CacheLookup
    private WebElement lastNameTxt;

    @FindBy(id = "con5")
    @CacheLookup
    private WebElement litleTxt;

    @FindBy(id = "con6")
    @CacheLookup
    private WebElement departamentTxt;

    @FindBy(id = "con7")
    @CacheLookup
    private WebElement birthdateTxt;

    @FindBy(id = "con9")
    @CacheLookup
    private WebElement leadCmbbox;

    @FindBy(id = "con10")
    @CacheLookup
    private WebElement phoneTxt;

    @FindBy(id = "con12")
    @CacheLookup
    private WebElement mobileTxt;

    @FindBy(id = "con11")
    @CacheLookup
    private WebElement faxTxt;

    @FindBy(id = "con15")
    @CacheLookup
    private WebElement emailTxt;

    @FindBy(id = "con17")
    @CacheLookup
    private WebElement assstPhoneTxt;

    @FindBy(xpath = "//td[contains(., 'Languages')]/following-sibling::td//input")
    @CacheLookup
    private WebElement languagesTxt;

    @FindBy(xpath = "//td[contains(., 'Level')]/following-sibling::td//select")
    @CacheLookup
    private WebElement levelTxt;

    @FindBy(id = "con20")
    @CacheLookup
    private WebElement descriptionTxt;

    public ContactForm setDescription(String description) {
        super.webDriverTools.clearAndSendKeys(descriptionTxt, description);
        return this;
    }

    public ContactForm selectLevel(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(levelTxt, option);
        return this;
    }

    public ContactForm setLanguages(String languages) {
        super.webDriverTools.clearAndSendKeys(languagesTxt, languages);
        return this;
    }

    public ContactForm setAssisPhone(String assisphone) {
        super.webDriverTools.clearAndSendKeys(assstPhoneTxt, assisphone);
        return this;
    }

    public ContactForm setEmail(String email) {
        super.webDriverTools.clearAndSendKeys(emailTxt, email);
        return this;
    }

    public ContactForm setFax(String fax) {
        super.webDriverTools.clearAndSendKeys(faxTxt, fax);
        return this;
    }

    public ContactForm setMobile(String mobile) {
        super.webDriverTools.clearAndSendKeys(mobileTxt, mobile);
        return this;
    }

    public ContactForm setPhone(String phone) {
        super.webDriverTools.clearAndSendKeys(phoneTxt, phone);
        return this;
    }

    public ContactForm selectLead(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(leadCmbbox, option);
        return this;
    }

    public ContactForm setBirthDay(String birthday) {
        super.webDriverTools.clearAndSendKeys(birthdateTxt, birthday);
        return this;
    }

    public ContactForm setDepartament(String depart) {
        super.webDriverTools.clearAndSendKeys(departamentTxt, depart);
        return this;
    }

    public ContactForm setTitle(String title) {
        super.webDriverTools.clearAndSendKeys(litleTxt, title);
        return this;
    }

    public ContactForm setLastName(String lastName) {
        super.webDriverTools.clearAndSendKeys(lastNameTxt, lastName);
        return this;
    }

    public ContactForm setFirstName(String firstName) {
        super.webDriverTools.clearAndSendKeys(firstNameTxt, firstName);
        return this;
    }

    public ContactForm selectFirstName(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(firstCmbbox, option);
        return this;
    }

    @Override
    public ContactDetails clickSaveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return new ContactDetails();
    }
}
