package com.example.spitaljpa1.consultatie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultatii")
public class ConsultatieController {
    private final ConsultatieService consultatieService;

    public ConsultatieController(ConsultatieService consultatieService) {
        this.consultatieService = consultatieService;
    }

    @GetMapping
    public List<Consultatie> getConsultatii() {
        return consultatieService.getConsultatii();
    }

    @PostMapping
    public ResponseEntity<String> createConsultatie(@RequestBody ConsultatieDto consultatie) {
        Consultatie consultatieToBeCreated = new Consultatie(consultatie.getSectieId(), consultatie.getAngajatId(),
                consultatie.getPacientId());
        consultatieService.createConsultatie(consultatieToBeCreated);
        return ResponseEntity.ok("Consultatie was created");
    }

    @DeleteMapping("/{consultatieId}")
    public ResponseEntity<String> deleteConsultatie(@PathVariable Long consultatieId) {
        consultatieService.deleteConsultatie(consultatieId);
        return ResponseEntity.ok("Consultatie was deleted");
    }

    @PutMapping("/{consultatieId}")
    public ResponseEntity<String> updateConsultatie(@PathVariable Long consultatieId,@RequestBody Consultatie consultatie) {
        consultatieService.updateConsultatie(consultatieId, consultatie);
        return ResponseEntity.ok("Consultatie was updated");
    }
}
