package ru.school.hogvartsschool.service;

import org.springframework.stereotype.Service;
import ru.school.hogvartsschool.model.Faculty;
import ru.school.hogvartsschool.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {

    private  FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty searchFaculty(Long id) {
        return facultyRepository.findById(id).get();
    }

    public Collection<Faculty> getAllFacultys() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultyByColor(String color) {
        return this.facultyRepository.findByColor(color);
    }

    public Collection<Faculty> getFacultyByName(String name) {
        return this.facultyRepository.findByName(name);
    }

}
