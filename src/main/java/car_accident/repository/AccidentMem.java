package car_accident.repository;

import car_accident.entity.Accident;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccidentMem {
    private Map<Long, Accident> accidents = new HashMap<>() {{
            put(1L, new Accident(1L,"6.1 АК", "Столкновение", "Кутякова 65"));
            put(2L, new Accident(2L,"7.8 АК", "Превышение скорости", "Московская 29/4"));
            put(3L, new Accident(3L,"12.1 АК", "Езда по встречной полосе", "Полоумская 25"));
            }};

    public Collection<Accident> findAllAccident() {
        return accidents.values();
    }

    public void save(Accident accident) {
        long generatedKey = accidents.size() + 1;
        accident.setId(generatedKey);
        accidents.putIfAbsent(generatedKey, accident);
    }
}
