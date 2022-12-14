package ru.school.hogvartsschool.controller;

import org.springframework.web.bind.annotation.*;

import ru.school.hogvartsschool.model.Faculty;
import ru.school.hogvartsschool.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return this.facultyService.createFaculty(faculty);
    }

    @DeleteMapping({"/{id}"})
    public void deleteFaculty(@PathVariable("id") Long id) {
        this.facultyService.deleteFaculty(id);
    }

    @PutMapping({"/{id}"})
    public Faculty searchFaculty(@PathVariable("id") Long id, @RequestBody Faculty faculty) {
        return this.facultyService.updateFaculty(id, faculty);
    }

    @GetMapping({"/{id}"})
    public Faculty searchFaculty(@PathVariable("id") Long id) {
        return this.facultyService.searchFaculty(id);
    }

    @GetMapping
    public Collection<Faculty> getAllFaculty(@RequestParam(required = false) String name, @RequestParam(required = false) String color) {
        if (name != null && !name.isBlank()) {
            return this.facultyService.getFacultyByName(name);
        }
        if (color != null && !color.isBlank()) {
            return this.facultyService.getFacultyByColor(color);
        }
        return this.facultyService.getAllFacultys();
    }

}
