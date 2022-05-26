package model.enums;

import org.openqa.selenium.By;

import java.util.ArrayList;

public enum GPUNumber {

    ZERO(By.xpath("//md-option[@id='select_option_457']")),
    ONE(By.xpath("//md-option[@id='select_option_458']")),
    TWO(By.xpath("//md-option[@id='select_option_459']")),
    FOUR(By.xpath("//md-option[@id='select_option_460']")),
    EIGHT(By.xpath("//md-option[@id='select_option_461']"));

    private By locator;

    GPUNumber(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    private static ArrayList<GPUNumber> optionsOfGPUNumber = new ArrayList<GPUNumber>(){{
        add(ZERO);
        add(ONE);
        add(TWO);
        add(FOUR);
        add(EIGHT);
    }};

    public static GPUNumber findByStringName(String name){
        for(GPUNumber option : optionsOfGPUNumber){
            if (option.toString().equals(name.toUpperCase())){
                return option;
            }
        }
        return ZERO;
    }
}
