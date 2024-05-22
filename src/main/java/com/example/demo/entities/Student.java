package com.example.demo.entities;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int totalHoursScheduled=42;
    private int absenceHours;
    public List<Grade> getGrades() {
        return grades;
    }
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades; // Liste des notes des étudiants





    // Getters and setters

    public int getTotalAbsences() {
        return absenceHours;
    }

    public void setTotalAbsences(int x) {
        this.absenceHours = x;
    }

    public int getTotalHoursScheduled() {
        return totalHoursScheduled;
    }

    public void setTotalHoursScheduled(int totalHoursScheduled) {
        this.totalHoursScheduled = totalHoursScheduled;
    }
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
