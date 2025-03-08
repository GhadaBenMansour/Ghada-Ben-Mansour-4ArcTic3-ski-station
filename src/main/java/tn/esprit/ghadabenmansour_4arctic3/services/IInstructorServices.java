package tn.esprit.ghadabenmansour_4arctic3.services;

import tn.esprit.ghadabenmansour_4arctic3.entities.Instructor;

import java.util.List;

public interface IInstructorServices {
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    Instructor retrieveInstructor(Long numInstructor);
    List<Instructor> retrieveAllInstructors();
    void removeInstructor(Long numInstructor);
}
