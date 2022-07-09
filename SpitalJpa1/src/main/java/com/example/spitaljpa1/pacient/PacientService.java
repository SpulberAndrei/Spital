package com.example.spitaljpa1.pacient;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spitaljpa1.errors.Validate.validateNumarTelefonPacient;

@Service
public class PacientService {
    private final IPacientRepository pacientRepository;

    public PacientService(IPacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    public List<Pacient> getPacienti() {
        return pacientRepository.findAll();
    }

    public void createPacient(Pacient pacient) {
        validateNumarTelefonPacient(pacient.getNumarTelefon());
        pacientRepository.save(pacient);
    }

    public void deletePacient(Long pacientId) {
        pacientRepository.deleteById(pacientId);
    }

    public void updatePacient(Long pacientId, Pacient pacient) {
        Pacient pacientToUpdate = pacientRepository.findById(pacientId).orElseThrow(
                () -> new IllegalArgumentException("Invalid angajat id"));
        pacientToUpdate.setNumePacient(pacient.getNumePacient());
        pacientToUpdate.setPrenumePacient(pacient.getPrenumePacient());
        pacientToUpdate.setNumarTelefon(pacient.getNumarTelefon());
        pacientToUpdate.setSex(pacient.getSex());
        pacientToUpdate.setVarsta(pacient.getVarsta());
        validateNumarTelefonPacient(pacient.getNumarTelefon());
        pacientRepository.save(pacientToUpdate);
    }
}
