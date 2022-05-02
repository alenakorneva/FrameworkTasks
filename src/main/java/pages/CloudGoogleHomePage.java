package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import utils.StringUtils;


public class CloudGoogleHomePage extends AbstractPage {

    public static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy (xpath = "//button[@aria-label='Open search']")
    private WebElement openSearchFieldButton;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchField;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public CloudGoogleHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CloudGoogleHomePage openSearchField(){
        executeScriptToClick(openSearchFieldButton);
        return this;
    }

    public CloudGoogleHomePage writeInSearchField(){
        waitUntilWebElementIsClickable(searchField);
        searchField.sendKeys(StringUtils.TEXT_TO_ENTER_IN_SEARCH_FIELD);
        return this;
    }

    public SearchResultsForGoogleCloudPlatformPricingCalculator searchForAllResults(){
        searchField.sendKeys(Keys.ENTER);
        logger.info("Field is filled with 'Google Pricing Calculator' response");
        return new SearchResultsForGoogleCloudPlatformPricingCalculator(driver);
    }
}
