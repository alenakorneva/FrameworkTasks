package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsForGoogleCloudPlatformPricingCalculator extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    public SearchResultsForGoogleCloudPlatformPricingCalculator(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement linkToGoogleCloudPricingCalculator;

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("if you need direct access: " +
                "avoid inheritance of AbstractPage " +
                "or remove openPage() method from AbstractPage class.");
    }

    public GoogleCloudCalculator clickAtLinkToGoogleCloudPricingCalculator() {
        waitUntilWebElementIsClickable(linkToGoogleCloudPricingCalculator);
        linkToGoogleCloudPricingCalculator.click();
        logger.info("Google Pricing Calculator page is found");
        return new GoogleCloudCalculator(driver);
    }
}
