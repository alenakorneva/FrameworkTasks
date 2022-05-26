package model.enums;

import org.openqa.selenium.By;

import java.util.ArrayList;

public enum DataCentreLocation {
    LONDON(By.xpath("//md-option[@id='select_option_220']")),
    FRANKFURT(By.xpath("//md-option[@id='select_option_220']"));

    private By locator;

    DataCentreLocation(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    private static ArrayList<DataCentreLocation> optionsOfDataCentreLocation = new ArrayList<DataCentreLocation>(){{
        add(LONDON);
        add(FRANKFURT);
    }};

    public static DataCentreLocation findByStringName(String name){
        for(DataCentreLocation option : optionsOfDataCentreLocation){
            if (option.toString().equals(name.toUpperCase())){
                return option;
            }
        }
        return FRANKFURT;
    }
}
