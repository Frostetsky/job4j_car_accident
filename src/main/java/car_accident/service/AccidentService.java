package car_accident.service;

import car_accident.entity.Accident;
import car_accident.entity.AccidentType;
import car_accident.entity.Rule;
import car_accident.repository.AccidentHibernate;
import car_accident.repository.AccidentMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AccidentService {

    @Autowired
    private AccidentMem accidentMem;

    @Autowired
    private AccidentHibernate accidentHibernate;

    public Collection<Accident> findAllAccident() {
        return accidentHibernate.findAllAccident();
    }

    public Collection<AccidentType> findAllAccidentTypes() { return accidentMem.findAllAccidentType(); }

    public Collection<Rule> findAllRulesType() { return accidentMem.findAllRulesType(); }

    public void saveAccident(Accident accident) { accidentHibernate.saveOrUpdate(accident); }

    public Optional<Accident> findByID(Long id) { return accidentHibernate.findByID(id); }
}
