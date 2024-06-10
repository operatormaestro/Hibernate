package ru.netology.hibernate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "persons")
public class Person {
    @EmbeddedId
    private PersonalInfo personalInfo;
    private String phoneNumber;
    private String cityOfLiving;
}

