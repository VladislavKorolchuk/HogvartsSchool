package ru.school.hogvartsschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.school.hogvartsschool.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Collection<Faculty> findByColor(String color);
    Collection<Faculty> findByName (String name);

}
