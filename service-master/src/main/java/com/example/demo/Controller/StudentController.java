package com.example.demo.Controller;

import com.example.demo.Services.StudentService;
import com.example.demo.entities.Grade;
import com.example.demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);
        return studentOptional.orElse(null); // Retourne null si l'étudiant n'est pas présent
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        if (student.getGrades() != null) {
            for (Grade grade : student.getGrades()) {
                grade.setStudent(student);
            }
        }
        return studentService.createOrUpdateStudent(student);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> studentOptional = studentService.getStudentById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setEmail(studentDetails.getEmail());
            return studentService.createOrUpdateStudent(student);
        } else {
            // Gérer l'absence de l'étudiant avec l'ID spécifié, par exemple, en renvoyant une réponse 404
            // ou en lançant une exception appropriée.
            // Ici, nous retournons null, ce qui peut être amélioré selon les besoins de votre application.
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
