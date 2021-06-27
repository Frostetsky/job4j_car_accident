package car_accident.entity;

import java.util.Objects;

public class Accident {
    private Long id;

    private String name;

    private String description;

    private String address;

    private AccidentType accidentType;

    public Accident() {
    }

    public Accident(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Accident(Long id, String name, String description, String address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Accident(Long id, String name, String description, String address, AccidentType accidentType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.accidentType = accidentType;
    }

    public void setAccidentType(AccidentType accidentType) {
        this.accidentType = accidentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccidentType getAccidentType() {
        return accidentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return Objects.equals(id, accident.id)
                && Objects.equals(name, accident.name)
                && Objects.equals(description, accident.description)
                && Objects.equals(address, accident.address)
                && Objects.equals(accidentType, accident.accidentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, address, accidentType);
    }
}
