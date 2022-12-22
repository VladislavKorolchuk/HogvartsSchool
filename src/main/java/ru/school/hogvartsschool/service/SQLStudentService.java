package ru.school.hogvartsschool.service;

import org.springframework.stereotype.Service;
import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.repositories.StudentRepository;

import java.util.Collection;

@Service
public class SQLStudentService {

    private  StudentRepository studentRepository;
    public SQLStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Integer numberOfStudents() {
        return studentRepository.getNumberStudent();
    }

    public Integer averageAgeOfStudents() {
        return studentRepository.getMiddleAge();
    }

    public Collection<Student> getTheLastFive() {
        return studentRepository.getTheLastFive();
    }

}
