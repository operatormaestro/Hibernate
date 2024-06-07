package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.model.Person;

import java.util.List;

@Repository
@AllArgsConstructor
public class HibernateRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Person> getPersonsByCity(String city) {
        return entityManager.createNativeQuery("select * from netology.persons where city_of_living = :city", Person.class).setParameter("city", city).getResultList();
    }
}
