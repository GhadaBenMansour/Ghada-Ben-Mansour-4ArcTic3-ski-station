package tn.esprit.ghadabenmansour_4arctic3.services;

import tn.esprit.ghadabenmansour_4arctic3.entities.Piste;

import java.util.List;

public interface IPisteServices {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste deletePiste(Long numPiste);
    Piste retrievePiste(Long numPiste);
    List<Piste> getretrievePistes();
}
