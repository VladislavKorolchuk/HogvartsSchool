package ru.school.hogvartsschool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.repositories.StudentRepository;

import java.util.Collection;

@Service
public class SQLStudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQLStudentService.class);
    private final StudentRepository studentRepository;

    public SQLStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Integer numberOfStudents() {
        LOGGER.info("Was invoked method for number students");
        return studentRepository.getNumberStudent();
    }

    public Integer averageAgeOfStudents() {
        LOGGER.info("Was invoked method for average age of students");
        return studentRepository.getMiddleAge();
    }

    public Collection<Student> getTheLastFive() {
        LOGGER.info("Was invoked method for get the last five students");
        return studentRepository.getTheLastFive();
    }

}
