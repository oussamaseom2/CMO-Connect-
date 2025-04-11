package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.Chapitre;
import com.cmoconnect.backendweb.service.ChapitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapitres")
public class ChapitreController {

    @Autowired
    private ChapitreService chapitreService;

    @PostMapping("/")
    public ResponseEntity<Chapitre> createChapitre(@RequestBody Chapitre chapitre) {
        return ResponseEntity.ok(chapitreService.createChapitre(chapitre));
    }

    @GetMapping("/")
    public ResponseEntity<List<Chapitre>> getAllChapitres() {
        return ResponseEntity.ok(chapitreService.getAllChapitres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapitre> getChapitreById(@PathVariable Long id) {
        return ResponseEntity.ok(chapitreService.getChapitreById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chapitre> updateChapitre(@PathVariable Long id, @RequestBody Chapitre chapitre) {
        return ResponseEntity.ok(chapitreService.updateChapitre(id, chapitre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapitre(@PathVariable Long id) {
        chapitreService.deleteChapitre(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/formation/{formationId}")
    public ResponseEntity<List<Chapitre>> getChapitresByFormation(@PathVariable Long formationId) {
        return ResponseEntity.ok(chapitreService.getChapitresByFormation(formationId));
    }
} 