package org.example.sprinBootWebApp.Model.DAO;

import org.example.sprinBootWebApp.Model.City;
import org.example.sprinBootWebApp.Model.Person;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class CityDAO {
    private Session session;

    public List<City> findAll() {
        return session.createQuery("from City c").list();
    }

    public List<City> findAllWithDetail() {
        return null;
    }

    public Person findPersonById(Long id) {
        Query query = session.createQuery("from Person a where a.id = :id");
        query.setParameter("id", id);
        return (Person) query.getSingleResult();
    }

    public City findById(Long id) {
        return null;
    }

    public City save(City city) {
        return null;
    }

    public void delete(City city) {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

}
