package ru.school.hogvartsschool.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.repositories.AvatarRepository;
import ru.school.hogvartsschool.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    @Value("${avatars.dir.path}")
    private String avatarsDir;
    StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;

    public StudentService(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        return studentRepository.save(student);
    }

    public Student searchStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(Integer min, Integer max) {
        return studentRepository.findByAgeIsBetween(min, max);
    }

    public Collection<Student> getStudentsByFaculty(Long id) {
        return studentRepository.findByFaculty_Id(id);
    }

}