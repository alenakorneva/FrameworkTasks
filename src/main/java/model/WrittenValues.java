package model;

import model.enums.DataCentreLocation;
import model.enums.GPUNumber;
import model.enums.GPUTypes;
import model.enums.LocalSSD;
import model.enums.MachineClasses;
import model.enums.StandardMachineTypes;

import java.util.Objects;

public class WrittenValues {

    private String numberOfInstances;
    private MachineClasses optionOfMachineClass;
    private StandardMachineTypes optionOfStandardMachineTypes;
    private GPUTypes optionOfGPUTypes;
    private GPUNumber optionOfGPUNumber;
    private LocalSSD optionOfLocalSSD;
    private DataCentreLocation optionOfDataCentreLocations;

    public WrittenValues(String numberOfInstances, MachineClasses optionOfMachineClass,
                         StandardMachineTypes optionOfStandardMachineTypes,
                         GPUTypes optionOfGPUTypes, GPUNumber optionOfGPUNumber,
                         LocalSSD optionOfLocalSSD, DataCentreLocation optionOfDataCentreLocations) {
        this.numberOfInstances = numberOfInstances;
        this.optionOfMachineClass = optionOfMachineClass;
        this.optionOfStandardMachineTypes = optionOfStandardMachineTypes;
        this.optionOfGPUTypes = optionOfGPUTypes;
        this.optionOfGPUNumber = optionOfGPUNumber;
        this.optionOfLocalSSD = optionOfLocalSSD;
        this.optionOfDataCentreLocations = optionOfDataCentreLocations;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public MachineClasses getOptionOfMachineClass() {
        return optionOfMachineClass;
    }

    public void setOptionOfMachineClass(MachineClasses optionOfMachineClass) {
        this.optionOfMachineClass = optionOfMachineClass;
    }

    public StandardMachineTypes getOptionOfStandardMachineTypes() {
        return optionOfStandardMachineTypes;
    }

    public void setOptionOfStandardMachineTypes(StandardMachineTypes optionOfStandardMachineTypes) {
        this.optionOfStandardMachineTypes = optionOfStandardMachineTypes;
    }

    public GPUTypes getOptionOfGPUTypes() {
        return optionOfGPUTypes;
    }

    public void setOptionOfGPUTypes(GPUTypes optionOfGPUTypes) {
        this.optionOfGPUTypes = optionOfGPUTypes;
    }

    public GPUNumber getOptionOfGPUNumber() {
        return optionOfGPUNumber;
    }

    public void setOptionOfGPUNumber(GPUNumber optionOfGPUNumber) {
        this.optionOfGPUNumber = optionOfGPUNumber;
    }

    public LocalSSD getOptionOfLocalSSD() {
        return optionOfLocalSSD;
    }

    public void setOptionOfLocalSSD(LocalSSD optionOfLocalSSD) {
        this.optionOfLocalSSD = optionOfLocalSSD;
    }

    public DataCentreLocation getOptionOfDataCentreLocations() {
        return optionOfDataCentreLocations;
    }

    public void setOptionOfDataCentreLocations(DataCentreLocation optionOfDataCentreLocations) {
        this.optionOfDataCentreLocations = optionOfDataCentreLocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrittenValues)) return false;
        WrittenValues that = (WrittenValues) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                optionOfMachineClass == that.optionOfMachineClass &&
                optionOfStandardMachineTypes == that.optionOfStandardMachineTypes &&
                optionOfGPUTypes == that.optionOfGPUTypes &&
                optionOfGPUNumber == that.optionOfGPUNumber &&
                optionOfLocalSSD == that.optionOfLocalSSD &&
                optionOfDataCentreLocations == that.optionOfDataCentreLocations;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, optionOfMachineClass,
                optionOfStandardMachineTypes, optionOfGPUTypes,
                optionOfGPUNumber, optionOfLocalSSD, optionOfDataCentreLocations);
    }

    @Override
    public String toString() {
        return "WrittenValues{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", optionOfMachineClass=" + optionOfMachineClass +
                ", optionOfStandardMachineTypes=" + optionOfStandardMachineTypes +
                ", optionOfGPUTypes=" + optionOfGPUTypes +
                ", optionOfGPUNumber=" + optionOfGPUNumber +
                ", optionOfLocalSSD=" + optionOfLocalSSD +
                ", optionOfDataCentreLocations=" + optionOfDataCentreLocations +
                '}';
    }
}
