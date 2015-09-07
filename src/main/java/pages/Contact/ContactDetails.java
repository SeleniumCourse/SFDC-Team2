package pages.Contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basepages.DetailsBase;

/**
 * Created by noelia on 9/6/2015.
 */
public class ContactDetails extends DetailsBase {

    @FindBy(id = "con2_ileinner")
    @CacheLookup
    private WebElement firstNameContainer;

    @FindBy(id = "con5_ileinner")
    @CacheLookup
    private WebElement titleContainer;

    @FindBy(id = "con6_ileinner")
    @CacheLookup
    private WebElement departmentContainer;

    @FindBy(id = "con9_ileinner")
    @CacheLookup
    private WebElement leadContainer;

    @FindBy(id = "con7_ileinner")
    @CacheLookup
    private WebElement birthDayContainer;

    @FindBy(id = "con10_ileinner")
    @CacheLookup
    private WebElement phoneContainer;

    @FindBy(id = "con12_ileinner")
    @CacheLookup
    private WebElement mobilePhoneContainer;

    @FindBy(id = "con11_ileinner")
    @CacheLookup
    private WebElement faxContainer;

    @FindBy(id = "con16_ileinner")
    @CacheLookup
    private WebElement assistantContainer;

    @FindBy(id = "con17_ileinner")
    @CacheLookup
    private WebElement assistantPhoneContainer;

    @FindBy(id = "con20_ileinner")
    @CacheLookup
    private WebElement descriptionContainer;

    @FindBy(id = "con15_ileinner")
    @CacheLookup
    private WebElement emailContainer;

    @FindBy(xpath = "//td[contains(., 'Languages')]/following-sibling::td//div")
    @CacheLookup
    private WebElement languagesContainer;

    @FindBy(xpath = "//td[contains(., 'Level')]/following-sibling::td//div")
    @CacheLookup
    private WebElement levelContainer;

    public String getlanguages() {
        wait.until(ExpectedConditions.visibilityOf(levelContainer));
        return levelContainer.getText();
    }

    public String getAssistantLevel() {
        wait.until(ExpectedConditions.visibilityOf(levelContainer));
        return levelContainer.getText();
    }

    public String getEmail() {
        wait.until(ExpectedConditions.visibilityOf(emailContainer));
        return emailContainer.getText();
    }

    public String getAssistantPhone() {
        wait.until(ExpectedConditions.visibilityOf(assistantPhoneContainer));
        return assistantPhoneContainer.getText();
    }

    public String getAssistant() {
        wait.until(ExpectedConditions.visibilityOf(assistantContainer));
        return assistantContainer.getText();
    }

    public String getDescription() {
        wait.until(ExpectedConditions.visibilityOf(descriptionContainer));
        return descriptionContainer.getText();
    }

    public String getFax() {
        wait.until(ExpectedConditions.visibilityOf(faxContainer));
        return faxContainer.getText();
    }

    public String getlead() {
        wait.until(ExpectedConditions.visibilityOf(leadContainer));
        return leadContainer.getText();
    }

    public String getMobilePhone() {
        wait.until(ExpectedConditions.visibilityOf(mobilePhoneContainer));
        return mobilePhoneContainer.getText();
    }

    public String getPhone() {
        wait.until(ExpectedConditions.visibilityOf(phoneContainer));
        return phoneContainer.getText();
    }

    public String getBirthDay() {
        wait.until(ExpectedConditions.visibilityOf(birthDayContainer));
        return birthDayContainer.getText();
    }

    public String getFistName() {
        String contactName;
        wait.until(ExpectedConditions.visibilityOf(firstNameContainer));
        contactName = firstNameContainer.getText();
        return contactName;
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOf(titleContainer));
        return titleContainer.getText();
    }

    public String getDepartment() {
        wait.until(ExpectedConditions.visibilityOf(departmentContainer));
        return departmentContainer.getText();
    }

    @Override
    public ContactForm clickEditBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        editBtn.click();
        return new ContactForm();
    }

    @Override
    public ContactHome clickDeleteBtn(boolean confirmDeletion) {
        clickDeleteButton(confirmDeletion);
        return new ContactHome();
    }
}
