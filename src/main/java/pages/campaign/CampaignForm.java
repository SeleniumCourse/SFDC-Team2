package pages.campaign;

import pages.basepages.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    private WebElement numSetTxt;

    @FindBy(id = "cpn4")
    @CacheLookup
    private WebElement descriptionTxtArea;

    public CampaignForm setCpnName(String cpnName) {
        super.webDriverTools.clearAndSendKeys(cpnNameTxt, cpnName);
        return this;
    }

    public CampaignForm setActive(boolean activate) {
        super.webDriverTools.checkOrClearCheckbox(activeChkbox, activate);
        return this;
    }

    public CampaignForm selectType(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(typeCmbbox, option);
        return this;
    }

    public CampaignForm selectStatus(String option) {
        super.webDriverTools.selectOptionInComboBoxByVisibleText(statusCmbbox, option);
        return this;
    }

    public CampaignForm setStartDate(String startDate) {
        super.webDriverTools.clearAndSendKeys(startDateTxt, startDate);
        return this;
    }

    public CampaignForm setEndDate(String endDate) {
        super.webDriverTools.clearAndSendKeys(endDateTxt, endDate);
        return this;
    }

    public CampaignForm setExpectedRevenue(String expectedRevenue) {
        super.webDriverTools.clearAndSendKeys(expectedRevenueTxt, expectedRevenue);
        return this;
    }

    public CampaignForm setBudgetedCost(String budgetedCost) {
        super.webDriverTools.clearAndSendKeys(budgetedCostTxt, budgetedCost);
        return this;
    }

    public CampaignForm setActualCost(String actualCost) {
        super.webDriverTools.clearAndSendKeys(actualCostTxt, actualCost);
        return this;
    }

    public CampaignForm setExpectedResponse(String expectedResponse) {
        super.webDriverTools.clearAndSendKeys(expectedResponseTxt, expectedResponse);
        return this;
    }

    public CampaignForm setNumSet(String numSet) {
        super.webDriverTools.clearAndSendKeys(numSetTxt, numSet);
        return this;
    }

    public CampaignForm setDescription(String description) {
        super.webDriverTools.clearAndSendKeys(descriptionTxtArea, description);
        return this;
    }

    @Override
    public CampaignDetails clickSaveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return new CampaignDetails();
    }
}
