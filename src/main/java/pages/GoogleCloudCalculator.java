package pages;

import model.WrittenValues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculator extends AbstractPage {

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    private WebElement popUpWindow;

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    private WebElement firstFrame;

    @FindBy(id = "myFrame")
    private WebElement secondFrame;

    @FindBy(xpath = "//*[@id='resultBlock']/md-card/md-toolbar/div/h2")
    private WebElement inputFieldForScrollingToDropDownListOfMachineClasses;

    @FindBy(xpath = "//*[@id=\"input_81\"]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[@id='select_value_label_74']/span[1]")
    private WebElement dropDownListOfMachineClasses;

    @FindBy(xpath = "//md-option[@id='select_option_97']")
    private WebElement preemptibleMachineClassOption;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[7]/div[1]/md-input-container/label")
    private WebElement textForScrollingToMachineType;

    @FindBy(xpath = "//*[@id=\"select_value_label_77\"]/span[1]/div")
    private WebElement dropDownListOfMachineTypes;

    @FindBy(xpath = "//*[@id=\"select_option_424\"]/div[1]")
    private WebElement optionOfDropDownListOfMachineTypes;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[11]/div[1]/md-input-container/md-checkbox/div[text()]")
    private WebElement textForScrollingToAddPUTick;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[11]/div[1]/md-input-container/md-checkbox/div[1]")
    private WebElement addGPUTick;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement dropDownListOfGPUTypes;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']/div")
    private WebElement requiredOptionOfGPUTypesList;

    @FindBy(xpath = "//label[text()='Number of GPUs']/following-sibling::md-select/md-select-value/span[1]")
    private WebElement dropDownListOfNumberOfGPUs;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option[@value='1']/div[@class='md-text ng-binding']")
    private WebElement requiredOptionOfGPUsNumberDropDownList;

    @FindBy(xpath = "//label[text()='Local SSD']/following-sibling::md-select/md-select-value/span[1]")
    private WebElement dropDownListOfLocalSSD;

    @FindBy(xpath = "//div[@id='select_container_420']/md-select-menu/md-content/md-option[@value='2']/div[@class='md-text ng-binding']")
    private WebElement requiredOptionOfLocalSSDDropDownList;

    @FindBy(xpath = "//label[text()='Datacenter location']/following-sibling::md-select/md-select-value/span[1]")
    private WebElement dropDownListOfDatacenterLocation;

    @FindBy(xpath = "//div[@id='select_container_115']/md-select-menu/md-content/md-optgroup/md-option[@value='europe-west3']/div[@class='md-text ng-binding']")
    private WebElement requiredOptionOfDatacenterLocationDropDownList;

    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[19]/button")
    private WebElement estimateButton;

    private final Logger logger = LogManager.getRootLogger();

    public GoogleCloudCalculator(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("if you need direct access: " +
                "avoid inheritance of AbstractPage " +
                "or remove openPage() method from AbstractPage class.");
    }

    public boolean setComputeEngineSection() {
        //COMPUTE ENGINE is set by default
        return true;
    }

    public void getRidOfPopUpWindow() {
        popUpWindow.click();
    }

    public GoogleCloudCalculator fillInNumberOfInstances(WrittenValues writtenValues) {
        getRidOfPopUpWindow();

        driver.switchTo().frame(firstFrame);
        driver.switchTo().frame(secondFrame);
        waitUntilWebElementIsClickable(numberOfInstances);
        numberOfInstances.sendKeys(writtenValues.getNumberOfInstances());
        logger.info("Number Of Instances field is filled with " + writtenValues.getNumberOfInstances());
        return this;
    }

    public GoogleCloudCalculator setOperatingSystem() {
        //required option is set by default
        return this;
    }

    public GoogleCloudCalculator setMachineClass() {
        //set preemptible class because regular class do not allow choosing some other options
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        scrollUntilWebElementIsVisible(inputFieldForScrollingToDropDownListOfMachineClasses);

        Actions actions = new Actions(driver);
        actions.moveToElement(dropDownListOfMachineClasses).click().build().perform();

        javascriptExecutor.executeScript("arguments[0].click();", preemptibleMachineClassOption);
        waitUntilWebElementIsClickable(preemptibleMachineClassOption);
        preemptibleMachineClassOption.click();

        logger.info("Machine Class is set");
        return this;
    }

    public GoogleCloudCalculator setMachineType() {
        scrollUntilWebElementIsVisible(textForScrollingToMachineType);

        executeScriptToClick(dropDownListOfMachineTypes);

        executeScriptToClick(optionOfDropDownListOfMachineTypes);
        //driver.switchTo().defaultContent();
        logger.info("Machine Type is set");
        return this;
    }

    public GoogleCloudCalculator tickAtAddGPUCheckBox() {
        //scrolling doesn't work
        scrollUntilWebElementIsVisible(textForScrollingToAddPUTick);
        executeScriptToClick(addGPUTick);
        logger.info("GPU checkbox is ticked");
        return this;
    }

    public GoogleCloudCalculator setGPUType() {
        scrollUntilWebElementIsVisible(textForScrollingToAddPUTick);
        executeScriptToClick(dropDownListOfMachineTypes);
        executeScriptToClick(requiredOptionOfGPUTypesList);
        logger.info("GPU Type is set");
        return this;
    }

    public GoogleCloudCalculator setNumberOfGPU() {
        scrollUntilWebElementIsVisible(dropDownListOfNumberOfGPUs);
        executeScriptToClick(dropDownListOfNumberOfGPUs);
        executeScriptToClick(requiredOptionOfGPUsNumberDropDownList);
        logger.info("Number of GPU is set");
        return this;
    }

    public GoogleCloudCalculator setLocalSSD() {
        scrollUntilWebElementIsVisible(dropDownListOfLocalSSD);
        executeScriptToClick(dropDownListOfLocalSSD);
        executeScriptToClick(requiredOptionOfLocalSSDDropDownList);
        logger.info("Local SSD is set");
        return this;
    }

    public GoogleCloudCalculator setDatacenterLocation() {
        executeScriptToClick(dropDownListOfDatacenterLocation);
        executeScriptToClick(requiredOptionOfDatacenterLocationDropDownList);
        logger.info("Datacenter location is set");
        return this;
    }

    public GoogleCloudCalculator setCommittedUsage() {
        //can't be selected
        return this;
    }

    public EstimationResultsPage clickToEstimateButton() {
        executeScriptToClick(estimateButton);
        logger.info("Estimate button is clicked");
        return new EstimationResultsPage(driver);
    }
}
