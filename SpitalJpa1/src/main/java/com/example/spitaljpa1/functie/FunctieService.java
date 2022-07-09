package com.example.spitaljpa1.functie;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spitaljpa1.errors.Validate.validateNumeFunctie;

@Service
public class FunctieService {

    private final IFunctieRepository functieRepository;

    public FunctieService(IFunctieRepository functieRepository) {
        this.functieRepository = functieRepository;
    }

    public List<Functie> getFunctii() {
        return functieRepository.findAll();
    }

    public void createFunctie(Functie functie) {
        validateNumeFunctie(functie.getNumeFunctie());
        functieRepository.save(functie);
    }

    public void deleteFunctie(Long functieId) {
        functieRepository.deleteById(functieId);
    }

    public void updateFunctie(Long functieId, Functie functie) {
        Functie functieUpdate = functieRepository.findById(functieId).orElseThrow(
                () -> new IllegalArgumentException("This function id does not exist"));
        functieUpdate.setNumeFunctie(functie.getNumeFunctie());
        validateNumeFunctie(functie.getNumeFunctie());
        functieRepository.save(functieUpdate);
    }
}
