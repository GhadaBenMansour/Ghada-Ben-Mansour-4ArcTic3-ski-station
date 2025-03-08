package tn.esprit.ghadabenmansour_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ghadabenmansour_4arctic3.entities.Instructor;
import tn.esprit.ghadabenmansour_4arctic3.services.InstructorServices;

import java.util.List;

@RestController
@RequestMapping("instructor")
public class InstructorController {

    @Autowired
    @Qualifier("instructorServices")
    private InstructorServices instructorServices;

    @PostMapping("add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorServices.addInstructor(instructor);
    }

    @PutMapping("update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorServices.updateInstructor(instructor);
    }

    @GetMapping("retrieve/{numInstructor}")
    public ResponseEntity<Instructor> retrieveInstructor(@PathVariable Long numInstructor) {
        Instructor instructor = instructorServices.retrieveInstructor(numInstructor);
        if (instructor == null) {
            return ResponseEntity.notFound().build(); // Si l'instructeur n'est pas trouvé
        }
        return ResponseEntity.ok(instructor);
    }

    @GetMapping("retrieveAll")
    public List<Instructor> retrieveAllInstructors() {
        return instructorServices.retrieveAllInstructors();
    }

    @DeleteMapping("remove/{numInstructor}")
    public void removeInstructor(@PathVariable Long numInstructor) {
        instructorServices.removeInstructor(numInstructor);
    }
}
