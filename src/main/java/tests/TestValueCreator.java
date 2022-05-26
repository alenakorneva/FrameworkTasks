package tests;

import model.WrittenValues;
import pages.CloudGoogleHomePage;
import pages.EstimationResultsPage;
import pages.GoogleCloudCalculator;
import pages.SearchResultsForGoogleCloudPlatformPricingCalculator;
import pages.YopMailPage;
import service.InstanceCreator;
import utils.StringUtils;

import java.util.ArrayList;

public class TestValueCreator extends CommonConditions {
    CloudGoogleHomePage googleHomePage = new CloudGoogleHomePage(driver);
    SearchResultsForGoogleCloudPlatformPricingCalculator searchResultsForGoogleCloudPlatformPricingCalculator;
    GoogleCloudCalculator googleCloudCalculator;
    EstimationResultsPage estimationResultsPage;
    YopMailPage yopMailPage = new YopMailPage(driver);
    String totalCostOnEstimationResultPage;
    String totalCostInEmail;
    WrittenValues writtenValues = InstanceCreator.withCredentialsFromProperty();

    public void getSearchResults() {
        searchResultsForGoogleCloudPlatformPricingCalculator = googleHomePage.openPage()
                .openSearchField()
                .writeInSearchField()
                .searchForAllResults();
    }

    public void getGoogleCloudCalculatorPage() {
        googleCloudCalculator = searchResultsForGoogleCloudPlatformPricingCalculator.clickAtLinkToGoogleCloudPricingCalculator();
    }

    public void getEstimationResultsPage() {
        estimationResultsPage = googleCloudCalculator.fillInNumberOfInstances(writtenValues)
                .setMachineClass(driver.findElements(writtenValues.getOptionOfMachineClass().getLocator()).get(0))
                .setMachineType(driver.findElements(writtenValues.getOptionOfMachineClass().getLocator()).get(0))
                .tickAtAddGPUCheckBox()
                .setGPUType(driver.findElements(writtenValues.getOptionOfGPUTypes().getLocator()).get(0))
                .setNumberOfGPU(driver.findElements(writtenValues.getOptionOfGPUNumber().getLocator()).get(0))
                .setLocalSSD(driver.findElements(writtenValues.getOptionOfLocalSSD().getLocator()).get(0))
                .setDatacenterLocation(driver.findElements(writtenValues.getOptionOfDataCentreLocations().getLocator()).get(0))
                .clickToEstimateButton();
    }

    public void saveTotalEstimatedCostTextValue() {
        totalCostOnEstimationResultPage = estimationResultsPage.getTextOfTotalEstimatedCost();
    }

    public void estimateEmail() {
        estimationResultsPage.clickOnEmailEstimateButton();
    }

    public void saveRandomEmail() {
        yopMailPage.clickToAcceptRecommendedCookiesButton()
                .clickToGenerateRandomEmailAddress()
                .saveRandomEmail();
    }

    public void sendEstimationResultOnRandomEmail() {
        estimationResultsPage.insertRandomEmailAddress()
                .clickToSendEmailButton();
    }

    public void getResultFromEmail() {
        estimationResultsPage.switchToYopMailPage();
        yopMailPage.clickToCheckEmailsButton()
                .refreshPage();
    }

    public void saveTotalEstimatedCostFromEmail() {
        totalCostInEmail = yopMailPage.getSendTotalEstimationCost();
    }

    public void doActions() {
        getSearchResults();
        getGoogleCloudCalculatorPage();
        getEstimationResultsPage();
        saveTotalEstimatedCostTextValue();
        estimateEmail();

        StringUtils.openNewTab(driver);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        yopMailPage.openPage();

        saveRandomEmail();

        driver.switchTo().window(tabs.get(0));

        sendEstimationResultOnRandomEmail();
        getResultFromEmail();
        saveTotalEstimatedCostFromEmail();
    }

    /*public void doActionsToGetTotalEstimationCost() {
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

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
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
    }*/
}
