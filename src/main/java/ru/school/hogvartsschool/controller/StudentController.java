package ru.school.hogvartsschool.controller;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

import ru.school.hogvartsschool.model.Faculty;
import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }

    @DeleteMapping({"/{id}"})
    public void deleteStudent(@PathVariable("id") Long id) {
        this.studentService.deleteStudent(id);
    }

    @PutMapping({"/{id}"})
    public Student searchStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return this.studentService.updateStudent(id, student);
    }

    @GetMapping({"/{id}"})
    public Student searchStudent(@PathVariable("id") Long id) {
        return this.studentService.searchStudent(id);
    }

    @GetMapping
    public Collection<Student> getAllStudent() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/age/{age}")
    public Collection<Student> getStudentsByAge(@PathVariable("age") Integer age) {
        return this.studentService.getStudentsByAge(age);
    }

      @GetMapping("/between_age")
      public Collection<Student> getStunetByAgeBeetween(@RequestParam Integer min, @RequestParam Integer max) {
          return studentService.findByAgeBetween(min,max);
      }

    @GetMapping("/studentbyfaculty/{id}")
    @Operation (summary = "Получение факультета по заданному id студента")
    public Faculty getFaculty(@PathVariable("id") Long id) {
        return this.studentService.searchStudent(id).getFaculty();
    }

    @GetMapping("/studentsbyfaculty/{id}")
    @Operation (summary = "Получение всех студентов по заданному id факультету")
    public Collection<Student> getStudentsByFaculty(@PathVariable("id") Long id) {
        return this.studentService.getStudentsByFaculty(id);
    }

}
