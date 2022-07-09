package com.example.spitaljpa1.functie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/functii")
public class FunctieController {
    private final FunctieService functieService;

    public FunctieController(FunctieService functieService) {
        this.functieService = functieService;
    }

    @GetMapping
    public List<Functie> getFunctii() {
        return functieService.getFunctii();
    }

    @PostMapping
    public ResponseEntity<String> createFunctie(@RequestBody FunctieDto functie) {
        Functie functieToBeCreated = new Functie(functie.getNumeFunctie());
        functieService.createFunctie(functieToBeCreated);
        return ResponseEntity.ok("Functie was created");
    }

    @DeleteMapping("/{functieId}")
    public ResponseEntity<String> deleteFunctie(@PathVariable Long functieId) {
        functieService.deleteFunctie(functieId);
        return ResponseEntity.ok("Functie was deleted");
    }

    @PutMapping("/{functieId}")
    public ResponseEntity<String> updateFunctie(@PathVariable Long functieId, @RequestBody Functie functie) {
        functieService.updateFunctie(functieId, functie);
        return ResponseEntity.ok("Functie was updated");
    }
}
