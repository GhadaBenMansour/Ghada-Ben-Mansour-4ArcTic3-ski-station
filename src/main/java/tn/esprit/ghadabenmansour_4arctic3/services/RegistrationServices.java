package tn.esprit.ghadabenmansour_4arctic3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ghadabenmansour_4arctic3.entities.*;
import tn.esprit.ghadabenmansour_4arctic3.repositories.ICourseRepository;
import tn.esprit.ghadabenmansour_4arctic3.repositories.IRegistrationRepository;
import tn.esprit.ghadabenmansour_4arctic3.repositories.ISkierRepository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class RegistrationServices implements IRegistrationServices {

    @Autowired
    private IRegistrationRepository registrationRepository;
    private ISkierRepository skierRepository;
    private ICourseRepository courseRepository;

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(Long numRegistration) {
        return registrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public List<Registration> retrieveAllRegistrations() {
        return (List<Registration>) registrationRepository.findAll();
    }

    @Override
    public void removeRegistration(Long numRegistration) {
        registrationRepository.deleteById(numRegistration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {
        Skier skier = skierRepository.findById(numSkieur).orElse(null);
        registration.setSkier(skier);
        return registrationRepository.save(registration);

    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = registrationRepository.findById(numRegistration).orElse(null);
        Course course = courseRepository.findById(numCourse).orElse(null);
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier).orElseThrow(() -> new RuntimeException("Skieur non trouvé"));
        Course course = courseRepository.findById(numCourse).orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN || course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT) {
            if (course.getRegistrations().size() >= 6) {
                throw new IllegalStateException("Le nombre de skieurs pour ce cours collectif ne peut pas dépasser 6.");
            }
        }

        if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN && skier.getAge() >= 12) {
            throw new IllegalStateException("Ce skieur est trop âgé pour un cours collectif enfants.");
        }

        registration.setSkier(skier);
        registration.setCourse(course);

        return registrationRepository.save(registration);
    }



}
