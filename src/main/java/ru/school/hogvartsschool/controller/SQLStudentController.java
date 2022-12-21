package ru.school.hogvartsschool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.service.SQLStudentService;

import java.util.Collection;

@RestController
@RequestMapping("/SQL")
public class SQLStudentController {

    private final SQLStudentService sqlStudentService;

    public SQLStudentController(SQLStudentService sqlStudentService) {
        this.sqlStudentService = sqlStudentService;
    }

    @GetMapping("/number_of_students")
    public Integer numberOfStudents() {
        return sqlStudentService.numberOfStudents();
    }

    @GetMapping("/average_age_of_students")
    public Integer averageAgeOfStudents() {
        return sqlStudentService.averageAgeOfStudents();
    }

    @GetMapping("/the_last_five_students")
    public Collection<Student> theLastFiveStudents() {
        return sqlStudentService.getTheLastFive();
    }

}
