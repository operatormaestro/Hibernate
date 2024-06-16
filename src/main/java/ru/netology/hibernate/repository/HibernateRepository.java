package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface HibernateRepository extends JpaRepository<Person, Integer> {
    @Query("select p from Person p where lower(p.cityOfLiving)  = lower(:city)")
    List<Person>  findByCityOfLivingIgnoreCase(@Param("city") String city);

    @Query("select p from Person p where p.age < :age order by p.age")
    List<Person> findByAgeLessThanOrderByAge(@Param("age") int age);

    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}
