package ru.shershnoyv.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shershnoyv.MySpringBoot2Dbase.entity.Education;
import ru.shershnoyv.MySpringBoot2Dbase.entity.Student;
import ru.shershnoyv.MySpringBoot2Dbase.service.EducationService;
import ru.shershnoyv.MySpringBoot2Dbase.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private EducationService educationService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> allStudents() {
        List<Student> result = studentService.getAllStudents();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student saved = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/students")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        if (student.getId() != 0) {
            Student existing = studentService.getStudent(student.getId());
            if (existing == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }
        }
        Student saved = studentService.saveStudent(student);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        Student existing = studentService.getStudent(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/education")
    public ResponseEntity<List<Education>> allEducations() {
        List<Education> result = educationService.getAllEducation();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/education/{id}")
    public ResponseEntity<?> getEducation(@PathVariable int id) {
        Education education = educationService.getEducation(id);
        if (education == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.ok(education);
    }

    @PostMapping("/education")
    public ResponseEntity<Education> saveEducation(@RequestBody Education education) {
        Education saved = educationService.saveEducation(education);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/education")
    public ResponseEntity<?> updateEducation(@RequestBody Education education) {
        if (education.getId() != 0) {
            Education existing = educationService.getEducation(education.getId());
            if (existing == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }
        }
        Education saved = educationService.saveEducation(education);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/education/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable int id) {
        Education existing = educationService.getEducation(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        educationService.deleteEducation(id);
        return ResponseEntity.noContent().build();
    }
}
