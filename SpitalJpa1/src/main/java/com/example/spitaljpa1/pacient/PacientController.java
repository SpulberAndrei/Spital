package com.example.spitaljpa1.pacient;

import com.example.spitaljpa1.consultatie.ConsultatieDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacienti")
public class PacientController {
    private final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping()
    public List<Pacient> getPacient() {
        return pacientService.getPacienti();
    }

    @PostMapping()
    public ResponseEntity<String> createPacient(@RequestBody PacientDto pacient) {
        Pacient pacientToBeCreated = new Pacient(pacient.getNumePacient(), pacient.getPrenumePacient(), pacient.getVarsta()
                , pacient.getSex(), pacient.getNumarTelefon());
        pacientService.createPacient(pacientToBeCreated);
        return ResponseEntity.ok("Pacient was created");
    }

    @DeleteMapping("/{pacientId}")
    public ResponseEntity<String> deletePacient(@PathVariable Long pacientId) {
        pacientService.deletePacient(pacientId);
        return ResponseEntity.ok("Pacient was deleted");
    }

    @PutMapping("/{pacientId}")
    public ResponseEntity<String> updatePacient(@PathVariable Long pacientId, @RequestBody Pacient pacient) {
        pacientService.updatePacient(pacientId, pacient);
        return ResponseEntity.ok("Pacient was updated");
    }
}
