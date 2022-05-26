package model.enums;

import org.openqa.selenium.By;

import java.util.ArrayList;

public enum LocalSSD {
    ZERO(By.xpath("//md-option[@id='select_option_433']")),
    ONE(By.xpath("//md-option[@id='select_option_434']")),
    TWO(By.xpath("//md-option[@id='select_option_435']")),
    THREE(By.xpath("//md-option[@id='select_option_436']")),
    FOUR(By.xpath("//md-option[@id='select_option_437']")),
    FIVE(By.xpath("//md-option[@id='select_option_438']"));

    private By locator;

    LocalSSD(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    private static ArrayList<LocalSSD> optionsOfLocalSSD = new ArrayList<LocalSSD>(){{
        add(ZERO);
        add(ONE);
        add(TWO);
        add(THREE);
        add(FOUR);
        add(FIVE);
    }};

    public static LocalSSD findByStringName(String name){
        for(LocalSSD option : optionsOfLocalSSD){
            if (option.toString().equals(name.toUpperCase())){
                return option;
            }
        }
        return ZERO;
    }
}
