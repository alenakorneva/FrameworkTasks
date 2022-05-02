package service;

import model.WrittenValues;

public class InstanceCreator {

    public static final String NUMBER_OF_INSTANCES = "numberOfInstances";

    public static WrittenValues withCredentialsFromProperty() {
        return new WrittenValues(TestDataReader.getTestData(NUMBER_OF_INSTANCES));
    }
}
