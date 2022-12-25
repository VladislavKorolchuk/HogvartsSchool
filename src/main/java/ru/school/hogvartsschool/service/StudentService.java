package ru.school.hogvartsschool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.repositories.AvatarRepository;
import ru.school.hogvartsschool.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Value("${avatars.dir.path}")
    private String avatarsDir;
    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;
    public StudentService(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }

    public Student createStudent(Student student) {
        LOGGER.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        LOGGER.info("Was invoked method for delete student");
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        LOGGER.info("Was invoked method for update student");
        return studentRepository.save(student);
    }

    public Student searchStudent(Long id) {
        LOGGER.info("Was invoked method for search student");
        return studentRepository.findById(id).get();
    }

    public Collection<Student> getAllStudents() {
        LOGGER.info("Was invoked method for get all students");
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAge(int age) {
        LOGGER.info("Was invoked method for get student by age");
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(Integer min, Integer max) {
        LOGGER.info("Was invoked method for find student by between age ");
        return studentRepository.findByAgeIsBetween(min, max);
    }

    public Collection<Student> getStudentsByFaculty(Long id) {
        LOGGER.info("Was invoked method for get student by faculty");
        return studentRepository.findByFaculty_Id(id);
    }

}