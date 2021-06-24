package car_accident.service;

import car_accident.entity.Accident;
import car_accident.repository.AccidentMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccidentService {

    @Autowired
    private AccidentMem accidentMem;

    public Map<Long, Accident> findAllAccident() {
        return accidentMem.findAllAccident();
    }
}
