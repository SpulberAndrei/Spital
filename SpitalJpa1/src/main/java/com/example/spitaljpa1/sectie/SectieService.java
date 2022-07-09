package com.example.spitaljpa1.sectie;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spitaljpa1.errors.Validate.validateNumeSectie;

@Service
public class SectieService {
    private final ISectieRepository sectieRepository;

    public SectieService(ISectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }

    public List<Sectie> getSectii() {
        return sectieRepository.findAll();
    }

    public void createSectie(Sectie sectie) {
        validateNumeSectie(sectie.getNumeSectie());
        sectieRepository.save(sectie);
    }

    public void deleteSectie(Long sectieId){
        sectieRepository.deleteById(sectieId);
    }

    public void updateSectie(Long sectieId, Sectie sectie) {
        Sectie sectieToUpdate = sectieRepository.findById(sectieId).orElseThrow(
                () -> new IllegalArgumentException("Invalid sectie id"));
        sectieToUpdate.setNumeSectie(sectie.getNumeSectie());
        sectieToUpdate.setLocDisponibil(sectie.getLocDisponibil());
        validateNumeSectie(sectie.getNumeSectie());
        sectieRepository.save(sectieToUpdate);
    }

}
