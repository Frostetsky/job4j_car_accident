package car_accident.entity;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Accident {
    private Long id;

    private String name;

    private String description;

    private String address;

    private AccidentType accidentType;

    private Set<Rule> rules = new LinkedHashSet<>();

    public Accident() {
        int id = 0;
        for (int i = 1; i <= 3; i ++) {
            for (int j = 0; j <= 9; j++) {
                rules.add(new Rule(id++,i + "." + j));
            }
        }
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

    public Accident(Long id, String name, String description, String address, AccidentType accidentType, Set<Rule> rules) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.accidentType = accidentType;
        this.rules = rules;
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

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
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
