package ru.school.hogvartsschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.school.hogvartsschool.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAgeIsBetween(int min, int max);
    Collection<Student> findByAge(int age);
    Collection<Student> findByFaculty_Id(long id);
    Student getById(Long id);

}
