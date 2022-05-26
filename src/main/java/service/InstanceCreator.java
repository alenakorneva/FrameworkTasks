package service;

import model.WrittenValues;
import model.enums.DataCentreLocation;
import model.enums.GPUNumber;
import model.enums.GPUTypes;
import model.enums.LocalSSD;
import model.enums.MachineClasses;
import model.enums.StandardMachineTypes;

public class InstanceCreator {

    public static final String NUMBER_OF_INSTANCES = "numberOfInstances";
    public static final String MACHINE_CLASS = "machineClass";
    public static final String STANDARD_MACHINE_TYPE = "standardMachineType";
    public static final String GPU_TYPE = "gpuType";
    public static final String GPU_NUMBER = "gpuNumber";
    public static final String LOCAL_SSD = "localSSD";
    private static final String DATA_CENTRE_LOCATION = "dataCentreLocation";

    public static WrittenValues withCredentialsFromProperty() {
        return new WrittenValues(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                MachineClasses.findByStringName(TestDataReader.getTestData(MACHINE_CLASS)),
                StandardMachineTypes.findByStringName(TestDataReader.getTestData(STANDARD_MACHINE_TYPE)),
                GPUTypes.findByStringName(TestDataReader.getTestData(GPU_TYPE)),
                GPUNumber.findByStringName(TestDataReader.getTestData(GPU_NUMBER)),
                LocalSSD.findByStringName(TestDataReader.getTestData(LOCAL_SSD)),
                DataCentreLocation.findByStringName(TestDataReader.getTestData(DATA_CENTRE_LOCATION)));
    }

}
