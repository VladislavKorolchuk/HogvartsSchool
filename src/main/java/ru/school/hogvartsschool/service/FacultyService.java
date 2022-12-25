package ru.school.hogvartsschool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school.hogvartsschool.model.Faculty;
import ru.school.hogvartsschool.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        LOGGER.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        LOGGER.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        LOGGER.info("Was invoked method for update student");
        return facultyRepository.save(faculty);
    }

    public Faculty searchFaculty(Long id) {
        LOGGER.info("Was invoked method for search faculty");
        return facultyRepository.findById(id).get();
    }

    public Collection<Faculty> getAllFacultys() {
        LOGGER.info("Was invoked method for get all facultys");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultyByColor(String color) {
        LOGGER.info("Was invoked method for get color for faculty");
        return this.facultyRepository.findByColor(color);
    }

    public Collection<Faculty> getFacultyByName(String name) {
        LOGGER.info("Was invoked method for get faculty by name");
        return this.facultyRepository.findByName(name);
    }

}
