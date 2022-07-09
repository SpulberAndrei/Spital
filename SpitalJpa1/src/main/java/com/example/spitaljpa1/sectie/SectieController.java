package com.example.spitaljpa1.sectie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectii")
public class SectieController {
    private final SectieService sectieService;

    public SectieController(SectieService sectieService) {
        this.sectieService = sectieService;
    }

    @GetMapping()
    public List<Sectie> getSectii() {
        return sectieService.getSectii();
    }

    @PostMapping()
    public ResponseEntity<String> createSectii(@RequestBody SectieDto sectie) {
        Sectie sectieToBeCreated = new Sectie(sectie.getNumeSectie(),sectie.getLocDisponibil());
        sectieService.createSectie(sectieToBeCreated);
        return ResponseEntity.ok("Sectie was created");
    }

    @DeleteMapping("/{sectieId}")
    public ResponseEntity<String> deleteSectie(@PathVariable Long sectieId) {
        sectieService.deleteSectie(sectieId);
        return ResponseEntity.ok("Sectie was deleted");
    }

    @PutMapping("/{sectieId}")
    public ResponseEntity<String> updateSectie(@PathVariable Long sectieId, @RequestBody Sectie sectie) {
        sectieService.updateSectie(sectieId, sectie);
        return ResponseEntity.ok("Sectie was updated");
    }
}
