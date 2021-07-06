package car_accident.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "rule")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Rule() {
    }

    public Rule(String name) {
        this.name = name;
    }

    public Rule(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @ManyToMany
    @JoinTable(
            name = "accident",
            joinColumns = @JoinColumn(name = "accident_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id"))
    private Collection<Accident> accident = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Accident> getAccident() {
        return accident;
    }

    public void setAccident(Collection<Accident> accident) {
        this.accident = accident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return Objects.equals(id, rule.id) && Objects.equals(name, rule.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name;
    }
}
