package tn.esprit.ghadabenmansour_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ghadabenmansour_4arctic3.entities.Instructor;

public interface IInstructorRepository extends JpaRepository<Instructor, Long> {
}
