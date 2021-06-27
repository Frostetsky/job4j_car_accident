package car_accident.entity;

import java.util.Objects;

public class AccidentType {
    private Integer id_type;

    private String name;

    public AccidentType() {
    }

    public AccidentType(String name) {
        this.name = name;
    }

    public AccidentType(Integer id_type, String name) {
        this.id_type = id_type;
        this.name = name;
    }

    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
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
        return Objects.equals(id_type, that.id_type) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_type, name);
    }
}
