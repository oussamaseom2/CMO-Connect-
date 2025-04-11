package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.FormationUtilisateur;
import com.cmoconnect.backendweb.service.FormationUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formation-utilisateurs")
public class FormationUtilisateurController {

    @Autowired
    private FormationUtilisateurService formationUtilisateurService;

    @PostMapping("/")
    public ResponseEntity<FormationUtilisateur> createFormationUtilisateur(@RequestBody FormationUtilisateur formationUtilisateur) {
        return ResponseEntity.ok(formationUtilisateurService.createFormationUtilisateur(formationUtilisateur));
    }

    @GetMapping("/")
    public ResponseEntity<List<FormationUtilisateur>> getAllFormationUtilisateurs() {
        return ResponseEntity.ok(formationUtilisateurService.getAllFormationUtilisateurs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationUtilisateur> getFormationUtilisateurById(@PathVariable Long id) {
        return ResponseEntity.ok(formationUtilisateurService.getFormationUtilisateurById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationUtilisateur> updateFormationUtilisateur(@PathVariable Long id, @RequestBody FormationUtilisateur formationUtilisateur) {
        return ResponseEntity.ok(formationUtilisateurService.updateFormationUtilisateur(id, formationUtilisateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormationUtilisateur(@PathVariable Long id) {
        formationUtilisateurService.deleteFormationUtilisateur(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<FormationUtilisateur>> getFormationsByUtilisateur(@PathVariable Long utilisateurId) {
        return ResponseEntity.ok(formationUtilisateurService.getFormationsByUtilisateur(utilisateurId));
    }

    @GetMapping("/formation/{formationId}")
    public ResponseEntity<List<FormationUtilisateur>> getUtilisateursByFormation(@PathVariable Long formationId) {
        return ResponseEntity.ok(formationUtilisateurService.getUtilisateursByFormation(formationId));
    }
} 