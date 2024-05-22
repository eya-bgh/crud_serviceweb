package com.example.demo.entities;


import jakarta.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer grade;
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false) // Nom de la colonne dans la table Grade faisant référence à Student
    private Student student;
    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
