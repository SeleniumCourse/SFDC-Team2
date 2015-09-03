package pages.Lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.basepages.FormBase;

/**
 * Created by Marcelo Ferrufino on 9/3/2015.
 */
public class LeadForm extends FormBase{

    @FindBy (id = "name_salutationlea2")
    @CacheLookup
    private WebElement salutationCmBox;

    @FindBy (id = "name_firstlea2")
    @CacheLookup
    private WebElement firstNameTxt;

    @FindBy (id = "name_lastlea2")
    @CacheLookup
    private WebElement lastNameTxt;

    @FindBy (id = "lea3")
    @CacheLookup
    private WebElement companyTxt;

    @FindBy (id = "lea4")
    @CacheLookup
    private WebElement titleTxt;

    @FindBy (id = "lea5")
    @CacheLookup
    private WebElement leadSourceCmBox;

    public LeadForm selectSalutation(String option){
        wait.until(ExpectedConditions.visibilityOf(salutationCmBox));
        Select salutationPicklist = new Select(salutationCmBox);
        salutationPicklist.selectByValue(option);
        return this;
    }

    public LeadForm setFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
        firstNameTxt.clear();
        firstNameTxt.sendKeys(firstName);
        return this;
    }

    public LeadForm setLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOf(lastNameTxt));
        lastNameTxt.clear();
        lastNameTxt.sendKeys(lastName);
        return this;
    }



    @Override
    protected Object clickSaveBtn() {
        return null;
    }
}
