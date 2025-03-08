package tn.esprit.ghadabenmansour_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ghadabenmansour_4arctic3.entities.Skier;
import tn.esprit.ghadabenmansour_4arctic3.repositories.ISkierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkierServices implements ISkierServices {

    @Autowired
    private ISkierRepository skierRepository;

    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(long numSkier) {
        Optional<Skier> skier = skierRepository.findById(numSkier);
        return skier.orElse(null);
    }

    @Override
    public List<Skier> retrieveAllSkier() {
        return (List<Skier>) skierRepository.findAll();
    }

    @Override
    public void removeSkier(Long numSkier) {
        skierRepository.deleteById(numSkier);
    }
    @Override
    public List<Skier> retrieveSkierByName(String fname, String lname) {
        return skierRepository.findByFirstNameAndLastName(fname, lname);
    }
}
