package car_accident.repository;

import car_accident.entity.Accident;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class AccidentMem {
    private Map<Long, Accident> accidents = Map.of(
            1L, new Accident(1L,"6.1 АК", "Столкновение", "Кутякова 65"),
            2L, new Accident(2L,"7.8 АК", "Превышение скорости", "Московская 29/4"),
            3L, new Accident(3L,"12.1 АК", "Езда по встречной полосе", "Полоумская 25"));

    public Map<Long, Accident> findAllAccident() {
        return accidents;
    }
}
