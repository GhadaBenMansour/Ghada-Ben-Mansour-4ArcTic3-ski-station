package tn.esprit.ghadabenmansour_4arctic3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ghadabenmansour_4arctic3.entities.Piste;
import tn.esprit.ghadabenmansour_4arctic3.entities.Skier;
import tn.esprit.ghadabenmansour_4arctic3.repositories.IPisteRepository;
import tn.esprit.ghadabenmansour_4arctic3.repositories.ISkierRepository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class PisteServices implements IPisteServices{

    @Autowired
    private IPisteRepository pisteRepository;
    private ISkierRepository skierRepository;

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        if (pisteRepository.existsById(piste.getNumPiste())) {
            return pisteRepository.save(piste);
        }
        return null;
    }

    @Override
    public Piste deletePiste(Long numPiste) {
        Optional<Piste> piste = pisteRepository.findById(numPiste);
        if (piste.isPresent()) {
            pisteRepository.delete(piste.get());
            return piste.get();
        }
        return null;
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        Optional<Piste> piste = pisteRepository.findById(numPiste);
        return piste.orElse(null);
    }

    @Override
    public List<Piste> getretrievePistes() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public Piste assignToSkier(long numPiste, long numSkier) {
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        piste.getSkiers().add(skier);
        return null;
    }


}
