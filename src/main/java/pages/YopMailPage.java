package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopMailPage extends AbstractPage {
    protected static String emailAddress;
    public static final String YOP_MAIL_PAGE_URL = "https://yopmail.com/";

    @FindBy(xpath = "//b[text()='Случайный адрес электронной почты']")
    private WebElement buttonToGenerateRandomEmailAddress;

    @FindBy(xpath = "//div[@id='egen']")
    private WebElement formWithRandomEmail;

    @FindBy(xpath = "//span[text()='Скопировать в буфер обмена']")
    private WebElement buttonToSaveRandomEmailToClipboard;

    @FindBy(xpath = "//div[@id='egen']/following-sibling::div[@class='nw']/button[2]")
    private WebElement buttonToCheckEmails;

    @FindBy(xpath = "//button[@id='accept']")
    private WebElement buttonToAcceptRecommendedCookies;

    @FindBy(xpath = "//div[@id='nbmail']")
    private WebElement amountOfEmailsInPostBox;

    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refreshButton;

    @FindBy(xpath = "//iframe[@id='ifmail']")
    private WebElement frame;

    @FindBy(xpath = "//td[@colspan='3']/following-sibling::td/h3")
    //@FindBy(xpath = "//*[@id=\"mail\"]/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement totalEstimatedCostSendByEmail;

    private final Logger logger = LogManager.getRootLogger();

    public YopMailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        driver.get(YOP_MAIL_PAGE_URL);
        logger.info("Yop mail page is opened.");
        return this;
    }

    public YopMailPage clickToGenerateRandomEmailAddress() {
        waitUntilWebElementIsClickable(buttonToGenerateRandomEmailAddress);
        buttonToGenerateRandomEmailAddress.click();
        logger.info("Random email is generated.");
        return this;
    }

    public YopMailPage saveRandomEmail() {
        emailAddress = formWithRandomEmail.getText();
        buttonToSaveRandomEmailToClipboard.click();
        logger.info("Random email is saved to clipboard.");
        return this;
    }

    public YopMailPage clickToCheckEmailsButton() {
        buttonToCheckEmails.click();
        logger.info("Check emails button is clicked.");
        return this;
    }

    public YopMailPage clickToAcceptRecommendedCookiesButton() {
        buttonToAcceptRecommendedCookies.click();
        logger.info("Cookies are accepted.");
        return this;
    }

    public YopMailPage refreshPage() {
        refreshButton.click();
        logger.info("Page with mail is refreshed");
        return this;
    }

    public String getSendTotalEstimationCost() {
        driver.switchTo().frame(frame);
        scrollUntilWebElementIsVisible(totalEstimatedCostSendByEmail);
        return totalEstimatedCostSendByEmail.getText();
    }
}
