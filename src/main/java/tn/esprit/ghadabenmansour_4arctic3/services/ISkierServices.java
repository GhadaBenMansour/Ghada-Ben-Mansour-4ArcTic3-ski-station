package tn.esprit.ghadabenmansour_4arctic3.services;

import tn.esprit.ghadabenmansour_4arctic3.entities.Skier;
import tn.esprit.ghadabenmansour_4arctic3.entities.TypeSubscription;

import java.util.List;

public interface ISkierServices {
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    Skier retrieveSkier(long numSkier);
    List<Skier> retrieveAllSkier();
    void removeSkier(Long numSkier);
    List<Skier> retrieveSkierByName(String firstName, String lastName);
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
    List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription);


}
