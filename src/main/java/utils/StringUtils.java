package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StringUtils {

    public static final String TEXT_TO_ENTER_IN_SEARCH_FIELD = "Pricing Calculator";

    public static void openNewTab(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.open()");
    }
}
