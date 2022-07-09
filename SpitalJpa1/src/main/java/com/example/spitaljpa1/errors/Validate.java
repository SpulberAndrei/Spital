package com.example.spitaljpa1.errors;

import com.example.spitaljpa1.angajat.Angajat;
import com.example.spitaljpa1.angajat.IAngajatRepository;
import com.example.spitaljpa1.functie.Functie;
import com.example.spitaljpa1.functie.IFunctieRepository;
import com.example.spitaljpa1.pacient.IPacientRepository;
import com.example.spitaljpa1.pacient.Pacient;
import com.example.spitaljpa1.sectie.ISectieRepository;
import com.example.spitaljpa1.sectie.Sectie;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Validate {
    private static IAngajatRepository angajatRepository;
    private static IFunctieRepository functieRepository;
    private static IPacientRepository pacientRepository;
    private static ISectieRepository sectieRepository;

    public Validate(IAngajatRepository angajatRepository, IFunctieRepository functieRepository, IPacientRepository pacientRepository, ISectieRepository sectieRepository) {
        Validate.angajatRepository = angajatRepository;
        Validate.functieRepository = functieRepository;
        Validate.pacientRepository = pacientRepository;
        Validate.sectieRepository = sectieRepository;
    }


    public static void validateEmail(String email) {
        Optional<Angajat> angajatEmail = angajatRepository.findAngajatByEmail(email);
        if (angajatEmail.isPresent()) {
            throw new UniqueFieldException("Email must be unique");
        }
    }
    public static void validateNumarTelefonAngajat(String numarTelefon) {
        Optional<Angajat> angajatNumarTelefon = angajatRepository.findAngajatByNumarTelefon(numarTelefon);
        if (angajatNumarTelefon.isPresent()) {
            throw new UniqueFieldException("Phone number must be unique");
        }
    }

    public static void validateNumeFunctie(String numeFunctie) {
        Optional<Functie> functieNume = functieRepository.findFunctieByNumeFunctie(numeFunctie);
        if (functieNume.isPresent()) {
            throw new UniqueFieldException("Nume functie must be unique");
        }
    }

    public static void validateNumarTelefonPacient(String numarTelefon) {
        Optional<Pacient> pacientNumarTelefon = pacientRepository.findPacientByNumarTelefon(numarTelefon);
        if (pacientNumarTelefon.isPresent()) {
            throw new UniqueFieldException("Phone number must be unique");
        }
    }
    public static void validateNumeSectie(String numeSectie) {
        Optional<Sectie> sectieNume = sectieRepository.findSectieByNumeSectie(numeSectie);
        if (sectieNume.isPresent()) {
            throw new UniqueFieldException("Nume sectie must be unique");
        }
    }
    //validari cu adnotari (cauta dependintele bune )
    //
}
