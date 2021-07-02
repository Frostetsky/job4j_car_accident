package car_accident.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type")
public class AccidentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public AccidentType() {
    }

    public AccidentType(String name) {
        this.name = name;
    }

    public AccidentType(int idType, String name) {
        this.id = idType;
        this.name = name;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Accident accident;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidentType that = (AccidentType) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
