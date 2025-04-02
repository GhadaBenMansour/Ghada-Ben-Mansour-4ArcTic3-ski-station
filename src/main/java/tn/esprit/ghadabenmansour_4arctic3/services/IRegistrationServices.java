package tn.esprit.ghadabenmansour_4arctic3.services;

import tn.esprit.ghadabenmansour_4arctic3.entities.Registration;

import java.util.List;

public interface IRegistrationServices {
    Registration addRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    Registration retrieveRegistration(Long numRegistration);
    List<Registration> retrieveAllRegistrations();
    void removeRegistration(Long numRegistration);
    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur);
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse);

}
