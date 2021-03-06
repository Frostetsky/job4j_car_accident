package car_accident.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    private AccidentType accidentType;

    @ManyToMany
    @JoinTable(
            name = "rule",
            joinColumns = @JoinColumn(name = "rule_id"),
            inverseJoinColumns = @JoinColumn(name = "accident_id"))
    private Collection<Rule> rules = new LinkedHashSet<>();

    public Accident() {

    }

    public Accident(Collection<Rule> rules) {
        this.rules = rules;
    }

    public Accident(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Accident(long id, String name, String description, String address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Accident(long id, String name, String description, String address, AccidentType accidentType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.accidentType = accidentType;
    }

    public Accident(long id, String name, String description, String address, AccidentType accidentType, Collection<Rule> rules) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Collection<Rule> getRules() {
        return rules;
    }

    public void setRules(Collection<Rule> rules) {
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
