package car_accident.repository;

import car_accident.entity.Accident;
import car_accident.entity.AccidentType;
import car_accident.entity.Rule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional
    public Accident saveOrUpdate(Accident accident) {
        Session session = sf.openSession();
        session.saveOrUpdate(accident);
        return accident;
    }

    @Transactional
    public List<Accident> findAllAccident() {
        Session session = sf.openSession();
        Query<Accident> query = session.createQuery("from Accident", Accident.class);
        return query.getResultList();
    }

    @Transactional
    public List<AccidentType> findAllAccidentType() {
        Session session = sf.openSession();
        Query<AccidentType> query = session.createQuery("from AccidentType", AccidentType.class);
        return query.getResultList();
    }

    @Transactional
    public Optional<Accident> findByID(long id) {
        Session session = sf.openSession();
        Accident accident = session.get(Accident.class, id);
        return Optional.of(accident);
    }

    @Transactional
    public List<Rule> findAllRulesType() {
        Session session = sf.openSession();
        Query<Rule> query = session.createQuery("from Rule", Rule.class);
        return query.getResultList();
    }
}
