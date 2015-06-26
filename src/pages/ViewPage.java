package pages;

import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mario Perez on 6/10/2015.
 */
public class ViewPage {

    private WebDriver driver;
    private WebDriverWait wait;


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

    @FindBy(id = "fsharefshareall")
    @CacheLookup
    WebElement visibleAllUsersRadioBtn;

    @FindBy(id = "fsharefsharegroups")
    @CacheLookup
    WebElement visibleCertainGroupsRadioBtn;

    @FindBy(id = "fsharefsharenone")
    @CacheLookup
    WebElement visibleOnlyToMeRadioBtn;

    @FindBy(xpath = "//input[contains(@data-uidsfdc,'3')]")
    @CacheLookup
    private WebElement saveBtn;

    @FindBy(className = "rightArrowIcon")
    @CacheLookup
    private WebElement rightArrow;


    private String viewName, viewUniqueName;
    private String [][] filterAdditionalFields;
    private String [] availableFields;
    private boolean visibleToMe, visibleAllUsers, visibleGroupUsers, filterByOwnerMyView, filterByOwnerAllViews;

    public ViewPage(WebDriver driver) {

        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);

    }

    public ViewPage(ViewPageBuilder builder) {

        this.viewName = builder.getViewName();
        this.viewUniqueName = builder.getUniqueName();
        this.filterAdditionalFields = builder.getFilterByAdditionalField();
        this.availableFields = builder.getAvailableFields();
        this.visibleToMe = builder.getVisibleToMe();
        this.visibleGroupUsers = builder.getVisibleGroupUsers();
        this.visibleAllUsers = builder.getVisibleAllUsers();
        this.filterByOwnerMyView = builder.getFilterByOwnerMyViewRadioBtn();
        this.filterByOwnerAllViews = builder.getFilterByOwnerAllViewsRadioBtn();


        this.driver = DriverManager.getInstance().getDriver();
        this.wait = DriverManager.getInstance().getWait();

        PageFactory.initElements(driver, this);

    }

    public void setViewNameTxt(String viewName){
        viewNameTxt.clear();
        viewNameTxt.sendKeys(viewName);
        //return this;
    }

    public void setViewUniqueNameTxt(String viewUniqueName){
        viewUniqueNameTxt.clear();
        viewUniqueNameTxt.sendKeys(viewUniqueName);
        //return this;
    }

    public void filterByOwnerMyViewRadioBtn(){
        if (!myViewRadioBtn.isSelected()) {
            myViewRadioBtn.click();
        }
        //return this;
    }

    public void filterByOwnerAllViewsRadioBtn(){
        if (!allViewRadioBtn.isSelected()) {
            allViewRadioBtn.click();
        }
        //return this;
    }

    public void visibleAllUsersRadioBtn(){
        if (!visibleAllUsersRadioBtn.isSelected()) {
            visibleAllUsersRadioBtn.click();
        }
        //return this;
    }

    public void visibleCertainGroupsRadioBtn(){
        if (!visibleCertainGroupsRadioBtn.isSelected()) {
            visibleCertainGroupsRadioBtn.click();
        }
        //return this;
    }

    public void visibleOnlyToMeRadioBtn(){
        if (!visibleOnlyToMeRadioBtn.isSelected()) {
            visibleOnlyToMeRadioBtn.click();
        }
        //return this;
    }

    public void setfilterByAdditionalField(String [][] filterAdditionalFields){
        Integer row = 1;
        for(String [] filter: filterAdditionalFields) {
            setFieldComboBox(filter[0],row);
            setOperatorComboBox(filter[1],row);
            setValueTxt(filter[2],row);
            row = row + 1;
        }
        //return this;
    }

    public void setFieldComboBox(String field, Integer position) {
        String positionString = Integer.toString(position);
        String id = "fcol" + positionString;
        Select fieldBox =
                new Select(driver.findElement(By.id(id)));

        fieldBox.selectByVisibleText(field);
    }

    public void setOperatorComboBox(String operator, Integer position) {
        String positionString = Integer.toString(position);
        String id = "fop" + positionString;
        Select operatorBox =
                new Select(driver.findElement(By.id(id)));

        operatorBox.selectByVisibleText(operator);
    }

    public void setValueTxt(String value, Integer position) {
        String positionString = Integer.toString(position);
        String id = "fval" + positionString;
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void selectFieldToDisplay(String [] availFields) {

        Select selectBox =
                new Select(driver.findElement(By.id("colselector_select_0")));

        for(String field : availFields) {
            selectBox.selectByVisibleText(field);
        }

        rightArrow.click();
        //return this;
    }

    public ViewPage createView() {
        if(!viewName.isEmpty() && !viewUniqueName.isEmpty()) {
            setViewNameTxt(viewName);
            setViewUniqueNameTxt(viewUniqueName);
        }
        if (filterAdditionalFields != null) {

            setfilterByAdditionalField(filterAdditionalFields);
        }
        if (availableFields != null) {
            selectFieldToDisplay(availableFields);
        }

        if (visibleToMe == true) {
            visibleOnlyToMeRadioBtn();
        }

        if (visibleGroupUsers == true) {
            visibleCertainGroupsRadioBtn();
        }

        if (visibleAllUsers == true) {
            visibleAllUsersRadioBtn();
        }

        if (filterByOwnerMyView == true) {
            filterByOwnerMyViewRadioBtn();
        }

        if (filterByOwnerAllViews == true) {
            filterByOwnerAllViewsRadioBtn();
        }

        return clickSaveBtn();
    }

    public ViewPage clickSaveBtn() {
        saveBtn.click();
        return new ViewPage(driver);
    }



}
