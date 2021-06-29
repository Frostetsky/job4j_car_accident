package car_accident.repository;

import car_accident.entity.Accident;
import car_accident.entity.AccidentType;
import car_accident.entity.Rule;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccidentMem {

    private final Map<Integer, AccidentType> accidentTypes = new LinkedHashMap<>() {{
        put(1, new AccidentType(1, "Две машины"));
        put(2, new AccidentType(2, "Машина и пешеход"));
        put(3, new AccidentType(3, "Машина и велосипедист"));
    }};

    private final Map<Integer, Set<Rule>> rulesForAccidents = new LinkedHashMap<>() {{
        put(1, Set.of(new Rule("1.3"), new Rule("2.4")));
        put(2, Set.of(new Rule("3.3")));
        put(3, Set.of(new Rule("3.4"), new Rule("1.0"), new Rule("2.6")));
    }};

    private final Map<Long, Accident> accidents = new HashMap<>() {{
        put(1L, new Accident(1L,"Административное нарушение", "Столкновение", "Кутякова 65",
                accidentTypes.get(1), rulesForAccidents.get(1)));
        put(2L, new Accident(2L,"Уголовное нарушение", "Сбил пешехода", "Московская 29/4",
                accidentTypes.get(2), rulesForAccidents.get(3)));
        put(3L, new Accident(3L,"Административное нарушение", "Езда по встречной полосе", "Полоумская 25",
                accidentTypes.get(3), rulesForAccidents.get(2)));
    }};

    private final Map<Integer, Rule> mainRules = new LinkedHashMap<>() {{
        put(1, new Rule("1.1"));
        put(2, new Rule("1.2"));
        put(3, new Rule("1.3"));
        put(4, new Rule("1.4"));
        put(5, new Rule("1.5"));
        put(6, new Rule("1.6"));
        put(7, new Rule("1.7"));
    }};

    private final AtomicLong generatedKey = new AtomicLong(accidents.size());

    public Collection<Accident> findAllAccident() {
        return accidents.values();
    }

    public Collection<AccidentType> findAllAccidentType() { return accidentTypes.values(); }

    public Collection<Rule> findAllRulesType() { return mainRules.values(); }

    public void saveOrUpdate(Accident accident) {
        if (accident.getId() != 0) {
            accidents.put(accident.getId(), accident);
        } else {
            long key = generatedKey.incrementAndGet();
            accident.setId(key);
            accidents.putIfAbsent(key, accident);
        }
    }

    public Optional<Accident> findByID(Long id) {
        return Optional.of(accidents.get(id));
    }
}
