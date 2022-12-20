package ru.school.hogvartsschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.school.hogvartsschool.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAgeIsBetween(int min, int max);

    Collection<Student> findByAge(int age);

    Collection<Student> findByFaculty_Id(long id);

    Student getById(Long id);

    @Query(value = "Select Count (*) as countStudent from Student", nativeQuery = true)
    Integer getNumberStudent();

    @Query(value = "Select Sum(age)/Count(*) as age from Student", nativeQuery = true)
    Integer getMiddleAge();

    @Query(value = "Select * from student order by id desc limit (5)", nativeQuery = true)
    Collection<Student> getTheLastFive();

}
