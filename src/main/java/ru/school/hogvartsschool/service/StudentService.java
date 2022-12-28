package ru.school.hogvartsschool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ru.school.hogvartsschool.exception.InvalidIndexException;
import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.repositories.AvatarRepository;
import ru.school.hogvartsschool.repositories.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    public Object flag = new Object();

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

    public Double averageAgeOfAllStudents() {
        LOGGER.info("Was invoked method for get average age of students");
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().collect(Collectors.averagingInt(Student::getAge));
    }

    public List<Student> allStudentsWithNamesStartingWithA() {
        LOGGER.info("Was invoked method for get students with name starting with A");
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().filter(s -> s.getName().substring(0, 1).equals("А")).collect(Collectors.toList());
    }

    public void threadOne() {
        LOGGER.info("Was invoked method for thread one");
        List<Student> studentList = studentRepository.findAll();
        if (studentList.size() < 6) {
            throw new InvalidIndexException("Not enough elements to output");
        }
        new Thread(() -> {
            System.out.println("Name third student - " + studentList.get(2).getName());
            System.out.println("Name fourth student - " + studentList.get(3).getName());
        }).start();
        new Thread(() -> {
            System.out.println("Name fifth student - " + studentList.get(4).getName());
            System.out.println("Name sixth student - " + studentList.get(5).getName());
        }).start();
        System.out.println("Name first student - " + studentList.get(0).getName());
        System.out.println("Name two student - " + studentList.get(1).getName());
    }

    public void threadTwo() {
        LOGGER.info("Was invoked method for thread two");
        List<Student> studentList = studentRepository.findAll();
        if (studentList.size() < 6) {
            throw new InvalidIndexException("Not enough elements to output");
        }
        System.out.println("Name first student - " + studentList.get(0).getName());
        System.out.println("Name two student - " + studentList.get(1).getName());
        new Thread(() -> {
            metodOne(studentList.get(2).getName(),studentList.get(3).getName());
        }).start();
        new Thread(() -> {
            metodTwo(studentList.get(3).getName(),studentList.get(4).getName());
        }).start();
    }

    private void metodOne(String name1, String name2) {
        synchronized (flag) {
            System.out.println("Name third student - " + name1);
            System.out.println("Name fourth student - " + name2);
        }
    }

    private void metodTwo(String name1, String name2) {
        synchronized (flag) {
            System.out.println("Name fifth student - " + name1);
            System.out.println("Name sixth student - " + name2);
        }
    }

}