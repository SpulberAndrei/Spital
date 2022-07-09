package com.example.spitaljpa1.angajat;

import com.example.spitaljpa1.errors.Validate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spitaljpa1.errors.Validate.*;

@Service
public class AngajatService {
    private final IAngajatRepository angajatRepository;

    public AngajatService(IAngajatRepository angajatRepository) {
        this.angajatRepository = angajatRepository;
    }

    public List<Angajat> getAngajati() {
        return angajatRepository.findAll();
    }

    public void createAngajat(Angajat angajat) {
        validateEmail(angajat.getEmail());
        validateNumarTelefonAngajat(angajat.getNumarTelefon());
        angajatRepository.save(angajat);
    }

    public void deleteAngajat(Long angajatId) {
        angajatRepository.deleteById(angajatId);
    }

    public void updateAngajat(Long angajatId, Angajat angajat) {
        Angajat angajatUpdate = angajatRepository.findById(angajatId).orElseThrow(
                () -> new IllegalArgumentException("Invalid angajat id"));
        angajatUpdate.setNumeAngajat(angajat.getNumeAngajat());
        angajatUpdate.setPrenumeAngajat(angajat.getPrenumeAngajat());
        angajatUpdate.setEmail(angajat.getEmail());
        angajatUpdate.setFunctieId(angajat.getFunctieId());
        angajatUpdate.setSalariu(angajat.getSalariu());
        angajatUpdate.setNumarTelefon(angajat.getNumarTelefon());
        angajatUpdate.setSectieId(angajat.getSectieId());
        validateEmail(angajat.getEmail());
        validateNumarTelefonAngajat(angajat.getNumarTelefon());
        angajatRepository.save(angajatUpdate);
    }
}
