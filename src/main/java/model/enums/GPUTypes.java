package model.enums;

import org.openqa.selenium.By;

import java.util.ArrayList;

public enum GPUTypes {
    K_80(By.xpath("//md-option[@value='NVIDIA_TESLA_K80']")),
    P_100(By.xpath("//md-option[@value='NVIDIA_TESLA_p100']")),
    P_4(By.xpath("//md-option[@value='NVIDIA_TESLA_P4']")),
    V_100(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']")),
    T_4(By.xpath("//md-option[@value='NVIDIA_TESLA_T4']"));

    private By locator;

    GPUTypes(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    private static ArrayList<GPUTypes> optionsOfGPUTypes = new ArrayList<GPUTypes>(){{
        add(K_80);
        add(P_100);
        add(P_4);
        add(V_100);
        add(T_4);
    }};

    public static GPUTypes findByStringName(String name){
        for(GPUTypes option : optionsOfGPUTypes){
            if (option.toString().equals(name.toUpperCase())){
                return option;
            }
        }
        return K_80;
    }
}
