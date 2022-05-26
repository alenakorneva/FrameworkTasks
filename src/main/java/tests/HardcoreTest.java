package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HardcoreTest extends TestValueCreator {

    TestValueCreator testValueCreator = new TestValueCreator();


    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();
        testValueCreator.doActions();
    }

    @Test(description = "JIRA binding can be here")
    public void testEmailAndEstimationResultsPageCostsSimilarity() {
        Assert.assertTrue(totalCostOnEstimationResultPage.contains(totalCostInEmail));
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
