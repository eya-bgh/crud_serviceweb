package com.example.demo.Services;


import com.example.demo.entities.Grade;
import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentStatisticsService {
    @Autowired
    private StudentRepository studentRepository;

    public double calculateAbsenteeismRate() {
        List<Student> students = studentRepository.findAll();
        int totalAbsences = 0;
        int totalHoursScheduled = 0;

        for (Student student : students) {
            totalAbsences += student.getTotalAbsences();
            totalHoursScheduled += student.getTotalHoursScheduled();
        }

        if (totalHoursScheduled > 0) {
            return ((double) totalAbsences / totalHoursScheduled) * 100;
        } else {
            return 0;
        }
    }

    public double calculateSuccessRate() {
        List<Student> students = studentRepository.findAll();
        int totalStudents = students.size();
        int successfulStudents = 0;

        for (Student student : students) {
            if (isSuccessful(student)) {
                successfulStudents++;
            }
        }

        if (totalStudents > 0) {
            return ((double) successfulStudents / totalStudents) * 100;
        } else {
            return 0;
        }
    }

    private boolean isSuccessful(Student student) {
        // Suppose we consider a student successful if their average grade is greater than or equal to 60
        double averageGrade = calculateAverageGrade(student);
        return averageGrade >= 10;
    }

    private double calculateAverageGrade(Student student) {
        List<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }
        return (double) sum / grades.size();
    }

}
