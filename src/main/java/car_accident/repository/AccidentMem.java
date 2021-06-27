package car_accident.repository;

import car_accident.entity.Accident;
import car_accident.entity.AccidentType;
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

    private final Map<Long, Accident> accidents = new HashMap<>() {{
        put(1L, new Accident(1L,"6.1 АК", "Столкновение", "Кутякова 65",
                accidentTypes.get(1)));
        put(2L, new Accident(2L,"9.2 УК", "Сбил пешехода", "Московская 29/4",
                accidentTypes.get(2)));
        put(3L, new Accident(3L,"12.1 АК", "Езда по встречной полосе", "Полоумская 25",
                accidentTypes.get(3)));
    }};

    private final AtomicLong generatedKey = new AtomicLong(accidents.size());

    public Collection<Accident> findAllAccident() {
        return accidents.values();
    }

    public Collection<AccidentType> findAllAccidentType() { return accidentTypes.values(); }

    public void saveOrUpdate(Accident accident) {
        if (accident.getId() != null) {
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
