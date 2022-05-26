package model.enums;

import org.openqa.selenium.By;

import java.util.ArrayList;

public enum MachineClasses {
    REGULAR(By.xpath("//md-option[@value='regular']")),
    PREEMPTIBLE(By.xpath("//md-option[@value='preemptible']"));

    private By locator;

    MachineClasses(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    private static ArrayList<MachineClasses> optionsOfMachineClasses = new ArrayList<MachineClasses>(){{
        add(REGULAR);
        add(PREEMPTIBLE);
    }};

    public static MachineClasses findByStringName(String name){
        for(MachineClasses option : optionsOfMachineClasses){
            if (option.toString().equals(name.toUpperCase())){
                return option;
            }
        }
        return REGULAR;
    }
}
