package pages.basepages;

import components.BaseWebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.ViewPage;

import java.util.List;

/**
 * Created by Virginia Sanabria on 9/7/2015.
 */
public class BaseViewForm extends BaseWebUI {

    @FindBy(id = "fname")
    @CacheLookup
    WebElement viewNameTxt;

    @FindBy(id = "devname")
    @CacheLookup
    WebElement viewUniqueNameTxt;

    @FindBy(id = "fscope0")
    @CacheLookup
    WebElement allViewRadioBtn;

    @FindBy(id = "fscope1")
    @CacheLookup
    WebElement myViewRadioBtn;

    @FindBy(id = "colselector_select_0")
    @CacheLookup
    WebElement availableFieldsMultiSelect;

    @FindBy(id = "fsharefsharenone")
    @CacheLookup
    WebElement visibleOnlyToMeRadioBtn;

    @FindBy(id = "fsharefshareall")
    @CacheLookup
    WebElement visibleAllUsersRadioBtn;

    @FindBy(id = "fsharefsharegroups")
    @CacheLookup
    WebElement visibleCertainGroupsRadioBtn;

    @FindBy(className = "rightArrowIcon")
    @CacheLookup
    private WebElement rightArrow;

    @FindBy(css = ".pbHeader .btn.primary")
    @CacheLookup
    WebElement saveHeaderBtn;


    public BaseViewForm setViewNameTxt(String viewName) {
        super.webDriverTools.clearAndSendKeys(this.viewNameTxt, viewName);
        return this;
    }

    public BaseViewForm setViewUniqueNameTxt(String viewUniqueName) {
        super.webDriverTools.clearAndSendKeys(this.viewUniqueNameTxt, viewUniqueName);
        return this;
    }

    public BaseViewDetails clickSaveBtn() {
        super.wait.until(ExpectedConditions.elementToBeClickable(this.saveHeaderBtn));
        this.saveHeaderBtn.click();
        return new BaseViewDetails();
    }

    public BaseViewForm selectFieldComboBox(int position, String fieldValue) {
        String id = "fcol" + position;
        WebElement fieldCombBoxElem = super.driver.findElement(By.id(id));
        super.webDriverTools.selectOptionInComboBoxByVisibleText(fieldCombBoxElem, fieldValue);
        return this;
    }

    public BaseViewForm selectOperatorComboBox(int position, String operatorValue) {
        String positionString = Integer.toString(position);
        String id = "fop" + positionString;
        Select operatorBox = new Select(driver.findElement(By.id(id)));
        operatorBox.selectByVisibleText(operatorValue);
        return this;
    }

    public BaseViewForm setValueTxt(int position, String valueTxt) {
        String id = "fval" + position;
        WebElement valueElem = super.driver.findElement(By.id(id));
        super.webDriverTools.clearAndSendKeys(valueElem, valueTxt);
        return this;
    }

    public BaseViewForm selectFieldsTodDisplayed(List<String> displayedFields) {
        Select multiSelect =  new Select(availableFieldsMultiSelect);
        for (String field : displayedFields) {
            multiSelect.selectByVisibleText(field);
        }
        this.rightArrow.click();
        return this;
    }

    public String getViewName() {
        return this.viewNameTxt.getAttribute("value");
    }

    public String getViewUniqueName() {
        return this.viewUniqueNameTxt.getAttribute("value");
    }
}
