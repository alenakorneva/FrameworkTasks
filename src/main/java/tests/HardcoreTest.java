package tests;

import model.WrittenValues;
import pages.CloudGoogleHomePage;
import pages.EstimationResultsPage;
import pages.GoogleCloudCalculator;
import pages.SearchResultsForGoogleCloudPlatformPricingCalculator;
import pages.YopMailPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.InstanceCreator;
import utils.StringUtils;

import java.util.ArrayList;

public class HardcoreTest extends CommonConditions{
    //WebDriver driver = new ChromeDriver();
    CloudGoogleHomePage googleHomePage = new CloudGoogleHomePage(driver);
    SearchResultsForGoogleCloudPlatformPricingCalculator searchResultsForGoogleCloudPlatformPricingCalculator;
    GoogleCloudCalculator googleCloudCalculator;
    EstimationResultsPage estimationResultsPage;
    YopMailPage yopMailPage = new YopMailPage(driver);
    String totalCostOnEstimationResultPage;
    String totalCostInEmail;
    WrittenValues writtenValues = InstanceCreator.withCredentialsFromProperty();

    public void doActionsToGetTotalEstimationCost(){
        searchResultsForGoogleCloudPlatformPricingCalculator = googleHomePage.openPage()
                .openSearchField()
                .writeInSearchField()
                .searchForAllResults();

        googleCloudCalculator = searchResultsForGoogleCloudPlatformPricingCalculator.clickAtLinkToGoogleCloudPricingCalculator();

        estimationResultsPage = googleCloudCalculator.fillInNumberOfInstances(writtenValues)
                .setMachineClass()
                .setMachineType()
                .tickAtAddGPUCheckBox()
                .setGPUType()
                .setNumberOfGPU()
                .setLocalSSD()
                .setDatacenterLocation()
                .setCommittedUsage()
                .clickToEstimateButton();

        totalCostOnEstimationResultPage = estimationResultsPage.getTextOfTotalEstimatedCost();

        estimationResultsPage.clickOnEmailEstimateButton();

        StringUtils.openNewTab(driver);

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        yopMailPage.openPage();
        yopMailPage.clickToAcceptRecommendedCookiesButton()
                .clickToGenerateRandomEmailAddress()
                .saveRandomEmail();

        driver.switchTo().window(tabs.get(0));

        estimationResultsPage
                .insertRandomEmailAddress()
                .clickToSendEmailButton();
        estimationResultsPage.switchToYopMailPage();

        yopMailPage.clickToCheckEmailsButton()
                .refreshPage();

        totalCostInEmail = yopMailPage.getSendTotalEstimationCost();
    }

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();
        doActionsToGetTotalEstimationCost();
    }

    @Test(description = "JIRA binding can be here")
    public void testEmailAndEstimationResultsPageCostsSimilarity(){
        Assert.assertTrue(totalCostOnEstimationResultPage.contains(totalCostInEmail));
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
