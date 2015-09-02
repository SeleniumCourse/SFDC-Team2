package pages.campaign;

import framework.Helper;
import framework.DriverManager;
import framework.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriverException;
import pages.basepages.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class CampaignDetails extends DetailsBase{

    @FindBy(id = "cpn1_ileinner")
    @CacheLookup
    private WebElement cpnNameContainer;

    @FindBy(id = "cpn16_chkbox")
    @CacheLookup
    private WebElement activeContainer;

    @FindBy(id = "cpn2_ileinner")
    @CacheLookup
    private WebElement typeContainer;

    @FindBy(id = "cpn3_ileinner")
    @CacheLookup
    private WebElement statusContainer;

    @FindBy(id = "cpn5_ileinner")
    @CacheLookup
    private WebElement startDateContainer;

    @FindBy(id = "cpn6_ileinner")
    @CacheLookup
    private WebElement endDateContainer;

    @FindBy(id = "cpn8_ileinner")
    @CacheLookup
    private WebElement expectedRevenueContainer;

    @FindBy(id = "cpn9_ileinner")
    @CacheLookup
    private WebElement budgetedCostContainer;

    @FindBy(id = "cpn10_ileinner")
    @CacheLookup
    private WebElement actualCostContainer;

    @FindBy(id = "cpn11_ileinner")
    @CacheLookup
    private WebElement expectedResponseContainer;

    @FindBy(id = "cpn13_ileinner")
    @CacheLookup
    private WebElement numSetContainer;

    @FindBy(id = "cpn4_ileinner")
    @CacheLookup
    private WebElement descriptionContainer;

    public CampaignDetails(WebDriver driver){
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    @Override
    public CampaignForm clickEditBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        editBtn.click();
        return new CampaignForm(driver);
    }

    @Override
    public CampaignHome clickDeleteBtn(boolean confirmDeletion){
        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
        deleteBtn.click();
        Alert alert;

        try{
            alert = driver.switchTo().alert();

            if (confirmDeletion){
                alert.accept();
                LogManager.getInstance().addInformationLog(this.getClass().getName(),
                        "Accept button was clicked on Delete dialog");
            }else{
                alert.dismiss();
                LogManager.getInstance().addInformationLog(this.getClass().getName(),
                        "Cancel button was clicked on Delete dialog");
            }
        }
        catch(WebDriverException e){
             LogManager.getInstance().addErrorLog(this.getClass().getName(),
                     "Delete button could not be clicked", e.fillInStackTrace());
        }
        return new CampaignHome(driver);
    }

    public String getCampaignName(){
        String campaignName;

        wait.until(ExpectedConditions.visibilityOf(cpnNameContainer));
        campaignName = cpnNameContainer.getText();
        return campaignName.replace("[View Hierarchy]", "").trim();
    }

    public boolean getActiveStatus(){
        boolean status = false;

        wait.until(ExpectedConditions.visibilityOf(activeContainer));
        if ( activeContainer.getAttribute("title").equalsIgnoreCase("Checked") ){
            status = true;
        }
        return status;
    }

    public String getType(){
        wait.until(ExpectedConditions.visibilityOf(typeContainer));
        return typeContainer.getText();
    }

    public String getStatus(){
        wait.until(ExpectedConditions.visibilityOf(statusContainer));
        return statusContainer.getText();
    }

    public String getStartDate(){
        wait.until(ExpectedConditions.visibilityOf(startDateContainer));
        return startDateContainer.getText();
    }

    public String getEndDate(){
        wait.until(ExpectedConditions.visibilityOf(endDateContainer));
        return endDateContainer.getText();
    }

    public String getExpectedRevenue(){
        wait.until(ExpectedConditions.visibilityOf(expectedRevenueContainer));
        return Helper.removeSubstringToString("$", expectedRevenueContainer.getText());
    }

    public String getBudgetedCost(){
        wait.until(ExpectedConditions.visibilityOf(budgetedCostContainer));
        return Helper.removeSubstringToString("$", budgetedCostContainer.getText());
    }

    public String getActualCost(){
        wait.until(ExpectedConditions.visibilityOf(actualCostContainer));
        return Helper.removeSubstringToString("$", actualCostContainer.getText());
    }

    public String getExpectedResponse(){
        wait.until(ExpectedConditions.visibilityOf(expectedResponseContainer));
        return expectedResponseContainer.getText();
    }

    public String getNumSet(){
        wait.until(ExpectedConditions.visibilityOf(numSetContainer));
        return numSetContainer.getText();
    }

    public String getDescription(){
        wait.until(ExpectedConditions.visibilityOf(descriptionContainer));
        return descriptionContainer.getText();
    }

}
