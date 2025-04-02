package tn.esprit.ghadabenmansour_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ghadabenmansour_4arctic3.entities.Skier;
import tn.esprit.ghadabenmansour_4arctic3.entities.TypeSubscription;
import tn.esprit.ghadabenmansour_4arctic3.services.SkierServices;

import java.util.List;

@RestController
@RequestMapping("skier")
public class SkierController {

    @Autowired
    private SkierServices skierServices;

    @PostMapping("add")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierServices.addSkier(skier);
    }

    @PutMapping("update")
    public Skier updateSkier(@RequestBody Skier skier) {
        return skierServices.updateSkier(skier);
    }

    @GetMapping("retrieve/{numSkier}")
    public ResponseEntity<Skier> retrieveSkier(@PathVariable long numSkier) {
        Skier skier = skierServices.retrieveSkier(numSkier);
        if (skier == null) {
            return ResponseEntity.notFound().build();  // Retourne 404 si le skieur n'est pas trouvé
        }
        return ResponseEntity.ok(skier);  // Retourne le skieur avec un code 200
    }

    @GetMapping("retrieveAll")
    public List<Skier> retrieveAllSkier() {
        return skierServices.retrieveAllSkier();
    }

    @DeleteMapping("remove/{numSkier}")
    public void removeSkier(@PathVariable long numSkier) {
        skierServices.removeSkier(numSkier);
    }

    @GetMapping("search")
    public List<Skier> searchSkierByName(@RequestParam String firstName, @RequestParam String lastName) {
        return skierServices.retrieveSkierByName(firstName, lastName);
    }
    @PostMapping("add-skier-course/{numCourse}")
    public Skier addSkierAndAssignToCourse(
            @RequestBody  Skier skier, @PathVariable(name = "numCourse") Long numCourse
    ){
        return skierServices.addSkierAndAssignToCourse(skier, numCourse);
    }
    @GetMapping("bySubscription/{type}")
    public List<Skier> retrieveSkiersBySubscriptionType(@PathVariable TypeSubscription type) {
        return skierServices.retrieveSkiersBySubscriptionType(type);
    }
}
