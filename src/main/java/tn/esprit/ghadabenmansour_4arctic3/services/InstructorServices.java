package tn.esprit.ghadabenmansour_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ghadabenmansour_4arctic3.entities.Instructor;
import tn.esprit.ghadabenmansour_4arctic3.repositories.IInstructorRepository;

import java.util.List;

@Service
public class InstructorServices implements IInstructorServices {

    @Autowired
    private IInstructorRepository instructorRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null); // Retourne null si non trouvé
    }

    @Override
    public List<Instructor> retrieveAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll(); // Retourne tous les instructeurs
    }

    @Override
    public void removeInstructor(Long numInstructor) {
        instructorRepository.deleteById(numInstructor);
    }
}
