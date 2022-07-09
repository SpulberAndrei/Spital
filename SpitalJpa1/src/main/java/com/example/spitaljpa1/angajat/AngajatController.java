package com.example.spitaljpa1.angajat;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequestMapping("/angajati")
public class AngajatController {
    private final AngajatService angajatService;

    public AngajatController(AngajatService angajatService) {
        this.angajatService = angajatService;
    }

    @GetMapping()
    public List<Angajat> getAngajati() {
        return angajatService.getAngajati();
    }

    @PostMapping()
    public ResponseEntity<String> createAngajat(@Valid @RequestBody AngajatDto angajat) {
        Angajat angajatToBeCreated = new Angajat(angajat.getNumeAngajat(), angajat.getPrenumeAngajat(), angajat.getNumarTelefon(),
                angajat.getEmail(), angajat.getSalariu(), angajat.getFunctieId(), angajat.getSectieId());
        angajatService.createAngajat(angajatToBeCreated);
        return ResponseEntity.ok("Angajat was created");
    }

    @DeleteMapping("/{angajatId}")
    public ResponseEntity<String> deleteAngajat(@PathVariable Long angajatId) {
        angajatService.deleteAngajat(angajatId);
        return ResponseEntity.ok("Angajat was deleted");
    }

    @PutMapping("/{angajatId}")
    public ResponseEntity<String> updateAngajat(@PathVariable Long angajatId, @RequestBody Angajat angajat) {
        angajatService.updateAngajat(angajatId, angajat);
        return ResponseEntity.ok("Angajat was updated");
    }
}
