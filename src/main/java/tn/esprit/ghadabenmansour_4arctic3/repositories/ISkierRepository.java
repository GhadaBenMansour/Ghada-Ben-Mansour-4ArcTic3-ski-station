package tn.esprit.ghadabenmansour_4arctic3.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ghadabenmansour_4arctic3.entities.Skier;
import tn.esprit.ghadabenmansour_4arctic3.entities.TypeSubscription;

import java.util.List;

public interface ISkierRepository  extends CrudRepository<Skier, Long> {
    List<Skier> findByFirstNameAndLastName(String fname, String lname);
    List<Skier> findBySubscriptionType(TypeSubscription typeSubscription);
}
