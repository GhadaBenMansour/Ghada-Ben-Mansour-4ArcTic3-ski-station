package tn.esprit.ghadabenmansour_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ghadabenmansour_4arctic3.entities.Registration;
import tn.esprit.ghadabenmansour_4arctic3.services.RegistrationServices;

import java.util.List;

@RestController
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    @Qualifier("registrationServices")
    private RegistrationServices registrationServices;
    @PostMapping("add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationServices.addRegistration(registration);
    }

    @PutMapping("update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationServices.updateRegistration(registration);
    }

    @GetMapping("retrieve/{numRegistration}")
    public ResponseEntity<Registration> retrieveRegistration(@PathVariable Long numRegistration) {
        Registration registration = registrationServices.retrieveRegistration(numRegistration);
        if (registration == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registration);
    }

    @GetMapping("retrieveAll")
    public List<Registration> retrieveAllRegistrations() {
        return registrationServices.retrieveAllRegistrations();
    }

    @DeleteMapping("remove/{numRegistration}")
    public void removeRegistration(@PathVariable Long numRegistration) {
        registrationServices.removeRegistration(numRegistration);
    }
    @PostMapping("addRegistrationAndAssignToSkier/{numSkieur}")
    public Registration addRegistrationAndAssignToSkier(@RequestBody Registration registration,
                                                                        @PathVariable Long numSkieur) {
        return registrationServices.addRegistrationAndAssignToSkier(registration, numSkieur);
    }
    @PutMapping("assignRegistrationToCourse/{numRegistration}/{numCourse}")
    public Registration assignRegistrationToCourse(@PathVariable Long numCourse, @PathVariable Long numRegistration) {
        return registrationServices.assignRegistrationToCourse(numCourse, numRegistration);
    }
    @PostMapping("addRegistrationAndAssignToSkierAndCourse/{numSkier}/{numCourse}")
    public Registration addRegistrationAndAssignToSkierAndCourse(@RequestBody Registration registration,
                                                                 @PathVariable Long numSkier,
                                                                 @PathVariable Long numCourse) {
        return registrationServices.addRegistrationAndAssignToSkierAndCourse(registration, numSkier, numCourse);
    }

}
