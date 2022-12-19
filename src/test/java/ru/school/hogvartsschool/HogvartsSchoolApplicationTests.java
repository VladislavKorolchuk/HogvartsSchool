package ru.school.hogvartsschool;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.school.hogvartsschool.controller.StudentController;
import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.repositories.StudentRepository;
import ru.school.hogvartsschool.service.StudentService;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HogvartsSchoolApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void contextLoadTest() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void defaultMessageTest() throws Exception {
        Assertions.assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/students", String.class))
                .isNotNull();
    }

    @Test
    public void createStudent() throws Exception {
        studentService.createStudent(addStudent("Миша", 19));
        Assertions.assertThat(studentRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    public void deleteStudentTest() throws Exception {
        Student student = addStudent("Миша", 19);
        studentService.createStudent(student);
        Assertions.assertThat(studentRepository.findAll().size()).isEqualTo(1);

        studentService.deleteStudent(student.getId());
        Assertions.assertThat(studentRepository.findAll().size()).isEqualTo(0);
    }

    @Test
    public void getAllStudentsTest() throws Exception {
        studentService.createStudent(addStudent("Миша", 25));
        studentService.createStudent(addStudent("Миша", 19));
        studentService.createStudent(addStudent("Миша", 19));
        Assertions.assertThat(studentService.getAllStudents().size()).isEqualTo(3);
    }

    @Test
    public void findByAgeBetweenTest() throws Exception {
        studentService.createStudent(addStudent("Миша", 25));
        studentService.createStudent(addStudent("Миша", 19));
        studentService.createStudent(addStudent("Миша", 19));
        Assertions.assertThat(studentService.getAllStudents().size()).isEqualTo(3);
        Assertions.assertThat(studentService.findByAgeBetween(10, 20).size()).isEqualTo(2);
    }

    private Student addStudent(String name, int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }

}
