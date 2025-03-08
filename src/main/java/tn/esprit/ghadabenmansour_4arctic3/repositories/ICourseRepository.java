package tn.esprit.ghadabenmansour_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ghadabenmansour_4arctic3.entities.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
