package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.repository.HibernateRepository;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class HibernateController {
    private HibernateRepository hibernateRepository;

    @GetMapping("/by-city")
    public List<Person> findByCityOfLivingIgnoreCase(@RequestParam String city) {
        return hibernateRepository.findByCityOfLivingIgnoreCase(city);
    }

    @GetMapping("/by-age")
    public List<Person> findByAgeLessThanOrderByAge(@RequestParam int age) {
        return hibernateRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<Person> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateRepository.findByNameAndSurname(name, surname);
    }

}
