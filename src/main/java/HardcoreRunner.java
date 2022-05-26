import model.WrittenValues;
import pages.CloudGoogleHomePage;
import pages.EstimationResultsPage;
import pages.GoogleCloudCalculator;
import pages.SearchResultsForGoogleCloudPlatformPricingCalculator;
import pages.YopMailPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import service.InstanceCreator;

import java.util.ArrayList;

public class HardcoreRunner {
    /*public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        CloudGoogleHomePage googleHomePage = new CloudGoogleHomePage(driver);
        SearchResultsForGoogleCloudPlatformPricingCalculator searchResultsForGoogleCloudPlatformPricingCalculator;
        GoogleCloudCalculator googleCloudCalculator;
        EstimationResultsPage estimationResultsPage;
        YopMailPage yopMailPage = new YopMailPage(driver);
        WrittenValues writtenValues = InstanceCreator.withCredentialsFromProperty();

        driver.manage().window().maximize();

        try {
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

            String totalCostOnEstimationResultPage = estimationResultsPage.getTextOfTotalEstimatedCost();

            estimationResultsPage.clickOnEmailEstimateButton();

            openNewTab(driver);

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

            String totalCostInEmail = yopMailPage.getSendTotalEstimationCost();

            System.out.println(totalCostOnEstimationResultPage);
            System.out.println(totalCostInEmail);

            System.out.println(totalCostOnEstimationResultPage.contains(totalCostInEmail));
        } finally {
            driver.quit();
        }
    }

    public static void openNewTab(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.open()");
    }*/
}
