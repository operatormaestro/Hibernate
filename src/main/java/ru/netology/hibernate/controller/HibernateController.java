package ru.netology.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Secured("ROLE_READ")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return hibernateRepository.findByCityOfLivingIgnoreCase(city);
    }

    @GetMapping("/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> findByAgeLessThanOrderByAge(@RequestParam int age) {
        return hibernateRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-surname")
    @PreAuthorize(value = "hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Person> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateRepository.findByNameAndSurname(name, surname);
    }

    @GetMapping("/by-phone-number")
    @PostAuthorize("authentication.principal.username == 'admin'")
    public Optional<Person> findByPhoneNumber(@RequestParam String phoneNumber) {
        return hibernateRepository.findByPhoneNumber(phoneNumber);
    }
}
