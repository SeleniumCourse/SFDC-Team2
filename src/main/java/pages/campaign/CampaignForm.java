package pages.campaign;

import framework.DriverManager;
import pages.basepages.FormBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class CampaignForm extends FormBase {
    @FindBy(id = "cpn1")
    @CacheLookup
    private WebElement cpnNameTxt;

    @FindBy(id = "cpn16")
    @CacheLookup
    private WebElement activeChkbox;

    @FindBy(id = "cpn2")
    @CacheLookup
    private WebElement typeCmbbox;

    @FindBy(id = "cpn3")
    @CacheLookup
    private WebElement statusCmbbox;

    @FindBy(id = "cpn5")
    @CacheLookup
    private WebElement startDateTxt;

    @FindBy(id = "cpn6")
    @CacheLookup
    private WebElement endDateTxt;

    @FindBy(id = "cpn8")
    @CacheLookup
    private WebElement expectedRevenueTxt;

    @FindBy(id = "cpn9")
    @CacheLookup
    private WebElement budgetedCostTxt;

    @FindBy(id = "cpn10")
    @CacheLookup
    private WebElement actualCostTxt;

    @FindBy(id = "cpn11")
    @CacheLookup
    private WebElement expectedResponseTxt;

    @FindBy(id = "cpn13")
    @CacheLookup
    private WebElement numSentTxt;

    @FindBy(id = "cpn4")
    @CacheLookup
    private WebElement descriptionTxtArea;

    public CampaignForm(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public CampaignForm setCpnName(String cpnName) {
        wait.until(ExpectedConditions.visibilityOf(cpnNameTxt));
        cpnNameTxt.clear();
        cpnNameTxt.sendKeys(cpnName);
        return this;
    }

    public CampaignForm setActive(boolean activate) {
        wait.until(ExpectedConditions.elementToBeClickable(activeChkbox));
        if ((activate && !activeChkbox.isSelected()) || (!activate && activeChkbox.isSelected())) {
            activeChkbox.click();
        }
        return this;
    }

    public CampaignForm selectType(String option) {
        wait.until(ExpectedConditions.visibilityOf(typeCmbbox));
        Select typePicklist = new Select(typeCmbbox);
        typePicklist.selectByValue(option);
        return this;
    }

    public CampaignForm selectStatus(String option) {
        wait.until(ExpectedConditions.visibilityOf(statusCmbbox));
        Select statusPicklist = new Select(statusCmbbox);
        statusPicklist.selectByValue(option);
        return this;
    }

    public CampaignForm setStartDate(String startDate) {
        wait.until(ExpectedConditions.visibilityOf(startDateTxt));
        startDateTxt.clear();
        startDateTxt.sendKeys(startDate);
        return this;
    }

    public CampaignForm setEndDate(String endDate) {
        wait.until(ExpectedConditions.visibilityOf(endDateTxt));
        endDateTxt.clear();
        endDateTxt.sendKeys(endDate);
        return this;
    }

    public CampaignForm setExpectedRevenue(String expectedRevenue) {
        wait.until(ExpectedConditions.visibilityOf(expectedRevenueTxt));
        expectedRevenueTxt.clear();
        expectedRevenueTxt.sendKeys(expectedRevenue);
        return this;
    }

    public CampaignForm setBudgetedCost(String budgetedCost) {
        wait.until(ExpectedConditions.visibilityOf(budgetedCostTxt));
        budgetedCostTxt.clear();
        budgetedCostTxt.sendKeys(budgetedCost);
        return this;
    }

    public CampaignForm setActualCost(String actualCost) {
        wait.until(ExpectedConditions.visibilityOf(actualCostTxt));
        actualCostTxt.clear();
        actualCostTxt.sendKeys(actualCost);
        return this;
    }

    public CampaignForm setExpectedResponse(String expectedResponse) {
        wait.until(ExpectedConditions.visibilityOf(expectedResponseTxt));
        expectedResponseTxt.clear();
        expectedResponseTxt.sendKeys(expectedResponse);
        return this;
    }

    public CampaignForm setNumSet(String numSet) {
        wait.until(ExpectedConditions.visibilityOf(numSentTxt));
        numSentTxt.clear();
        numSentTxt.sendKeys(numSet);
        return this;
    }

    public CampaignForm setDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionTxtArea));
        descriptionTxtArea.clear();
        descriptionTxtArea.sendKeys(description);
        return this;
    }

    @Override
    public CampaignDetails clickSaveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return new CampaignDetails(driver);
    }

    public CampaignForm checkActive() {
        return this;
    }
}
