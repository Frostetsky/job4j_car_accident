package car_accident.service;

import car_accident.entity.Accident;
import car_accident.repository.AccidentMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AccidentService {

    @Autowired
    private AccidentMem accidentMem;

    public Collection<Accident> findAllAccident() {
        return accidentMem.findAllAccident();
    }

    public void saveAccident(Accident accident) { accidentMem.saveOrUpdate(accident); }

    public Optional<Accident> findByID(Long id) { return accidentMem.findByID(id); }
}
