package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.repository.HibernateRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class HibernateController {
    private final HibernateRepository hibernateRepository;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return hibernateRepository.getPersonsByCity(city);
    }

}
