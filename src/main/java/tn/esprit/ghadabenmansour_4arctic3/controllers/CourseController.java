package tn.esprit.ghadabenmansour_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ghadabenmansour_4arctic3.entities.Course;
import tn.esprit.ghadabenmansour_4arctic3.services.CourseServices;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    @Qualifier("courseServices")
    private CourseServices courseServices;

    @PostMapping("add")
    public Course addCourse(@RequestBody Course course) {
        return courseServices.addCourse(course);
    }

    @PutMapping("update")
    public Course updateCourse(@RequestBody Course course) {
        return courseServices.updateCourse(course);
    }

    @GetMapping("retrieve/{id}")
    public Course retrieveCourse(@PathVariable long id) {
        return courseServices.retrieveCourse(id);
    }

    @GetMapping("retrieve/all")
    public List<Course> retrieveAllCourses() {
        return courseServices.retrieveAllCourses();
    }

    @DeleteMapping("remove/{id}")
    public void removeCourse(@PathVariable long id) {
        courseServices.removeCourse(id);
    }
}
