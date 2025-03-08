package tn.esprit.ghadabenmansour_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ghadabenmansour_4arctic3.entities.Course;
import tn.esprit.ghadabenmansour_4arctic3.repositories.ICourseRepository;

import java.util.List;

@Service
public class CourseServices implements ICourseServices {
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
    @Override
    public Course retrieveCourse(long id) {
        return courseRepository.findById(id).orElse(null);
    }
    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }
    @Override
    public void removeCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
