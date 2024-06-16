package ru.netology.hibernate.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
@IdClass(PersonalInfo.class)
public class Person {
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private int age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;
}

