package car_accident.entity;

import java.util.Objects;

public class AccidentType {
    private int idType;

    private String name;

    public AccidentType() {
    }

    public AccidentType(String name) {
        this.name = name;
    }

    public AccidentType(int idType, String name) {
        this.idType = idType;
        this.name = name;
    }

    public int getId_type() {
        return idType;
    }

    public void setId_type(int idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidentType that = (AccidentType) o;
        return Objects.equals(idType, that.idType) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, name);
    }
}
