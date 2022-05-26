package model.enums;

import org.openqa.selenium.By;

import java.util.ArrayList;

public enum StandardMachineTypes {


    STANDARD_1(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-1']")),
    STANDARD_2(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-2']")),
    STANDARD_4(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-4']")),
    STANDARD_8(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")),
    STANDARD_16(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-16']")),
    STANDARD_32(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-32']"));

    private By locator;

    StandardMachineTypes(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    private static ArrayList<StandardMachineTypes> optionsOfMachineTypes = new ArrayList<StandardMachineTypes>(){{
        add(STANDARD_1);
        add(STANDARD_2);
        add(STANDARD_4);
        add(STANDARD_8);
        add(STANDARD_16);
        add(STANDARD_32);
    }};

    public static StandardMachineTypes findByStringName(String name){
        for(StandardMachineTypes option : optionsOfMachineTypes){
            if (option.toString().equals(name.toUpperCase())){
                return option;
            }
        }
        return STANDARD_1;
    }
}
