package model;

import java.util.Objects;

public class WrittenValues {
    //если у меня нет пользователя и другой бизнес сущности
    //и почти все поля заполняю кликая на них, какую модель нужно делать?
    //
    private String numberOfInstances;

    public WrittenValues(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrittenValues)) return false;
        WrittenValues that = (WrittenValues) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances);
    }

    @Override
    public String toString() {
        return "WrittenValues{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                '}';
    }
}
