package com.example.spitaljpa1.consultatie;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultatieService {
    private final IConsultatieRepository consultatieRepository;

    public ConsultatieService(IConsultatieRepository consultatieRepository) {
        this.consultatieRepository = consultatieRepository;
    }

    public List<Consultatie> getConsultatii() {
        return consultatieRepository.findAll();
    }

    public void createConsultatie(Consultatie consultatie) {
        consultatieRepository.save(consultatie);
    }

    public void deleteConsultatie(Long consultatieId) {
        consultatieRepository.deleteById(consultatieId);
    }

    public void updateConsultatie(Long consultatieId, Consultatie consultatie) {
        Consultatie consultatieUpdate = consultatieRepository.findById(consultatieId).orElseThrow(
                () -> new IllegalArgumentException("This consultatie id does not exist"));
        consultatieUpdate.setAngajatId(consultatie.getAngajatId());
        consultatieUpdate.setPacientId(consultatie.getPacientId());
        consultatieUpdate.setSectieId(consultatie.getSectieId());
        consultatieRepository.save(consultatieUpdate);
    }
}
